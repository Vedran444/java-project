package Main;


import entiteti.*;
import exception.PlayerException;
import exception.TimException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDate;
import java.util.*;


public class Main {

    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


        LocalDate datum = LocalDate.now();


         List<Igraci>igraci_team1_csgo = Arrays.asList(


                new Igraci("John", "Wade", 25, "England", 1),
                new Igraci("Stephen", "Anderson", 22, "Wales", 2),
                new Igraci("Ben", "Linus", 28, "Britain", 3),
                new Igraci("Jack", "Shephard", 34, "Britain", 4),
                new Igraci("Kate", "Austen", 18, "Britain", 5)
                );

        List<Igraci> igraci_team2_csgo = Arrays.asList(
                new Igraci("Erminio", "Meztli", 19, "Italy", 6),
                new Igraci("Navin", "Wil", 33, "Wales", 7),
                new Igraci("Ben", "Linus", 21, "Netherlands", 8),
                new Igraci("Jack", "Shephard", 25, "Germany", 9),
                new Igraci("Kate", "Austen", 28, "USA", 10)
        );

        List<Igraci> igraci_team3_csgo = Arrays.asList(
                new Igraci("John", "Wade", 44, "Poland", 11),
                new Igraci("Stephen", "Anderson", 32, "Lithuania", 12),
                new Igraci("Ben", "Linus", 25, "Hungary", 13),
                new Igraci("Jack", "Shephard", 17, "Norway", 14),
                new Igraci("Kate", "Austen", 16, "Sweden", 15)
        );


        List<Igraci> igraci_team4_csgo = Arrays.asList(
                new Igraci("John", "Wade", 43, "Finland", 16),
                new Igraci("Stephen", "Anderson", 32, "Ireland", 17),
                new Igraci("Ben", "Linus", 31, "Albania", 18),
                new Igraci("Jack", "Shephard", 30, "Switzerland", 19),
                new Igraci("Kate", "Austen", 40, "Slovenia", 20)
        );


        List<Igraci> igraci_team1_LOL = Arrays.asList(
                new Igraci("John", "Wade", 24, "England", 21),
                new Igraci("Stephen", "Anderson", 22, "Guatemala", 22),
                new Igraci("Ben", "Linus", 46, "Germany", 23),
                new Igraci("Jack", "Shephard", 22, "Iceland", 24),
                new Igraci("Kate", "Austen", 31, "France", 25)
        );

        List<Igraci> igraci_team2_LOL = Arrays.asList(
                new Igraci("John", "Wade", 33, "Brazil", 26),
                new Igraci("Stephen", "Anderson", 43, "Pakistan", 27),
                new Igraci("Ben", "Linus", 32, "Japan", 28),
                new Igraci("Jack", "Shephard", 19, "China", 29),
                new Igraci("Kate", "Austen", 20, "Russia", 30)
        );


        List<Igraci> igraci_team3_LOL = Arrays.asList(
                new Igraci("John", "Wade", 42, "Greece", 31),
                new Igraci("Stephen", "Anderson", 35, "Austria", 32),
                new Igraci("Ben", "Linus", 33, "Panama", 33),
                new Igraci("Jack", "Shephard", 18, "El Salvador", 34),
                new Igraci("Kate", "Austen", 22, "Montenegro", 35)
        );



        List<Igraci> igraci_team4_LOL = Arrays.asList(
                new Igraci("John", "Wade", 30, "England", 36),
                new Igraci("Stephen", "Anderson", 23, "Wales", 37),
                new Igraci("Ben", "Linus", 27, "Britain", 38),
                new Igraci("Jack", "Shephard", 28, "Britain", 39),
                new Igraci("Kate", "Austen", 37, "Britain", 40)
        );


        Timovi tim1 = new Timovi("Team Spirit", "German", 0);
        Timovi tim2 = new Timovi("Team Faze", "England", 0);
        Timovi tim3 = new Timovi("Team Raptors", "Netherlands", 0);
        Timovi tim4 = new Timovi("Team G2", "Croatia", 0);

        Timovi tim5 = new Timovi("Team Helios", "Hungary", 0);
        Timovi tim6 = new Timovi("Team Vitality", "Wales", 0);
        Timovi tim7 = new Timovi("Team Kozel", "Slovenia", 0);
        Timovi tim8 = new Timovi("Team Slobodnik", "Slovakia", 0);


        CheckTeamsAndPlayers(igraci_team1_csgo, igraci_team2_csgo, igraci_team3_csgo, igraci_team4_csgo, tim1, tim2, tim3, tim4);
        CheckTeamsAndPlayers(igraci_team1_LOL, igraci_team2_LOL, igraci_team3_LOL, igraci_team4_LOL, tim5, tim6, tim7, tim8);


