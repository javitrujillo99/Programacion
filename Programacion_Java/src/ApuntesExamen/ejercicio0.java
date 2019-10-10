package ApuntesExamen;

import javax.swing.JOptionPane;

public class ejercicio0 {

	public static void main(String[] args) {
		int array [] = new int [20], i = 0;
		float media = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Array[" + i + "] = " + array[i]);
		}
		
		int sumatorio = array[0];
		int mayor = array [0];
		int menor = array[0];
		
		for (i = 1; i < array.length; i++) {
			sumatorio += array[i];
			if (array[i] > mayor) {
				mayor = array[i];
			}
			
			if (array[i] < menor) {
				menor = array[i];
			}
		}
		media = (float) sumatorio / array.length;
		JOptionPane.showMessageDialog(null, "La suma de todos los números es: " + sumatorio + "\n"
				+ "La media es: " + media + "\n"
						+ "El mayor es el " + mayor + "\n"
								+ "El menor es el " + menor);
	}
}
