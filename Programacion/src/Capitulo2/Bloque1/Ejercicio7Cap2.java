package Capitulo2.Bloque1;

import javax.swing.JOptionPane;

public class Ejercicio7Cap2 {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		int var1 = Integer.parseInt(str);
		System.out.println("Número: " + var1); 
		
		if ((var1 & 1) == 1) {
			System.out.println("El número " + var1 + " es impar.");
		}
		else {
			System.out.println("El número " + var1 + " es par.");
		}

	}

}
