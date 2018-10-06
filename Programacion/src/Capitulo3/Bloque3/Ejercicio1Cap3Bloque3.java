package Capitulo3.Bloque3;

import javax.swing.JOptionPane;

public class Ejercicio1Cap3Bloque3 {

	public static void main(String[] args) {
		int numero = 1, sumatorio = 0;
		String mensaje = "Introduzca número (0 -> Terminar)";
		
		for (int i = 0; numero != 0; i++) {
			if (i == 0) { // Primera iteración
				sumatorio = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				sumatorio += numero;
			}
			else { // Resto de iteraciones
				sumatorio = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				if (numero > sumatorio && numero != 0) {
					sumatorio += numero;
				}
			}	
		}
		
		JOptionPane.showMessageDialog(null, "Mayor: " + sumatorio);
		
	}

}
