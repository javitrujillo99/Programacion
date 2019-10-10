package Capitulo1;

import javax.swing.JOptionPane;

public class Ejercicio2cap1 {

	public static void main(String[] args) {
		/*
		 Realiza un programa igual al anterior, con la particularidad de que ahora se debe mostrar
		 cada número justo a continuación del momento en que ha sido introducido.
		 */
		
		String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		int var1 = Integer.parseInt(str);
		System.out.println("El número introducido es: " + var1);
		
		str = JOptionPane.showInputDialog("Introduzca un número de tipo float: ");
		float var2 = Float.parseFloat(str);
		System.out.println("El número introducido es: " + var2);
		
		str = JOptionPane.showInputDialog("Introduzca un número de tipo double: ");
		double var3 = Double.parseDouble(str);
		System.out.println("El número introducido es: " + var3);
	
	}

}
