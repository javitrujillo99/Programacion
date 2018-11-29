package EjerciciosRafa.JuegoElAhorcado;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		String palabras[] = new String[] {"franbeato", "cordobita", "chino", "josebono"};
		int fallos = 0;
		String intentoJugador;
		int numeroPalabraRandom = (int) Math.round(Math.random() * (palabras.length - 1));
		String palabraGenerada = palabras[numeroPalabraRandom];
		System.out.println(palabraGenerada);
		char letras[] = new char[palabraGenerada.length()];
		for (int i = 0; i < letras.length ; i++) {
			letras[i] = '_';
			System.out.print(letras [i] + " ");
		}
		int fallosMaximos= 6;
		String aux[] = new String[fallosMaximos];
		for (int i = 0; i < fallosMaximos ; i++) {
		aux[i] = " _";
		}
		do {
		intentoJugador =JOptionPane.showInputDialog("Introduzca palabra o letra");
		int longitudIntentoJugador = intentoJugador.length();
			if (longitudIntentoJugador == 1) {
				System.out.println("");
				boolean fallo = true;
				for (int i = 0; i < letras.length; i++) {
					char charJugador = intentoJugador.charAt(0);
					//El carácter del jugador coincide con un carácter de la palabra
					if (charJugador == palabraGenerada.charAt(i)) {
						letras[i] = charJugador;
						fallo = false;
					}
				}
				if (fallo == true) {
					aux[fallos] = intentoJugador;
					fallos++;
				}
				for (int i = 0; i < letras.length ; i++) {
					System.out.print(letras [i] + " ");
				}
			}
			else {
				if (!intentoJugador.equals(palabraGenerada)) {
				fallos++;
				}
			}
			System.out.print("\n\n\tFallos: ");
			for (int i = 0; i < fallosMaximos ; i++) {
				System.out.print(" " + aux[i]);
				}
			
		}
		while (!(intentoJugador.equals(palabraGenerada) || fallos >= fallosMaximos || coincidenciasCompletas(letras)));
		if (intentoJugador.equals(palabraGenerada) || coincidenciasCompletas(letras) == true) {
			System.out.println("\n\nENHORABUENA, HAS ACERTADO!! con " + fallos + " fallos");
		}
		else {
			System.out.println("\n\tHAS PERDIDO TONTO");
		}
		
		
	}



	private static boolean coincidenciasCompletas (char letras[] ) {
		for (int i = 0; i < letras.length; i++) {
			if (letras[i] == '_') {
				return false;
			}
		}
		return true;
	}
}
