package entiteti;

import java.time.LocalDate;

public class Match {

    private Timovi tim1;

    private Timovi tim2;

    private LocalDate datum;

    private Esport igra;

    private Scores rezultat;


    public Match(Timovi tim1, Timovi tim2, LocalDate datum, Esport igra, Scores rezultat) {
        this.tim1 = tim1;
        this.tim2 = tim2;
        this.datum = datum;
        this.igra = igra;
        this.rezultat = rezultat;
    }

    public Timovi getTim1() {
        return tim1;
    }

    public void setTim1(Timovi tim1) {
        this.tim1 = tim1;
    }

    public Timovi getTim2() {
        return tim2;
    }

    public void setTim2(Timovi tim2) {
        this.tim2 = tim2;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Esport getIgra() {
        return igra;
    }

    public void setIgra(Esport igra) {
        this.igra = igra;
    }

    public Scores getRezultat() {
        return rezultat;
    }

    public void setRezultat(Scores rezultat) {
        this.rezultat = rezultat;
    }
}
