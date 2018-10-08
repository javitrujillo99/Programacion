package Capitulo3.Bloque3;

import javax.swing.JOptionPane;

public class Ejercicio6Cap3Bloque3 {

	public static void main(String[] args) {
		String mensaje = "Introduzca número (0 -> Terminar)";
		int numero = 1;
		for (int i = 0; numero != 0; i++) {
			numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			
			if (i == 0) { //Primera iteración
				for (int j = 0; j <= 10; j++) {
					System.out.println(numero + " x " + j + " = " + (j * numero));
				}
			}
			else {
				for (int j = 0; j <= 10; j++) {
					System.out.println(numero + " x " + j + " = " + (j * numero));
				}
			}
		}

	}

}
