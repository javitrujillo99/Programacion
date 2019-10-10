package Capitulo4.juegoLaOca;

public class Jugador {
	private String nombre;
	private int posicion = 0;
	
	
	/**
	 * 
	 */
	public Jugador() {
		super();
	}
	
	
	/**
	 * @param nombre
	 * @param posicion
	 */
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public void tirarDado () {
		int dado = (int) Math.round(Math.random() * (6 - 1) + 1);
		//System.out.println("Dado: " + dado);
		//Sumo el dado a la posicion actual
		this.posicion += dado; 
		//Calculo del posible rebote
		if (this.posicion > Tablero.getTablero().getCasillas().length) {
			this.posicion = Tablero.getTablero().getCasillas().length - 
					(this.posicion - Tablero.getTablero().getCasillas().length);
		}
		//Comprobamos si estamos en una casilla especial
		//Puntero a la casilla correspondiente del array
		Casilla casillaActual = Tablero.getTablero().getCasillas()[this.posicion];
		//Imprimo el contenido de la casilla actual
		System.out.println("Estamos en la casilla de índice " + this.posicion + 
				" - Orden: " + casillaActual.getOrden() + 
				" - Nombre: " + casillaActual.getNombre());
		
		//Busco un destino de la casilla actual
		if (casillaActual.getDestino() != null) { //Es una casilla especial, hay un destino
			Casilla casillaDestino = casillaActual.getDestino();
			System.out.println("La casilla de destino es: " + this.posicion + 
					" - Orden: " + casillaDestino.getOrden() + 
					" - Nombre: " + casillaDestino.getNombre());
			//Actualizar la posicion del jugador, teniendo en cuenta que ha caido en una casilla especial
			this.posicion = casillaDestino.getOrden() - 1;
		}
	}
	
	public void imprimir() {
		System.out.println(this.nombre + " - pos: " + (this.posicion + 1));
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the posicion
	 */
	public int getPosicion() {
		return posicion;
	}


	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	
	

}
