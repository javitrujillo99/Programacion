package Capitulo6.Bloque7EventosYListeners.Ejercicio1Bloque7Cap6;

public class PalabraContieneTresDigitosEvent {
	private String palabra;

	/**
	 * @param palabra
	 */
	public PalabraContieneTresDigitosEvent(String palabra) {
		super();
		this.palabra = palabra;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	
}