        try {
            tim1.checkTeamSize();
            tim2.checkTeamSize();
            tim3.checkTeamSize();
            tim4.checkTeamSize();
            tim5.checkTeamSize();
            tim6.checkTeamSize();
            tim7.checkTeamSize();
            tim8.checkTeamSize();
        } catch (TimException e) {

            System.out.println(e.getMessage());
            logger.error(e.getMessage());
            return;
        }


/*
        System.out.println("Detalji tima:");
        System.out.println("Ime tima: " + tim.getTeamName());
        System.out.println("Nacionalnost: " + tim.getTeamNationality());
        System.out.println("Broj osvojenih turnira: " + tim.getWonTournaments());

        System.out.println("\nIgrači u timu:");
        for (Igraci igrac : tim.getTim().values()) {
            System.out.println("Ime: " + igrac.getName() + ", Prezime: " + igrac.getSurname()
                    + ", Godine: " + igrac.getAge() + ", Država: " + igrac.getNationality());
        }

*/





        Turnir turnir = new Turnir.TurnirBuilder()
                .naziv("IEM Katowice")
                .igra(Esport.LOL)
                .brojTimova(16)
                .nagradniFond(20000)
                .build();


        turnir.showDetails();


        Scores score_1_semiCSGO=new Scores(13,3);
        Scores score_2_semiCSGO=new Scores(13,12);
        Scores score_finalCSGO=new Scores(13,7);

        Match match_semi1_csgo=new Match(tim1,tim2,datum, Esport.CSGO,score_1_semiCSGO);
        tim1.povecajBrojPobjeda();

        Match match_semi2_csgo=new Match(tim3,tim4,datum, Esport.CSGO,score_2_semiCSGO);
        tim3.povecajBrojPobjeda();

        Match match_final_csgo=new Match(tim1,tim3,datum, Esport.CSGO,score_finalCSGO);
        tim1.povecajBrojPobjeda();


        System.out.println("\nPobjednik CSGO turnira je: " +score_finalCSGO.getPobjednickiTim(tim1,tim3));


        Scores score_1_semiLOL=new Scores(3,0);
        Scores score_2_semiLOL=new Scores(1,3);
        Scores score_finalLOL=new Scores(3,1);

        Match match_semi1_LOL=new Match(tim5,tim6,datum, Esport.LOL,score_1_semiLOL);
        tim5.povecajBrojPobjeda();

        Match match_semi2_LOL=new Match(tim7,tim8,datum, Esport.LOL,score_2_semiLOL);
        tim8.povecajBrojPobjeda();

        Match match_final_LOL=new Match(tim5,tim8,datum, Esport.LOL,score_finalLOL);
        tim5.povecajBrojPobjeda();

        System.out.println("Pobjednik LOL turnira je: "+ score_finalLOL.getPobjednickiTim(tim5,tim8)+"\n");

        Set<Match> matches=new HashSet<>();
        matches.add(match_semi1_csgo);
        matches.add(match_semi2_csgo);
        matches.add(match_final_csgo);
        matches.add(match_semi1_LOL);
        matches.add(match_semi2_LOL);
        matches.add(match_final_LOL);


        NajzanimljivijiMatch<Match> najzanimljivijiMatch = new NajzanimljivijiMatch<>(matches);
        Par<Match, Integer> matchSaNajmanjomRazlikom = najzanimljivijiMatch.FindMatcWithMinimumDifference();

        System.out.println("Najzanimljiviji meč s najmanjom razlikom: " + matchSaNajmanjomRazlikom.getKey()
                + ", Razlika: " + matchSaNajmanjomRazlikom.getValue());



        List<Timovi>teams=new ArrayList<>();
        teams.add(tim1);
        teams.add(tim2);
        teams.add(tim3);
        teams.add(tim4);
        teams.add(tim5);
        teams.add(tim6);
        teams.add(tim7);
        teams.add(tim8);



        System.out.println("\nTimovi sortirani prema broju pobjeda:");
        teams.stream()
                .sorted(Comparator.comparingInt(Timovi::getBrojPobjeda))
                .forEach(tim -> System.out.println(tim.getTeamName() + " - Pobjede: " + tim.getBrojPobjeda()));




        for (Timovi tim : teams) {
            System.out.println("\nIgrači u timu " + tim.getTeamName() + " sortirani po starosti:");
            tim.getTim().values().stream()
                    .sorted(Comparator.comparingInt(Igraci::getAge))
                    .forEach(igrac -> System.out.println(igrac.getName() + " " + igrac.getSurname() + " - Godine: " + igrac.getAge()));
        }




        }

    private static void CheckTeamsAndPlayers(List<Igraci> igraci_team1_csgo, List<Igraci> igraci_team2_csgo, List<Igraci> igraci_team3_csgo, List<Igraci> igraci_team4_csgo, Timovi tim1, Timovi tim2, Timovi tim3, Timovi tim4) {

        igraci_team1_csgo.forEach(igrac -> {
            try {
                tim1.formTeam(igrac);
            } catch (PlayerException | TimException e) {
                logger.error(e.getMessage());
            }
        });
        igraci_team2_csgo.forEach(igrac -> {
            try {
                tim2.formTeam(igrac);
            } catch (PlayerException | TimException e) {
                logger.error(e.getMessage());
            }
        });
        igraci_team3_csgo.forEach(igrac -> {
            try {
                tim3.formTeam(igrac);
            } catch (PlayerException | TimException e) {
                logger.error(e.getMessage());
            }
        });
        igraci_team4_csgo.forEach(igrac -> {
            try {
                tim4.formTeam(igrac);
            } catch (PlayerException | TimException e) {
                logger.error(e.getMessage());
            }
        });
    }

}


