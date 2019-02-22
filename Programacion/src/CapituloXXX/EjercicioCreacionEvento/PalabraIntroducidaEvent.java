package CapituloXXX.EjercicioCreacionEvento;

public class PalabraIntroducidaEvent {
	private String palabraIntroducida;

	/**
	 * @param palabraIndtroducida
	 */
	public PalabraIntroducidaEvent(String palabraIntroducida) {
		super();
		this.palabraIntroducida = palabraIntroducida;
	}

	public String getPalabraIndtroducida() {
		return palabraIntroducida;
	}

	public void setPalabraIndtroducida(String palabraIntroducida) {
		this.palabraIntroducida = palabraIntroducida;
	}
	
	
}
