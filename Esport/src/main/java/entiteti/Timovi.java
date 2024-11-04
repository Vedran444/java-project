package entiteti;

import exception.PlayerException;
import exception.TimException;

import java.util.HashMap;
import java.util.Map;

import static Main.Main.logger;

public final class Timovi implements TeamManagement{


    private String teamName;

    private String teamNationality;


    private  int wins;

    private Map<Integer,Igraci> Tim=new HashMap<>();

    public Timovi(String teamName, String teamNationality, int wins) {
        this.teamName = teamName;
        this.teamNationality = teamNationality;
        this.wins=wins;
    }

    @Override
    public void formTeam(Igraci igrac) throws  RuntimeException,TimException {
        if (igrac != null && !Tim.containsKey(igrac.getId())) {
            Tim.put(igrac.getId(), igrac);

            } else{

            logger.info("Igraci ne mogu imati isti ID");
            throw new RuntimeException("Igraci ne mogu imati isti ID!");

        }

        if (igrac == null) {

            logger.info("Igrac mora postojati");
            throw new PlayerException("Igrac mora postojati!");
        }
        if (igrac.getName() == null || igrac.getName().isEmpty()) {

            logger.info("Igrac mora imati ime");
            throw new PlayerException("Igrac mora imati ime!");
        }
        if (igrac.getAge() <= 0) {

            logger.info("igrac ima neispravno unesene godine");
            throw new PlayerException("Neispravne godine!");
        }
    }


    public void checkTeamSize() throws TimException{

        if(Tim.size()!=5){

            logger.info("Neispravna velicina tima");
            throw new TimException("U timu mora biti 5 igraca!");

        }
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamNationality() {
        return teamNationality;
    }

    public void setTeamNationality(String teamNationality) {
        this.teamNationality = teamNationality;
    }


    public Map<Integer, Igraci> getTim() {
        return Tim;
    }

    public void setTim(Map<Integer, Igraci> tim) {
        Tim = tim;
    }


    public void povecajBrojPobjeda() {
        this.wins++;
    }


    public int getBrojPobjeda() {
        return wins;
    }

    @Override
    public String toString() {
        return  teamName + '\'';
    }
}

