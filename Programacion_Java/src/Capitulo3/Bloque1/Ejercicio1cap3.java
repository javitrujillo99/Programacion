package Capitulo3.Bloque1;

import javax.swing.JOptionPane;

public class Ejercicio1cap3 {

	public static void main(String[] args) {
		int i, acumuladorNumerosMayoresDiez = 0;
		for (i = 1; i < 5; i++ ) {
			int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número " + i));
			
			if (numero > 10) {
				acumuladorNumerosMayoresDiez += numero;
			}
		}
		JOptionPane.showMessageDialog(null, "Total acumulado: " + acumuladorNumerosMayoresDiez);
	}
}
