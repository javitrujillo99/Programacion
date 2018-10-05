package Capitulo3.Bloque1;

import javax.swing.JOptionPane;

public class Ejercicio2Cap3 {
	
	public static void main(String[] args) {
		int i, acumuladorNumerosMayoresDiez = 0;
		int n = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de variables que quiere poner: "));
		for (i = 1; i <= n; i++ ) {
			int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número " + i));
			
			if (numero > 10) {
				acumuladorNumerosMayoresDiez += numero;
			}
		}
		JOptionPane.showMessageDialog(null, "Total acumulado: " + acumuladorNumerosMayoresDiez);

	}

}
