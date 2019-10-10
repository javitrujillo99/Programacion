package ExamenTrimestralProgramacion;


public class Carta {
	private int valor;
	private String palo;
	private int idCarta;
	// Singleton
	private static Carta carta = null;
		
	
	/**
	 * 
	 */
	public Carta() {
		super();
	}

	/**
	 * @param valor
	 * @param palo
	 */
	public Carta(int valor, String palo, int idCarta) {
		super();
		this.valor = valor;
		this.palo = palo;
		this.idCarta = idCarta;
	}

	
	/**
	 * Singleton
	 * @return
	 */
	public static Carta getCarta() {
		if (carta == null) {
			carta = new Carta();
		}
		return carta;
	}
	
	@Override
	public String toString() {
		return valor + " de " + palo + "\t Identificador = " + idCarta;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public int getIdCarta() {
		return idCarta;
	}

	public void setIdCarta(int idCarta) {
		this.idCarta = idCarta;
	}
	
	
	
	
}
