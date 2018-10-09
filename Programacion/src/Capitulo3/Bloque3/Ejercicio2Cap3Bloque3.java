package Capitulo3.Bloque3;

import javax.swing.JOptionPane;

public class Ejercicio2Cap3Bloque3 {

	public static void main(String[] args) {
		float numero = 1, acumulador = 0, i;
		String mensaje = "Introduzca número (0 -> Terminar)";
		for (i = 0; numero != 0; i++) {
			if (i == 0) { // Primera iteración
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				acumulador += numero;
			}
			else {
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				acumulador += numero;
			}
		}
		
		JOptionPane.showMessageDialog(null, "La media de todos los números es : " + (acumulador / (i - 1)));

	}

}
