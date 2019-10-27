package geometria.figuresolide;
import geometria.figurepiane.Quadrato;

public class Cubo {
    Quadrato faccia;

    public Cubo(double lato) {
        this.faccia = new Quadrato(lato);
    }
}
