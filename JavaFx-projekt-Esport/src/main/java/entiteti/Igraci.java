package entiteti;

import java.util.ArrayList;
import java.util.List;

public class Igraci implements Roster{


    private String name;

    private String surname;

    private int age;

    private String nationality;

    private int id;

    private List<Igraci>igraci=new ArrayList<>();

    public Igraci(String name, String surname, int age, String nationality, int id) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nationality = nationality;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Igraci> getIgraci() {
        return igraci;
    }

    public void setIgraci(List<Igraci> igraci) {
        this.igraci = igraci;
    }

    @Override
    public void dodajIgraca(Igraci igrac) {

        igraci.add(igrac);
    }

    @Override
    public void ukloniIgraca(Igraci igrac) {

        igraci.remove(igrac);
    }


}
