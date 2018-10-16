package Capitulo5.Bloque1;

import javax.swing.JOptionPane;

public class Ejercicio4Cap5Bloque1 {

	public static void main(String[] args) {
		int array [] = new int [150], i = 0, sumatorioPares = 0, sumatorioImpares = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Número [" + (i + 1) + "]" + " = " + array[i]);
			if (array[i] % 2 == 0) {
				sumatorioPares += array[i];
			}
			else {
				sumatorioImpares += array[i];
			}
		}
		JOptionPane.showMessageDialog(null, "La suma de los números pares es: " + sumatorioPares + "\n"
				+ "La suma de los números impares es: " + sumatorioImpares);
	}

}
