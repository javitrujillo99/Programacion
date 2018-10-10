package Capitulo3.Bloque3.EjerciciosConWhile;

import javax.swing.JOptionPane;

public class Ejercicio3Cap3Bloque3 {

	public static void main(String[] args) {
		int mayor, numero = 1;
		String mensaje = "Introduzca número (0 -> Terminar)";
		numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		mayor = numero;
		while (numero != 0) {
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				if (numero > mayor && numero != 0) {
				mayor = numero;
				}
		}
		JOptionPane.showMessageDialog(null, "El mayor es: " + mayor);
	}
}
