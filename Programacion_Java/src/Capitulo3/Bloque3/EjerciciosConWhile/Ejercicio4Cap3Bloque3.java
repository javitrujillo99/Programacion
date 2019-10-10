package Capitulo3.Bloque3.EjerciciosConWhile;

import javax.swing.JOptionPane;

public class Ejercicio4Cap3Bloque3 {

	public static void main(String[] args) {
		int menor, numero = 1;
		String mensaje = "Introduzca número (0 -> Terminar)";
		numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		menor = numero;
		while (numero != 0) {
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				if (numero < menor && numero != 0) {
				menor = numero;
				}
		}
		JOptionPane.showMessageDialog(null, "El menor es: " + menor);
	}
}
