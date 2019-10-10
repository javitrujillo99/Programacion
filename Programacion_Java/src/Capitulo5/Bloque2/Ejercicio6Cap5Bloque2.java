package Capitulo5.Bloque2;

import javax.swing.JOptionPane;

public class Ejercicio6Cap5Bloque2 {

	public static void main(String[] args) {
		int array [] = new int [5], i = 0, numero;
		System.out.println("ARRAY PRIMARIO:");
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Número [" + i + "] " + "= " + array[i]);
		}
		
		int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de veces que quiere rotar el array:"));
		for (int j = 0; j < num; j++) {
			System.out.println("\nDESPLAZAMIENTO CIRCULAR " + (j + 1) + ":");
			numero = array[array.length - 1];
			for (i = array.length - 1; i > 0; i--) {
			array[i] = array[i - 1];	
			}
			array[0] = numero;
			for (i = 0; i < array.length; i++) {
				System.out.println("Número [" + i + "] " + "= " + array[i]);
			}
		}
	}
}
