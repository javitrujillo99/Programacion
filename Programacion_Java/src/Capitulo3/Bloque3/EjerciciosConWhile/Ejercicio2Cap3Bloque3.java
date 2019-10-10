package Capitulo3.Bloque3.EjerciciosConWhile;

import javax.swing.JOptionPane;

public class Ejercicio2Cap3Bloque3 {

	public static void main(String[] args) {
		float numero = 1, acumulador = 0, i = 0;
		String mensaje = "Introduzca número (0 -> Terminar)";
		while (numero != 0) {
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				acumulador += numero;
				i++;
			}
		JOptionPane.showMessageDialog(null, "La media de todos los números es : " + (acumulador / (i - 1)));
	}
}
