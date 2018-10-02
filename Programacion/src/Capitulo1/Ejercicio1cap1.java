package Capitulo1;

import javax.swing.JOptionPane;

public class Ejercicio1cap1 {

	public static void main(String[] args) {
		/*
		Realiza un programa que pida al usuario tres números: uno de tipo entero, otro de tipo flotante
		y otro de tipo doble. A continuación se tienen que mostrar en pantalla los tres números en una
		sola fila de la consola de salida. 
		 */
		String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		int var1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca un número de tipo float: ");
		float var2 = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduzca un número de tipo double: ");
		double var3 = Double.parseDouble(str);
		
		System.out.println("Los números introducidos son: " + var1 + ", " + var2 + "y " + var3);

	}

}
