package Capitulo5.Bloque1;

import javax.swing.JOptionPane;

public class Ejercicio0Cap5Bloque1 {

	public static void main(String[] args) {
		int array [] = new int [150], i = 0, sumatorio = 0;
		int mayor = array[0];
		int menor = 100;
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Número [" + (i + 1) + "] " + "= " + array[i]);
			sumatorio += array[i];
			if (array[i] < menor ) {
				menor = array[i];
			}
			if (array[i] > mayor) {
				mayor = array[i];
			}
		}
		float media = (float) sumatorio / i;
		JOptionPane.showMessageDialog(null, "La suma de todos los números es: " + sumatorio + "\n"
				+ "La media de todos los números es: " + media + "\n"
						+ "El menor es: " + menor + "\n"
								+ "El mayor es: " + mayor);

	}

}
