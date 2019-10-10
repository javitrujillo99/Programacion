package EjerciciosRafa.JuegoFormulaUno;

public class ManchaAceite extends Obstaculo {	
	/**
	 * 
	 */
	public ManchaAceite() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param metrosObstaculo
	 */
	public ManchaAceite(int metrosObstaculo) {
		super(metrosObstaculo);
		// TODO Auto-generated constructor stub
	}	

	public int inicializa () {
		int metrosObstaculo =  (int) Math.round(Math.random() * (-10 + 50) - 50);
		return metrosObstaculo;
	}



	

}
