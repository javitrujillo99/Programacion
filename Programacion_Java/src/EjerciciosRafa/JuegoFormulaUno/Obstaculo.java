package EjerciciosRafa.JuegoFormulaUno;

public abstract class Obstaculo {
	private int metrosObstaculo;
	
	
	/**
	 * 
	 */
	public Obstaculo() {
		super();
	}

	
	public abstract int inicializa();


	/**
	 * @param metrosObstaculo
	 */
	public Obstaculo(int metrosObstaculo) {
		super();
		this.metrosObstaculo = metrosObstaculo;
	}


	public int getMetrosObstaculo() {
		return metrosObstaculo;
	}


	public void setMetrosObstaculo(int metrosObstaculo) {
		this.metrosObstaculo = metrosObstaculo;
	}
	
	


	
	
}
