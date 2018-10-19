package Capitulo5.Bloque2;

import javax.swing.JOptionPane;

public class Ejercicio7Cap5Bloque2 {

	public static void main(String[] args) {
		int array [] = new int [5], i = 0, numero;
		System.out.println("ARRAY PRIMARIO:");
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Número [" + i + "] " + "= " + array[i]);
		}
		int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de veces que quiere rotar el array:"));
		int sentido = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el sentido en el que quiere rotar array:\n"
				+ "0 ------> Derecha a izquierda \n"
				+ "1 ------> Izquierda a derecha"));
		if (sentido != 0 && sentido != 1) {
			JOptionPane.showMessageDialog(null, "ERROR, DEBES INTRODUCIR 0 O 1");
		}
			if (sentido == 0) {
				for (int j = 0; j < num; j++) {
					System.out.println("\nDESPLAZAMIENTO CIRCULAR " + (j + 1) + ":");
					numero = array[4];
					for (i = array.length - 1; i > 0; i--) {
					array[i] = array[i - 1];	
					}
					array[0] = numero;
					for (i = 0; i < array.length; i++) {
						System.out.println("Número [" + i + "] " + "= " + array[i]);
					}
				}
			}
			else {
				if (sentido == 1) {
					for (int j = 0; j < num; j++) {
						System.out.println("\nDESPLAZAMIENTO CIRCULAR " + (j + 1) + ":");
						numero = array[0];
						for (i = 0; i < array.length - 1; i++) {
						array[i] = array[i + 1];	
						}
						array[4] = numero;
						for (i = 0; i < array.length; i++) {
							System.out.println("Número [" + i + "] " + "= " + array[i]);
					}
				}
			}
		}
	}
}
