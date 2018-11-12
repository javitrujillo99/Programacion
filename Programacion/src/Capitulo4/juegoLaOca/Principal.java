package Capitulo4.juegoLaOca;

public class Principal {

	public static void main(String[] args) {
		//Inicializacion e impresion del tablero
		Tablero tablero = new Tablero();
		tablero.imprimeTablero();
		
		//Prueba de uso del primero jugador
		Jugador jugador = new Jugador("Rojo", tablero);
		do {
			jugador.tirarDado();
			jugador.imprimir();
		} while (jugador.getPosicion() <= 61);
	}	
}
