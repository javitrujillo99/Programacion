package Capitulo1;

import javax.swing.JOptionPane;

public class Ejercicio5cap1 {

	public static void main(String[] args) {
		/*Realiza un programa en C que pida dos variables al usuario, intercambie los valores de las dos variables y
		las muestre en pantalla ANTES y DESPUÈS del intercambio de valores.
		*/
		String str = JOptionPane.showInputDialog("Introduzca una variable: ");
		int var1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca otra variable: ");
		int var2 = Integer.parseInt(str);
		
		System.out.println("Las variable uno es: " + var1 + ", y la variable dos es: " + var2);
		
		int aux = var1;
		var1 = var2;
		var2 = aux;
		System.out.println("Ahora la variable uno es: " + var1 + ", y la variable dos es: " + var2);
		
		
	}

}
