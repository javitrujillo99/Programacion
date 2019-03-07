package MarvelVSStreetFighter;

public class Ataque {
	private int danio;
	
	/**
	 * 
	 */
	public Ataque() {
		super();
	}
	
	public void act(Personaje personaje) {
		personaje.setPuntosVida(personaje.getPuntosVida() - this.danio);
	}



	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}
	
}
