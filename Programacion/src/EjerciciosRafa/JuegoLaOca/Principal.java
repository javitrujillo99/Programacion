package EjerciciosRafa.JuegoLaOca;

public class Principal {   

	/**
	 * 
	 */
	public static void main (String args[]) {
		// Pintamos una ventana en pantalla
		Ventana ventana = new Ventana();
		
		// Comienza el juego
		Juego.getJuego().comienzaJuego();
		// Al finalizar el juego, ordeno a los jugadores por orden de llegada a meta
		Juego.getJuego().ordenaArrayJugadoresPorPodium();
		// Imprimo el array de jugadores ordenado
		Juego.getJuego().imprimeJugadores();
	}

	
	
	
	
	
	
	
	
	
}
