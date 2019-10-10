package EjerciciosRafa.JuegoFormulaUno;

public class Pista {
	
	Obstaculo obstaculos[] = new Obstaculo[4];
	private int numPista;
	
	/**
	 * @param obstaculos
	 */
	public Pista(Obstaculo[] obstaculos, int numPista) {
		super();
		this.obstaculos = obstaculos;
		this.numPista = numPista;
	}
	
	

	public Obstaculo[] getObstaculos() {
		return obstaculos;
	}

	public void setObstaculos(Obstaculo[] obstaculos) {
		this.obstaculos = obstaculos;
	}

	public int getNumPista() {
		return numPista;
	}

	public void setNumPista(int numPista) {
		this.numPista = numPista;
	}

	/**
	 * @param obstaculos
	 * @param numPista
	 */
	
	
	/**public void inicializaPista() {
		for (int i = 0; i < obstaculos.length; i++) {
			obstaculos[i] = new Obstaculo();
			}
	}
	*/
	
	
}