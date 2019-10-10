package EjerciciosRafa.JuegoFormulaUno;

public class Coche extends Vehiculo {

	private String nombrePiloto;
	private String color;
	private int podium;
	Pista pista;
	
	
	
	/**
	 * @param nombrePiloto
	 * @param color
	 */
	public Coche(String nombrePiloto, String color) {
		super();
		this.nombrePiloto = nombrePiloto;
		this.color = color;
		this.pista = pista;
	}



	@Override
	public String paint() {
		return this.nombrePiloto;
	}



	@Override
	public String toString() {
		return "Coche [nombrePiloto=" + nombrePiloto + ", podium=" + podium + "]";
	}
	
}
