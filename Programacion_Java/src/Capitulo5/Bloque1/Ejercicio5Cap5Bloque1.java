package Capitulo5.Bloque1;

import javax.swing.JOptionPane;

public class Ejercicio5Cap5Bloque1 {

	public static void main(String[] args) {
		int array [] = new int [5], i = 0, sumatorioIndicePar = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Número [" + i + "]" + " = " + array[i]);
			if (i % 2 == 0) {
				sumatorioIndicePar += array[i];
			}
		}
		JOptionPane.showMessageDialog(null, "La suma de los números de índice par es: " + sumatorioIndicePar);
	}
}
