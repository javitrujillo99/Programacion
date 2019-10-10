package Capitulo2.Bloque1;

import javax.swing.JOptionPane;

public class Ejercicio2Cap2 {

	public static void main(String[] args) {
		//Repetir el ejercicio anterior para mostrar el número menor de los dos introducidos.
		String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		int var1 = Integer.parseInt(str);
		System.out.println("Primer número: " + var1);
		
		str = JOptionPane.showInputDialog("Introduzca otro número entero: ");
		int var2 = Integer.parseInt(str);
		System.out.println("Segundo número: " + var2);
		
		if (var1 < var2) {
			System.out.println("\nEl número menor es el " + var1);
		}
		else {
			if (var1 == var2) {
				System.out.println("\nLos dos números son iguales a " + var1);
			}
			else {
			System.out.println("\nEl número menor es el " + var2);
			}
		}
		 

	}

}
