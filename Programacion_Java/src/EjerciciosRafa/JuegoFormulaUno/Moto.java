package EjerciciosRafa.JuegoFormulaUno;

public class Moto extends Vehiculo {
	private String nombrePiloto;
	private String color;
	private int podium;
	Pista pista;
	
	
	
	/**
	 * @param nombrePiloto
	 * @param color
	 */
	public Moto(String nombrePiloto, String color) {
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
		return "Moto [nombrePiloto=" + nombrePiloto + ", podium=" + podium + "]";
	}
	
}
