package PrimerExamenProgramacion2018;

import javax.swing.JOptionPane;

public class MainEjercicioA {

	public static void main(String[] args) {
		//Declaración de variables array, media e i
		int array [] = new int [100], i = 0;
		float media = 0;
		//Inicialización del array de números aleatorios entre los límites e impresión en pantalla de dicho array
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 1000);
			System.out.println("Array[" + i + "] = " + array[i]);
		}
		
		//Declaración de variables sumatorio, media y menor
		int sumatorio = array[0];
		int mayor = array [0];
		int menor = array[0];
		
		//Inicialización del array en el que vamos a calcular la suma,
		//el mayor y el menor de dicho array
		for (i = 1; i < array.length; i++) {
			//Cálculo del sumatorio
			sumatorio += array[i];
			//Generación del número mayor del array
			if (array[i] > mayor) {
				mayor = array[i];
			}
			//Generación del número menor del array
			if (array[i] < menor) {
				menor = array[i];
			}
		}
		//Cálculo de la media
		media = (float) sumatorio / array.length;
		//Impresión en pantalla de los resultados
		JOptionPane.showMessageDialog(null, "La suma de todos los números es: " + sumatorio + "\n"
				+ "La media es: " + media + "\n"
						+ "El valor máximo es el " + mayor + "\n"
								+ "El valor mínimo es el " + menor);
	}
}
