package Capitulo5.Bloque2;

import javax.swing.JOptionPane;

public class Ejercicio3Cap5Bloque2 {

	public static void main(String[] args) {
		int array [] = new int [150], i = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Número [" + i + "] " + "= " + array[i]);
		}
		int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número por el que desea multiplicar: "));
		System.out.println("\nLista de números multiplicados por " + num + ":");
		for (i = 0; i < array.length; i++) {
			array[i] = num * array[i];
			System.out.println("Número [" + i + "] " + "= " + array[i]);
		}
	}
}
