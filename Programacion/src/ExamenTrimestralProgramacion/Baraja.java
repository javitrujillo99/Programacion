package ExamenTrimestralProgramacion;


public class Baraja {
	
	private static Carta cartas[] = new Carta[52];
	
	
	/**
	 * 
	 */
	public Baraja() {
		super();
	}
	
	

	/**
	 * @param baraja
	 */
	public Baraja(Carta[] cartas) {
		super();
		this.cartas = cartas;
	}



	public static void inicializaBaraja() {
		for (int i = 0; i < 13; i++) {
			cartas[i] = new Carta (i,"Picas", i);
		}
		for (int i = 0; i < 13; i++) {
			cartas[i + 13] = new Carta (i,"Diamantes", (i + 13));
		}
		for (int i = 0; i < 13; i++) {
			cartas[i + 26] = new Carta (i,"Tréboles", (i + 26));
		}
		for (int i = 0; i < 13; i++) {
			cartas[i + 39] = new Carta (i,"Corazones", (i + 39));
		}
		for (int i = 0; i < cartas.length; i++) {
		System.out.println(cartas[i]);
		}
	}

	public static void rotarCartaAbajoAArriba() {
		System.out.println("\n\nROTACION 1:");
		// Salvaguardo el elemento más a la derecha
		Carta aux = cartas[cartas.length - 1];
		for (int i = (cartas.length - 1); i > 0; i--) {
		cartas[i] = cartas[i-1];
		}
		cartas[0] = aux;
		for (int i = 0; i < cartas.length; i++) {
			System.out.println(cartas[i]);
		}
	}
	
	public static void rotarCartaArribaAAbajo() {
		System.out.println("\n\nROTACION 2:");
		// Salvaguardo el elemento más a la izquierda
		Carta aux = cartas[1];
		for (int i = 0; i < cartas.length - 1; i++) {
		cartas[i] = cartas[i + 1];
		}
		cartas[51] = aux;
		for (int i = 0; i < cartas.length; i++) {
			System.out.println(cartas[i]);
		}
	}
	
	public static void mezclar () {
		
		System.out.println("\n\nCARTAS MEZCLADAS: ");
		for (int i = 0; i < cartas.length; i++) {
			int indiceAzar1 = (int) Math.round(Math.random() * (cartas.length - 1));
			int indiceAzar2 = (int) Math.round(Math.random() * (cartas.length - 1));
			
			Carta aux = cartas[indiceAzar1];
			cartas[indiceAzar1] = cartas[indiceAzar2];
			cartas[indiceAzar2] = aux;
			System.out.println(cartas[i]);
		}
	}
	public Carta[] getBaraja() {
		return cartas;
	}



	public void setBaraja(Carta[] cartas) {
		this.cartas = cartas;
	}
	
	public void tomarCartas (Jugador[] jugador) {
		int idAleatorio = (int) Math.round(Math.random() * cartas.length);
		//inicializo el array
		for (int i = 0; i < cartas.length; i++) {
			Carta baraja = cartas[i];
		}
		
		
	}
	
	
}
