package Capitulo3.Bloque3;

import javax.swing.JOptionPane;

public class Ejercicio4Cap3Bloque3 {

	public static void main(String[] args) {
		int menor = 0, numero = 1;
		String mensaje = "Introduzca número (0 -> Terminar)";
		
		for (int i = 1; numero != 0; i++) {
			if (i == 1) { //Primera iteración
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				menor = numero;
			}
			else {
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				if (numero < menor && numero != 0) {
				menor = numero;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "El menor es: " + menor);
	}

}
