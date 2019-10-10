package Capitulo3.Bloque3.EjerciciosConFor;

import javax.swing.JOptionPane;

public class Ejercicio3Cap3Bloque3 {

	public static void main(String[] args) {
		int mayor = 0, numero = 1;
		String mensaje = "Introduzca número (0 -> Terminar)";
		
		for (int i = 1; numero != 0; i++) {
			if (i == 1) { //Primera iteración
				mayor = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			}
			else {
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				if (numero > mayor && numero != 0) {
				mayor = numero;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "El mayor es: " + mayor);

	}

}
