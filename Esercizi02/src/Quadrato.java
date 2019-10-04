package geometria.figurepiane;

public class Quadrato {
    private double lato;

    public Quadrato(double lato) {
        this.lato = lato;
    }

    public double calcolaArea() {
        return Math.pow(this.lato, 2);
    }

    public void raddoppiaLato() {
        this.lato *= 2;
    }
}
