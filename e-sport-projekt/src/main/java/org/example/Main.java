package org.example;


import entiteti.*;
import exception.TimException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDate;
import java.util.*;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Set<Timovi> pobjedniciSet = new HashSet<>();

        LocalDate datum = LocalDate.now();

        List<Igraci> igraci_team1_csgo = Arrays.asList(
                new Igraci("John", "Wade", 25, "England", 1),
                new Igraci("Stephen", "Anderson", 22, "Wales", 2),
                new Igraci("Ben", "Linus", 28, "Britain", 5),
                new Igraci("Jack", "Shephard", 28, "Britain", 6),
                new Igraci("Kate", "Austen", 28, "Britain", 4)
        );


        List<Igraci> igraci_team2_csgo = Arrays.asList(
                new Igraci("John", "Wade", 25, "England", 1),
                new Igraci("Stephen", "Anderson", 22, "Wales", 2),
                new Igraci("Ben", "Linus", 28, "Britain", 5),
                new Igraci("Jack", "Shephard", 28, "Britain", 6),
                new Igraci("Kate", "Austen", 28, "Britain", 4)
        );

        List<Igraci> igraci_team3_csgo = Arrays.asList(
                new Igraci("John", "Wade", 25, "England", 1),
                new Igraci("Stephen", "Anderson", 22, "Wales", 2),
                new Igraci("Ben", "Linus", 28, "Britain", 5),
                new Igraci("Jack", "Shephard", 28, "Britain", 6),
                new Igraci("Kate", "Austen", 28, "Britain", 4)
        );


        List<Igraci> igraci_team4_csgo = Arrays.asList(
                new Igraci("John", "Wade", 25, "England", 1),
                new Igraci("Stephen", "Anderson", 22, "Wales", 2),
                new Igraci("Ben", "Linus", 28, "Britain", 5),
                new Igraci("Jack", "Shephard", 28, "Britain", 6),
                new Igraci("Kate", "Austen", 28, "Britain", 4)
        );


        List<Igraci> igraci_team1_LOL = Arrays.asList(
                new Igraci("John", "Wade", 25, "England", 1),
                new Igraci("Stephen", "Anderson", 22, "Wales", 2),
                new Igraci("Ben", "Linus", 28, "Britain", 5),
                new Igraci("Jack", "Shephard", 28, "Britain", 6),
                new Igraci("Kate", "Austen", 28, "Britain", 4)
        );

        List<Igraci> igraci_team2_LOL = Arrays.asList(
                new Igraci("John", "Wade", 25, "England", 1),
                new Igraci("Stephen", "Anderson", 22, "Wales", 2),
                new Igraci("Ben", "Linus", 28, "Britain", 5),
                new Igraci("Jack", "Shephard", 28, "Britain", 6),
                new Igraci("Kate", "Austen", 28, "Britain", 4)
        );


        List<Igraci> igraci_team3_LOL = Arrays.asList(
                new Igraci("John", "Wade", 25, "England", 1),
                new Igraci("Stephen", "Anderson", 22, "Wales", 2),
                new Igraci("Ben", "Linus", 28, "Britain", 5),
                new Igraci("Jack", "Shephard", 28, "Britain", 6),
                new Igraci("Kate", "Austen", 28, "Britain", 4)
        );



        List<Igraci> igraci_team4_LOL = Arrays.asList(
                new Igraci("John", "Wade", 25, "England", 1),
                new Igraci("Stephen", "Anderson", 22, "Wales", 2),
                new Igraci("Ben", "Linus", 28, "Britain", 5),
                new Igraci("Jack", "Shephard", 28, "Britain", 6),
                new Igraci("Kate", "Austen", 28, "Britain", 4)
        );


        Timovi tim1 = new Timovi("Team A", "German");
        Timovi tim2 = new Timovi("Team B", "England");
        Timovi tim3 = new Timovi("Team C", "Netherlands");
        Timovi tim4 = new Timovi("Team D", "Croatia");

        Timovi tim5 = new Timovi("Team E", "Hungary");
        Timovi tim6 = new Timovi("Team F", "Wales");
        Timovi tim7 = new Timovi("Team G", "Slovenia");
        Timovi tim8 = new Timovi("Team H", "Slovakia");


        try {
            igraci_team1_csgo.forEach(tim1::formTeam);
            igraci_team2_csgo.forEach(tim2::formTeam);
            igraci_team3_csgo.forEach(tim3::formTeam);
            igraci_team4_csgo.forEach(tim4::formTeam);
            igraci_team1_LOL.forEach(tim5::formTeam);
            igraci_team2_LOL.forEach(tim6::formTeam);
            igraci_team3_LOL.forEach(tim7::formTeam);
            igraci_team4_LOL.forEach(tim8::formTeam);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            logger.error(e.getMessage());
            return;
        }


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

        Scores score_1_semiCSGO=new Scores(13,3);
        Scores score_2_semiCSGO=new Scores(13,12);
        Scores score_finalCSGO=new Scores(13,7);

        Match match_semi1_csgo=new Match(tim1,tim2,datum, Esport.CSGO,score_1_semiCSGO);
        Match match_semi2_csgo=new Match(tim3,tim4,datum, Esport.CSGO,score_2_semiCSGO);
        Match match_final_csgo=new Match(tim1,tim3,datum, Esport.CSGO,score_finalCSGO);


        Scores score_1_semiLOL=new Scores(3,0);
        Scores score_2_semiLOL=new Scores(1,3);
        Scores score_finalLOL=new Scores(3,1);

        Match match_semi1_LOL=new Match(tim5,tim6,datum, Esport.LOL,score_1_semiLOL);
        Match match_semi2_LOL=new Match(tim7,tim8,datum, Esport.LOL,score_2_semiLOL);
        Match match_final_LOL=new Match(tim5,tim8,datum, Esport.LOL,score_finalLOL);

        Set<Match> matches=new HashSet<>();
        matches.add(match_semi1_csgo);
        matches.add(match_semi2_csgo);
        matches.add(match_final_csgo);
        matches.add(match_semi1_LOL);
        matches.add(match_semi2_LOL);
        matches.add(match_final_LOL);

        NajzanimljivijiMatch<Match> find=new NajzanimljivijiMatch<>(matches);
        Match najzanimljiviji=find.pronadjiNajzanimljivijiMatch();

        System.out.println("Najzanimljiviji mec se odigrao izmedu timova:" +najzanimljiviji.getTim1().getTeamName()+" vs "+ najzanimljiviji.getTim2().getTeamName()+" u igri "+najzanimljiviji.getIgra());




    }

    }
