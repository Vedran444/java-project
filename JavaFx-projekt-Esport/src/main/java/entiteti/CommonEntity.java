package entiteti;

public abstract class CommonEntity {

    protected  String ime;
    protected Esport igra;

    public CommonEntity(String ime, Esport igra) {
        this.ime = ime;
        this.igra = igra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Esport getIgra() {
        return igra;
    }

    public void setIgra(Esport igra) {
        this.igra = igra;
    }


}
