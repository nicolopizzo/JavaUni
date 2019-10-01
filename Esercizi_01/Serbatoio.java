public class Serbatoio {
	private final int CAPACITA;
	private int livello;

	/**
	Costruttore senza parametri. Inizializza la capacità a 100
	*/
	public Serbatoio() {
		this.CAPACITA = 100;
	}

	/**
	Costruttore con parametro per inizializzare la capacità dell'oggetto.
	@param capacita Il valore con cui inizializzare la capacità dell'oggetto.
	*/
	public Serbatoio(int CAPACITA) {
		this.CAPACITA = CAPACITA;
	}

	/**
	Metodo che aumenta il valore dell'attributo livello dell'oggetto
	@param livello Il valore di cui aumentare
	*/
	public void rifornisci(int livello) {
		if(this.livello+livello <= this.CAPACITA)
			this.livello += livello;
		else
			System.out.println("Errore, il livello inserito supera la capacità massima.");
	}

	/**
	Metodo che diminuisce il valore dell'attributo livello dell'oggetto
	@param livello Il valore di cui diminuire
	*/
	public void consuma(int livello) {
		if(this.livello >= livello)
			this.livello -= livello;
		else
			System.out.println("Impossibile consumare questa quantità di carburante.");
	}

	/**
	Metodo che travasa dall'oggetto corrente ad un altro oggetto Serbatoio
	@param livello Il valore da travasare
	@param s Il serbatoio in cui travasare
	*/
	public void travasa(int livello, Serbatoio s) {
		if (this.livello >= livello && s.livello+livello <= s.CAPACITA) {
			this.livello -= livello;
			s.livello += livello;
		}
		else
			System.out.println("Errore, richiesta di travaso troppo alta.");
	}

	/**
	Metodo che fa ottenere il valore dell'attributo livello dell'oggetto
	@return Il valore del livello
	*/
	public int getLivello() {
		return this.livello;
	}
}
