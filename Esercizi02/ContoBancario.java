public class ContoBancario {
    private double ContoCorrente;
    private String intestatario;
    private static int counter;
    private final int NumeroConto;

    /**
    Costruttore con parametro di tipo Stringa che contiente nome e cognome dell'intestatario.
    @param intestatario L'intestatario del conto.
    */
    public ContoBancario(String intestatario) {
        this.intestatario = intestatario;
        this.NumeroConto = this.counter++;
    }

    /**
    Metodo che carica il conto di un importo passato a parametro.
    @param importo La quantità di denaro da caricare sul conto.
    */
    public void versa(double importo) {
        this.ContoCorrente += importo;
    }

    /**
    Metodo che detrae il conto di un importo passato a parametro.
    @param importo La quantità di denaro da detrarre dal conto.
    */
    public void preleva(double importo) {
        if (this.ContoCorrente >= importo)
            this.ContoCorrente -= importo;
    }

    /**
    Metodo che detrae il conto corrente da un importo passato a parametro, e lo trasferisce su un altro conto passato a parametro.
    @param importo La quantità di denaro da trasferire.
    @param c Il conto su cui trasferire il denaro.
    */
    public void trasferisci(double importo, ContoBancario c) {
        if (this.ContoCorrente >= importo) {
            this.ContoCorrente -= importo;
            c.ContoCorrente += importo;
        }
        else
            System.out.println("Transazione rifiutata, credito non sufficente");
    }

    /**
    Metodo che permette al client di visualizzare il conto corrente.
    @return La quantità di denaro del conto.
    */
    public double getContoCorrente() {
        return this.ContoCorrente;
    }
}
