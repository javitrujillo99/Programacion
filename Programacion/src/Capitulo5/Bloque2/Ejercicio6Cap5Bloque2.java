package Capitulo5.Bloque2;

import javax.swing.JOptionPane;

public class Ejercicio6Cap5Bloque2 {

	public static void main(String[] args) {
		int array [] = new int [5], i = 0, primero = 0, num;
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Número [" + i + "] " + "= " + array[i]);
		}
		num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca cuántas veces quiere rotar el array: "));
		for (int j = 0; j < num; j++) {
			primero = array[4];
			System.out.println("\nDESPLAZAMIENTO CIRCULAR " + (j + 1) + ":");
			System.out.println("Número [0] = " + primero);
			for (i = 0; i < array.length - 1; i++) {
				System.out.println("Número [" + (i + 1) + "] " + "= " + array[i]);
			}
		}
	}
}
