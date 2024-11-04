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

    public void showDetails() {

        System.out.println("Detalji turnira:");
        System.out.println("Naziv: " + naziv);
        System.out.println("Igra: " + igra);

        if (datumPocetka != null) {
            System.out.println("Datum početka: " + datumPocetka);
        } else {
            System.out.println("Datum početka: Nije postavljen");
        }

        System.out.println("Broj timova: " + brojTimova);
        System.out.println("Nagradni fond: " + nagradniFond);
    }

    public static class TurnirBuilder {
        private String naziv = "Nepoznato";
        private Esport igra = Esport.CSGO;
        private LocalDate datumPocetka = null;
        private int brojTimova = 0;
        private int nagradniFond = 0;

        public TurnirBuilder naziv(String naziv) {
            this.naziv = naziv;
            return this;
        }

        public TurnirBuilder igra(Esport igra) {
            this.igra = igra;
            return this;
        }

        public TurnirBuilder datumPocetka(LocalDate datumPocetka) {
            this.datumPocetka = datumPocetka;
            return this;
        }

        public TurnirBuilder brojTimova(int brojTimova) {
            this.brojTimova = brojTimova;
            return this;
        }

        public TurnirBuilder nagradniFond(int nagradniFond) {
            this.nagradniFond = nagradniFond;
            return this;
        }

        public Turnir build() {
            return new Turnir(this);
        }
    }
}
