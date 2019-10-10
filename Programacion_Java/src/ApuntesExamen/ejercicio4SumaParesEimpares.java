package ApuntesExamen;

import javax.swing.JOptionPane;

public class ejercicio4SumaParesEimpares {

	public static void main(String[] args) {
		int array [] = new int [10], i = 0;
		int sumatorioPares = 0, sumatorioImpares = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Array[" + i + "] = " + array[i]);
			if (array[i] % 2 == 0) {
				sumatorioPares += array[i];
			}
			else {
				sumatorioImpares += array[i];
			}
		}
		JOptionPane.showMessageDialog(null, "La suma de los pares es: " + sumatorioPares + "\n"
				+ "La suma de los impares es: " + sumatorioImpares);
	}
}
