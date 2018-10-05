package Capitulo3.Bloque2;

import javax.swing.JOptionPane;

public class Ejercicio2Cap3Bloque2 {

	public static void main(String[] args) {
		int mayor = 0, menor = 0;
		int n = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de variables que quiere que le pidan: "));
		for (int i = 1; i <= n; i++) {
			int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número " + i));
			for (numero = i; numero < mayor; numero++) {
				mayor = numero;
			}
		}
		JOptionPane.showMessageDialog(null, "El mayoe es: " + mayor);
	}

}
