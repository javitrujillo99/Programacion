package Capitulo3.Bloque3;

import javax.swing.JOptionPane;

public class Ejercicio2Cap3Bloque3 {

	public static void main(String[] args) {
		int numero = 1, acumulador = 0, i;
		String mensaje = "Introduzca número (0 -> Terminar)";
		for (i = 1; numero != 0; i++) {
			if (i == 1) { // Primera iteración
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				acumulador += numero;
				
			}
			else {
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				acumulador += numero;
			}
		}
		
		JOptionPane.showMessageDialog(null, "La media de todos los números es : " + (float)(acumulador / (i - 1)));

	}

}
