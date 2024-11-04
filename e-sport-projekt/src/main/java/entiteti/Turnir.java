package entiteti;

import java.time.LocalDate;

public class Turnir {

    private String naziv;
    private Esport igra;
    private LocalDate datumPocetka;
    private int brojTimova;
    private int nagradniFond;

    private Turnir(TurnirBuilder builder) {
        this.naziv = builder.naziv;
        this.igra = builder.igra;
        this.datumPocetka = builder.datumPocetka;
        this.brojTimova = builder.brojTimova;
        this.nagradniFond = builder.nagradniFond;
    }

    public void prikaziDetalje() {
        System.out.println("Detalji turnira:");
        System.out.println("Naziv: " + naziv);
        System.out.println("Igra: " + igra);
        System.out.println("Datum početka: " + datumPocetka);
        System.out.println("Broj timova: " + brojTimova);
        System.out.println("Nagradni fond: " + nagradniFond);
    }

    public static class TurnirBuilder {
        private String naziv;
        private Esport igra;
        private LocalDate datumPocetka;
        private int brojTimova;
        private int nagradniFond;

        public TurnirBuilder(String naziv, Esport igra, LocalDate datumPocetka, int brojTimova) {
            this.naziv = naziv;
            this.igra = igra;
            this.datumPocetka = datumPocetka;
            this.brojTimova = brojTimova;
        }

        public TurnirBuilder nagradniFond(int nagradniFond) {
            this.nagradniFond = nagradniFond;
            return this;
        }

        // Dodaj metode za postavljanje dodatnih svojstava...

        public Turnir build() {
            return new Turnir(this);
        }
    }

}


