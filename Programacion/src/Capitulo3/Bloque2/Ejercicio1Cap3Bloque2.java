package Capitulo3.Bloque2;

import javax.swing.JOptionPane;

public class Ejercicio1Cap3Bloque2 {

	public static void main(String[] args) {
		int i, media = 0, sumatorio = 0;
		int n = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de variables que quiere que le pidan: "));
		for (i = 1; i <= n; i++ ) {
			sumatorio += Integer.parseInt(JOptionPane.showInputDialog("Introduzca número " + i));
			media = sumatorio / n;			
			}
		JOptionPane.showMessageDialog(null,"La media de los " + (i - 1) + " números es: " + (float)media);
		}
}
