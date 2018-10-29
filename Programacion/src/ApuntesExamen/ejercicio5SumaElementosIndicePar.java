package ApuntesExamen;

import javax.swing.JOptionPane;

public class ejercicio5SumaElementosIndicePar {

	public static void main(String[] args) {
		int array [] = new int [10], i = 0;
		int sumatorio = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Array[" + i + "] = " + array[i]);
			if (i % 2 == 0) {
				sumatorio += array[i];
			}
		}
		JOptionPane.showMessageDialog(null, "La suma de los números con índice par es: " + sumatorio);

	}

}
