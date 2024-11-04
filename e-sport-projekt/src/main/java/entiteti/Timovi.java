package entiteti;

import exception.TimException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class Timovi implements TeamManagement{

    private String teamName;

    private String teamNationality;


    private int brojPobjeda;

    private Map<Integer,Igraci> Tim=new HashMap<>();

    public Timovi(String teamName, String teamNationality) {
        this.teamName = teamName;
        this.teamNationality = teamNationality;
        this.brojPobjeda=0;
    }

    @Override
    public void formTeam(Igraci igrac) throws  RuntimeException {
        if (igrac != null && !Tim.containsKey(igrac.getId())) {
            Tim.put(igrac.getId(), igrac);

            } else{

            throw new RuntimeException("Igraci ne mogu imati isti ID!");
        }
    }


    public void checkTeamSize() throws TimException{

        if(Tim.size()!=5){

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
        this.brojPobjeda++;
    }


    public int getBrojPobjeda() {
        return brojPobjeda;
    }
}

