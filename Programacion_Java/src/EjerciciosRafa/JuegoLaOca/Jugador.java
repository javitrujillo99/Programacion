package EjerciciosRafa.JuegoLaOca;


public class Jugador {   
	private String nombre;
	private Casilla casilla;
	private int podium;
	private int turnos;

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
		this.casilla = Tablero.getPrimeraCasillaEnTablero();
	}
	
	
	/**
	 * 
	 */
	public void tirarDado () {
		// Imprimo en la consola la casilla actual, antes del movimiento		
		System.out.println("\tEstá en: " + this.casilla);

		// Si el jugador tiene una penalización activa no puede jugar en este
		// turno
		if (this.getTurnos() < 0) { // Hay penalización activa de turnos
			System.out.println("\t\tNo puede tirar. Permanece en: " +
					this.casilla + " Turnos:" + this.turnos);
			this.turnos++; // Actualizamos los turnos del jugador. De esta manera
			// la sanción de turnos va poco a poco desapareciendo.
		}
		else { // El jugador puede jugar, no tiene penalización de turnos
			// Utilizamos el azar para conseguir un dado virtual
			int dado = (int) Math.round(Math.random()*(6-1)+1);
			System.out.println("\t\tDado: " + dado); 

			// Calculamos la primera casilla de destino
			int posicionActual = Tablero.getPosicion(this.casilla);
			int nuevaPosicion = posicionActual + dado;
			// Una vez que tengo la nueva posición, tras tirar el dado, debo
			// calcular el posible rebote.
			nuevaPosicion = Tablero.getNuevaPosicionPorRebote(nuevaPosicion);
			// Tras calcular el rebote obtengo la nueva casilla actual
			this.casilla = Tablero.getTablero().getCasillas()[nuevaPosicion];
			// Ahora conozco la primera casilla de destino, tras
			// haber lanzado y sumado el dado. La imprimo en pantalla
			System.out.println("\t\tPasa a: " + this.casilla);
			
			// En el caso de que la nueva casilla tenga una situación especial,
			// bonificación o penalización, en el turno del jugador, se obtiene
			// dicha situación y se almacena en el propio jugador.
			if (this.casilla.getTurnos() != 0) {
				this.turnos = this.casilla.getTurnos();
			}
			
			// Calculo la nueva posición por posibilidad de casilla
			// especial
			if (this.casilla.isEspecial()) { // En este caso hemos caído en una casilla especial
				int nuevaPosicionPorCasillaEspecial = 
						Tablero.getNuevaPosicionPorCasillaEspecial(nuevaPosicion);
				this.casilla = Tablero.getTablero().getCasillas()[nuevaPosicionPorCasillaEspecial];
				// Imprimo el mensaje especial de la casilla de destino
				System.out.println("\t\tEnviado/a a: " + this.casilla);
				System.out.println("\t\t\t" + this.casilla.getMensajeEspecial());
			}

			// Si corresponde, el jugador vuelve a tirar, para lo cual utilizamos
			// la recursividad.
			if (this.turnos > 0 && !this.isTerminado()) { // El jugador debe volver a tirar el dado y a moverse
				this.turnos--;
				this.tirarDado();
			}
		}		
	}
	

	/**
	 * 
	 * @return
	 */
	public boolean isTerminado () {
		if (this.casilla.equals(Tablero.getUltimaCasillaEnTablero())) {
			return true;
		}
		return false;
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
	 * @return the casilla
	 */
	public Casilla getCasilla() {
		return casilla;
	}

	/**
	 * @param casilla the casilla to set
	 */
	public void setCasilla(Casilla casilla) {
		this.casilla = casilla;
	}

	/**
	 * @return the podium
	 */
	public int getPodium() {
		return podium;
	}

	/**
	 * @param podium the podium to set
	 */
	public void setPodium(int podium) {
		this.podium = podium;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", podium=" + podium + "]";
	}

	/**
	 * @return the turnos
	 */
	public int getTurnos() {
		return turnos;
	}

	/**
	 * @param turnos the turnos to set
	 */
	public void setTurnos(int turnos) {
		this.turnos = turnos;
	}

	
}
