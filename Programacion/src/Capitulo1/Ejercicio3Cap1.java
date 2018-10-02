package Capitulo1;

import javax.swing.JOptionPane;

public class Ejercicio3Cap1 {

	public static void main(String[] args) {
		// Realiza un programa que pida al usuario tres números y calcule y muestre en pantalla la suma de los tres.
		
		String x = JOptionPane.showInputDialog("Introduzca un número entero");
		int var1 = Integer.parseInt(x);
		System.out.println("Número introducido: " + var1);
		
		String y = JOptionPane.showInputDialog("Introduzca otro número entero");
		int var2 = Integer.parseInt(y);
		System.out.println("Número introducido: " + var2);
		
		String z = JOptionPane.showInputDialog("Introduzca otro número entero");
		int var3 = Integer.parseInt(z);
		System.out.println("Número introducido: " + var3);
		
		int suma = var1 + var2 + var3;
		System.out.println("La suma de los tres números es: " + suma);
		
		

	}

}
