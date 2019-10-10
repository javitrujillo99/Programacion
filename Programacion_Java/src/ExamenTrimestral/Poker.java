package ExamenTrimestral;

public class Poker {
	Jugador jugadores[] = new Jugador[5];

	/**
	 * 
	 */
	public Poker() {
		super();
	}

	/**
	 * @param jugadores
	 */
	public Poker(Jugador[] jugadores) {
		super();
		this.jugadores = jugadores;
	}

	
	
	public Jugador[] getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}
	
	
}
