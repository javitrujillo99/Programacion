package EjerciciosRafa.JuegoFormulaUno;


public abstract class Vehiculo {
	private int metrosAvanzados = 0;
	private int acumuladorMetros = 0;
	private int metrosFinal = 500;
	private int podium;
	Pista pista;
	

	/**
	 * @param metrosAvanzados
	 * @param acumuladorMetros
	 * @param metrosFinal
	 * @param pista
	 */
	public Vehiculo(int metrosAvanzados, int acumuladorMetros, int metrosFinal, Pista pista) {
		super();
		this.metrosAvanzados = metrosAvanzados;
		this.acumuladorMetros = acumuladorMetros;
		this.metrosFinal = metrosFinal;
		this.pista = pista;
	}

	public Pista getPista() {
		return pista;
	}

	public void setPista(Pista pista) {
		this.pista = pista;
	}

	public int avanza() {
		metrosAvanzados = (int) Math.round(Math.random() * (50 - 3) + 3);
		acumuladorMetros += metrosAvanzados;
		return metrosAvanzados;
	}
	
	public boolean estaVehiculoTerminado (){
		if (acumuladorMetros < metrosFinal) {
			return false;
		}
		return true;
	}
	/**
	 * 
	 */
	public Vehiculo() {
		super();
	}
	
	/**
	 * 
	 * @return
	 */
	public abstract String paint();
	
	



	public int getMetrosAvanzados() {
		return metrosAvanzados;
	}

	public void setMetrosAvanzados(int metrosAvanzados) {
		this.metrosAvanzados = metrosAvanzados;
	}

	public int getAcumuladorMetros() {
		return acumuladorMetros;
	}

	public void setAcumuladorMetros(int acumuladorMetros) {
		this.acumuladorMetros = acumuladorMetros;
	}

	

	/**
	 * @param nombreVehiculo
	 * @param colorVehiculo
	 * @param metrosAvanzados
	 * @param acumuladorMetros
	 */
	public Vehiculo(int metrosAvanzados, int acumuladorMetros) {
		super();
		this.metrosAvanzados = metrosAvanzados;
		this.acumuladorMetros = acumuladorMetros;
	}

	public int getMetrosFinal() {
		return metrosFinal;
	}

	public void setMetrosFinal(int metrosFinal) {
		this.metrosFinal = metrosFinal;
	}

	public int getPodium() {
		return podium;
	}

	public void setPodium(int podium) {
		this.podium = podium;
	}
	
}
