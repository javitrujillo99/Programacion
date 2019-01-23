package EjerciciosRafa.JuegoElAhorcado;

import javax.swing.JOptionPane;

import EjerciciosRafa.JuegoFormulaUno.Vehiculo;

public class Juego {
	//Declaramos las variables de la clase
	private String palabras[] = new String[] {"franbeato", "cordobita", "chino", "josebono","seli","papa", "correr"};
	private int fallos = 0;
	private String intentoJugador;
	private int numeroPalabraRandom;
	private String palabraGenerada;
	private char letras[];
	private int fallosMaximos;
	private String aux[];
	private boolean boolHint = false;
	private String pista = "pista";
	private static Juego juego = null;
	private boolean boolGodMode = false;
	
	/**
	 * 
	 */
	public void empezarJuego () {
		//Declaramos las variables del método
		numeroPalabraRandom = (int) Math.round(Math.random() * (palabras.length - 1));
		palabraGenerada = palabras[numeroPalabraRandom];
		//Creamos un array con las letras de la palabra generada al azar.
		
		fallosMaximos = 6;
		letras = new char[palabraGenerada.length()];
		aux = new String[fallosMaximos];
		System.out.println(palabraGenerada);
		//Recorremos la longitud de la palabra en imprimimos guines bajos
		for (int i = 0; i < letras.length ; i++) {
			letras[i] = '_';
			System.out.print(letras [i] + " ");
		}
		//Recorremos e imprimimos los guiones de los fallos
		for (int i = 0; i < fallosMaximos ; i++) {
			aux[i] = " *";
		}
		do {
			//Empieza el juego pidiendo una palabra o letra
		intentoJugador =JOptionPane.showInputDialog("Introduzca palabra o letra");
		int longitudIntentoJugador = intentoJugador.length();
		
		//El usuario introduce una letra
			if (longitudIntentoJugador == 1) {
				System.out.println("");
				boolean fallo = true;
				for (int i = 0; i < letras.length; i++) {
					char charJugador = intentoJugador.charAt(0);
					//El carácter del jugador coincide con un carácter de la palabra
					if (charJugador == palabraGenerada.charAt(i)) {
						letras[i] = charJugador;
						Ventana.getVentana().repaint();
						fallo = false;
						
					}
				}
				if (fallo == true && boolGodMode == false) {
					aux[fallos] = intentoJugador;
					fallos++;
					Ventana.getVentana().repaint();
				}
				for (int i = 0; i < letras.length ; i++) {
					System.out.print(letras [i] + " ");
				}
			}
			else {
				if (!intentoJugador.equals(palabraGenerada) && boolGodMode == false) {
				aux[fallos] = intentoJugador;
				fallos++;
				Ventana.getVentana().repaint();
				}
			}
			System.out.print("\n\n\tFallos: ");
			for (int i = 0; i < fallosMaximos ; i++) {
				System.out.print(" " + aux[i]);
				}
			
			//Creamos el HINT
			if (intentoJugador.equals(pista) && boolHint  == false) {
				System.out.println("\n");
				JOptionPane.showMessageDialog(null, "Has activado la pista");
				int numAzar = (int) Math.round(Math.random() * (palabraGenerada.length() - 1) + 1);
				char letraAzar = palabraGenerada.charAt(numAzar);
				letras[numAzar] = letraAzar;
				for (int i = 0; i < palabraGenerada.length(); i++) {
					if (letras[numAzar] == palabraGenerada.charAt(i)) {
						letras[i] = letras[numAzar];
						Ventana.getVentana().repaint();
					}
					System.out.print(letras[i] + " ");
				}
				boolHint = true;

			}
			//Creamos el GodMode
			if (intentoJugador.equals("godmode")) {
				boolGodMode = true;
				JOptionPane.showMessageDialog(null, "Has activado el modo inmortal");
			}
			
		}
		while (!(intentoJugador.equals(palabraGenerada) || fallos >= fallosMaximos || coincidenciasCompletas(letras)));
		if (victoria()) {
			Ventana.getVentana().repaint();
			System.out.println("\n\nENHORABUENA, HAS ACERTADO!! con " + fallos + " fallos");
		}
		else {
			System.out.println("\n\tHAS PERDIDO");
			System.out.println("\t LA RESPUESTA ERA: " + palabraGenerada);
		}
		
	}
	public static boolean coincidenciasCompletas (char letras[] ) {
		for (int i = 0; i < letras.length; i++) {
			if (letras[i] == '_') {
				return false;
			}
		}
		return true;
	}
	
	public static boolean victoria() {
		if (Juego.getJuego().getPalabraGenerada().equals(Juego.getJuego().getIntentoJugador())
				|| coincidenciasCompletas(Juego.getJuego().getLetras()) == true) {
			return true;
		}
			return false;	
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
		public static Juego getJuego() {
			if (juego == null) {
				juego = new Juego();
			}
			return juego;
		}
		public Juego() {
			super();
		}
		public int getFallos() {
			return fallos;
		}
		public void setFallos(int fallos) {
			this.fallos = fallos;
		}
		public char[] getLetras() {
			return letras;
		}
		public String[] getAux() {
			return aux;
		}
		public void setAux(String[] aux) {
			this.aux = aux;
		}
		public String getPalabraGenerada() {
			return palabraGenerada;
		}
		public void setPalabraGenerada(String palabraGenerada) {
			this.palabraGenerada = palabraGenerada;
		}
		public void setLetras(char[] letras) {
			this.letras = letras;
		}
		public String getIntentoJugador() {
			return intentoJugador;
		}
		public void setIntentoJugador(String intentoJugador) {
			this.intentoJugador = intentoJugador;
		}
		
		
		
		
}

