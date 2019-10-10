package Capitulo3.Bloque3.EjerciciosConDoWhile;

import javax.swing.JOptionPane;

public class Ejercicio3Cap3Bloque3 {

	public static void main(String[] args) {
		int mayor, numero = 1;
		String mensaje = "Introduzca número (0 -> Terminar)";
		numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		mayor = numero;
		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			if (numero > mayor && numero != 0) {
			mayor = numero;
			}
		}
		while (numero != 0);
		JOptionPane.showMessageDialog(null, "El mayor es: " + mayor);
	}
}