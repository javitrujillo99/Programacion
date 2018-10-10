package Capitulo3.Bloque3.EjerciciosConFor;

import javax.swing.JOptionPane;

public class Ejercicio1Cap3Bloque3 {

	public static void main(String[] args) {
		int sumatorio = 0;
		String mensaje = "Introduzca número (0 -> Terminar)";
		int numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		for (int i = 1; numero != 0; i++) {
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				sumatorio += numero;
			}
		JOptionPane.showMessageDialog(null, "La suma de todos los números es : " + sumatorio);
			
		}
	}
