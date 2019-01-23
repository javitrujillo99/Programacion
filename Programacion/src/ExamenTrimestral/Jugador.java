package ExamenTrimestral;

public class Jugador {
	private String nombre;
	Carta cartas[] = new Carta[5];
	
	/**
	 * 
	 */
	public Jugador() {
		super();
	}

	/**
	 * @param nombre
	 * @param cartas
	 */
	public Jugador(String nombre, Carta[] cartas) {
		super();
		this.nombre = nombre;
		this.cartas = cartas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Carta[] getCartas() {
		return cartas;
	}

	public void setCartas(Carta[] cartas) {
		this.cartas = cartas;
	}
	
	
}
