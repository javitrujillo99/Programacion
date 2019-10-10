package Capitulo3.Bloque3.EjerciciosConFor;

import javax.swing.JOptionPane;

public class Ejercicio6Cap3Bloque3 {

	public static void main(String[] args) {
		String mensaje = "Introduzca número (0 -> Terminar)";
		int numero = 1;
		for (; numero != 0;) {
			numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			if (numero != 0) {
				for (int i = 0; i <= 10; i++) {
					System.out.println(numero + " x " + i + " = " + (i * numero));
				}
			}
		}
	}
}