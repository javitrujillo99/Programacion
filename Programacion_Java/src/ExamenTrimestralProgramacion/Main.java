package ExamenTrimestralProgramacion;

public class Main {

	public static void main(String[] args) {
		Baraja baraja = new Baraja();
		Jugador jugador[] = new Jugador[5];
		baraja.inicializaBaraja();
		baraja.rotarCartaAbajoAArriba();
		baraja.rotarCartaArribaAAbajo();
		baraja.mezclar();
		baraja.tomarCartas(jugador);
	}

}
