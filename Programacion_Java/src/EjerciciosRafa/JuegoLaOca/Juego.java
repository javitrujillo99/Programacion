package EjerciciosRafa.JuegoLaOca;

public class Juego {

	// Array de posibles nombres de jugadores, máximo de 6
	private String nombresJugadores[] = new String[] {"Rafa", "Joaquín", "Pedro", "Marta", "Sofía", "Laura"};
	// Array de objetos de tipo "Jugador"
	private Jugador jugadores[] = null;
	// Singleton
	private static Juego juego = null;
	
	/**
	 * 
	 */
	public Juego () {
		super();
		// Inicialización del array de jugadores
		jugadores = new Jugador[6];
		// Construcción de los objetos de tipo "Jugador"
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i] = new Jugador(nombresJugadores[i]);
		}
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static Juego getJuego() {
		if (juego == null) {
			juego = new Juego();
		}
		return juego;
	}
	
	
	
	/**
	 * 
	 */
	public void comienzaJuego () {
		// Bucle principal del juego
		do { // El bucle actúa mientras algún jugador siga en activo
			for (int i = 0; i < jugadores.length; i++) {
				// Mientras el jugador no haya terminado realizará su jugada
				if (!jugadores[i].isTerminado()) {
					// Imprimimos el nombre del jugador en pantalla
					System.out.println(jugadores[i].getNombre());
					// El jugador tira el dado y se traslada hasta el lugar que le
					// corresponda
					jugadores[i].tirarDado();
					// Si el jugador ha terminado se le dará un número de "podium"
					if (jugadores[i].isTerminado()) {
						jugadores[i].setPodium(getMaximoValorEnPodium() + 1);
					}
				}
			}
		} while (!estaJuegoTerminado()); // Se juega mientras quede un sólo jugador activo
		
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	private boolean estaJuegoTerminado () {
		// Se recorre el array de jugadores buscando que alguno aún no haya terminado el juego
		for (int i = 0; i < jugadores.length; i++) {
			if (!jugadores[i].isTerminado()) {
				// El jugador de índice "i" aún no ha terminado el juego
				return false;
			}
		}
		// Si llegamos a este punto significará que todos los jugadores han terminado
		return true;
	}

	
	/**
	 * 
	 * @return
	 */
	public int getMaximoValorEnPodium () {
		// Este método obtiene el máximo valor de podium del conjunto de jugadores.
		// Si ningún jugador ha llegado a la meta, todos los jugadores tendrán en su
		// "podium" el valor "0".
		int maxValor = 0;
		
		// Comprobamos que el array tenga al menos un elemento
		if (jugadores.length > 0) {
			maxValor = jugadores[0].getPodium(); // Asignamos el máximo valor de podium al que tenga el primer jugador
			// Recorremos todos los jugadores, buscando un valor de podium más alto,
			// comenzando por el segundo jugador y llegando hasta el último.
			for (int i = 1; i < jugadores.length; i++) {
				if (jugadores[i].getPodium() > maxValor) {
					maxValor = jugadores[i].getPodium();
				}
			}
		}
		return maxValor;
	}
	

	/**
	 * 
	 * @param jugadores
	 */
	public void ordenaArrayJugadoresPorPodium () {
		// Ordenación por el método de la burbuja, para que los jugadores queden
		// ordenados por orden de llegada a la meta
		for (int i = jugadores.length-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (jugadores[j].getPodium() > jugadores[j+1].getPodium()) {
					Jugador aux = jugadores[j];
					jugadores[j] = jugadores[j+1];
					jugadores [j+1] = aux;
				}
			}
		}		
	}

	
	/**
	 * 
	 */
	public void imprimeJugadores () {
		// Imprimo array de jugadores
		System.out.println("\n\nPodium de jugadores");
		for (int i = 0; i < jugadores.length; i++) {
			System.out.println(jugadores[i].toString());
		}
	}
}
