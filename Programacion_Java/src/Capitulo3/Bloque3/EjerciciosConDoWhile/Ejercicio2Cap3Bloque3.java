package Capitulo3.Bloque3.EjerciciosConDoWhile;

import javax.swing.JOptionPane;

public class Ejercicio2Cap3Bloque3 {

	public static void main(String[] args) {
		float numero = 1, acumulador = 0, i = 0;
		String mensaje = "Introduzca número (0 -> Terminar)";
		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			acumulador += numero;
			i++;
		}
		while (numero != 0);
		JOptionPane.showMessageDialog(null, "La media de todos los números es : " + (acumulador / (i - 1)));
	}
}