package EjerciciosRafa.JuegoFormulaUno;

public class Rampa extends Obstaculo {
	/**
	 * 
	 */
	public Rampa() {
		super();
	}

	/**
	 * @param metrosObstaculo
	 */
	
	
	public int inicializa () {
		int metrosObstaculo = (int) Math.round(Math.random() * (100 - 50) + 50);
		return metrosObstaculo;
	}
		
}
