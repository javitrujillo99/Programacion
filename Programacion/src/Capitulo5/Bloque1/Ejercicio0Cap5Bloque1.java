package Capitulo5.Bloque1;

import javax.swing.JOptionPane;

public class Ejercicio0Cap5Bloque1 {

	public static void main(String[] args) {
		int array [] = new int [150], i = 0, numeros = 0, sumatorio = 0, menor = 0, mayor = 0;
		for (i = 0; i < array.length; i++) {
			numeros = (int) Math.round(Math.random() * 100);
			System.out.println("Número [" + (i + 1) + "] " + "= " + numeros);
			sumatorio += numeros;
			if (numeros < menor ) {
				menor = numeros;
			}
			if (numeros > mayor) {
				mayor = numeros;
			}
		}
		float media = (float) sumatorio / i;
		JOptionPane.showMessageDialog(null, "La suma de todos los números es: " + sumatorio + "\n"
				+ "La media de todos los números es: " + media + "\n"
						+ "El menor es: " + menor + "\n"
								+ "El mayor es: " + mayor);

	}

}
