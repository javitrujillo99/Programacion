package Capitulo3.Bloque3.EjerciciosConDoWhile;

import javax.swing.JOptionPane;

public class Ejercicio1Cap3Bloque3 {

	public static void main(String[] args) {
		int sumatorio = 0, numero = 1;
		String mensaje = "Introduzca número (0 -> Terminar)";
		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			sumatorio += numero;
		}
		while (numero != 0);
		JOptionPane.showMessageDialog(null, "La suma de todos los números es : " + sumatorio);
			
		}
}