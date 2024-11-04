package utils;

import Serialization.Change;
import Serialization.ChangeLogger;
import entiteti.Igraci;
import entiteti.Timovi;
import exception.PlayerException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import static Main.Main.logger;

public class Database {


    private static final String DATABASE_FILE = "config/database.config";
    private static Connection connectToDatabase() throws SQLException, IOException {

        Properties svojstva = new Properties();
        svojstva.load(new FileReader(DATABASE_FILE));
        String urlBazePodataka = svojstva.getProperty("Url");
        String korisnickoIme = svojstva.getProperty("username");
        String lozinka = svojstva.getProperty("password");
        Connection veza = DriverManager.getConnection(urlBazePodataka,
                korisnickoIme,lozinka);


        return veza;
    }


    public static List<Timovi> GetTeams(){

        List<Timovi> teams=new ArrayList<>();

        try{
            Connection connection=connectToDatabase();
            String query="SELECT * FROM TIMOVI";
            Statement stmt=connection.createStatement();
            stmt.execute(query);
            ResultSet rs= stmt.getResultSet();

            while(rs.next()){
                String team_name=rs.getString("team_name");
                String team_nationality=rs.getString("team_nationality");
                Integer broj_pobjeda=rs.getInt("broj_pobjeda");


                Timovi tim=new Timovi(team_name,team_nationality,broj_pobjeda);

                teams.add(tim);
            }
        }catch (SQLException | IOException e){

            System.out.println(e.getMessage());
            logger.error("Pogreska kod spajanja na bazu");
        }

        return teams;
    }



    public static List<Igraci> GetPlayers(){

        List<Igraci> igraci=new ArrayList<>();

            try {
                Connection connection = connectToDatabase();
                String query = "SELECT * FROM IGRACI";
                Statement stmt = connection.createStatement();
                stmt.execute(query);
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {

                    String ime = rs.getString("ime");
                    String prezime = rs.getString("prezime");
                    Integer godine = rs.getInt("godine");
                    String nacionalnost = rs.getString("nacionalnost");
                    Integer id = rs.getInt("id");


                    Igraci players = new Igraci(ime, prezime, godine, nacionalnost, id);

                    igraci.add(players);
                }
            } catch (SQLException | IOException e) {

                System.out.println(e.getMessage());
                logger.error("Pogreska kod spajanja na bazu");
            }

        return igraci;
    }


    static boolean saveSuccessful=false;

    public  static void savePlayer(Set<Igraci> igraci) {
        try (Connection connection = connectToDatabase()) {



            for (Igraci igrac : igraci) {
                String insertCarSql = "INSERT INTO IGRACI (IME, PREZIME, GODINE, NACIONALNOST, ID) VALUES (?, ?, ?, ?, ?);";
                try (PreparedStatement pstmt = connection.prepareStatement(insertCarSql)) {
                    pstmt.setString(1, igrac.getName());
                    pstmt.setString(2, igrac.getSurname());
                    pstmt.setInt(3, igrac.getAge());
                    pstmt.setString(4, igrac.getNationality());
                    pstmt.setInt(5, igrac.getId());
                    pstmt.execute();

                    saveSuccessful = true;
                }
            }

        } catch (SQLException | IOException | PlayerException ex) {
            String message = "Dogodila se pogreska kod spremanja podataka u bazu!";
            String message2="Postavite drugi ID!";
            logger.error(message, ex);
            logger.error(message2,ex);

            System.out.println(message);
            System.out.println(message2);

        }

    }

    public static boolean isSaveSuccessful() {
        return saveSuccessful;
    }


    public static void deletePlayer(Igraci igrac) {

        try (Connection connection = connectToDatabase()) {
            String deletePlayerSql = "DELETE FROM IGRACI WHERE ID = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(deletePlayerSql)) {
                pstmt.setInt(1, igrac.getId());
                pstmt.executeUpdate();

                ChangeLogger.logChange(new Change("Player", igrac.toString(), "Deleted", "Admin", LocalDateTime.now()));
            }
        } catch (SQLException | IOException ex) {
            String message = "Dogodila se pogreška pri brisanju igrača iz baze podataka!";
            logger.error(message, ex);
            System.out.println(message);
        }
    }





    public static void updatePlayer(Igraci player) {

        String updateSql = "UPDATE IGRACI SET IME = ?, PREZIME = ?, GODINE = ?, NACIONALNOST = ? WHERE ID = ?";

        try (Connection connection = connectToDatabase();
             PreparedStatement pstmt = connection.prepareStatement(updateSql)) {
            pstmt.setString(1, player.getName());
            pstmt.setString(2, player.getSurname());
            pstmt.setInt(3, player.getAge());
            pstmt.setString(4, player.getNationality());
            pstmt.setInt(5, player.getId());
            pstmt.executeUpdate();
        } catch (SQLException | IOException ex) {
            String message = "Dogodila se pogreska kod ažuriranja podataka u bazi!";
            logger.error(message, ex);
            System.out.println(message);
        }
    }



    public static Igraci getOldestPlayer() {

        Igraci najstarijiIgrac = null;

        try (Connection connection = connectToDatabase();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Igraci ORDER BY GODINE DESC LIMIT 1")) {

            if (resultSet.next()) {
                najstarijiIgrac = new Igraci(
                        resultSet.getString("ime"),
                        resultSet.getString("prezime"),
                        resultSet.getInt("godine"),
                        resultSet.getString("nacionalnost"),
                        resultSet.getInt("id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return najstarijiIgrac;
    }

}
