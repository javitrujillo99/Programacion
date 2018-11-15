package Capitulo4.juegoLaOca;

public class Principal {

	public static void main(String[] args) {
		//Prueba de uso del primero jugador
		Jugador jugador = new Jugador("Rojo");
		do {
			jugador.tirarDado();
			jugador.imprimir();
		} while (jugador.getPosicion() <= 61);
	}	
}
