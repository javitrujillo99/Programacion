package Capitulo2.Bloque1;

import javax.swing.JOptionPane;

public class Ejercicio6Cap2 {

	public static void main(String[] args) {
		/*Realizar un ejercicio en C que pida un número al usuario e indique en pantalla si se trata
		 * de un número par o impar. Recuerda que un número par es aquel cuyo resto de su división 
		 * entre dos sea siempre cero, y recuerda que un número impar es aquel cuyo
		 * resto de su división entre dos sea siempre uno. 
		 */
		String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		int var1 = Integer.parseInt(str);
		System.out.println("Número: " + var1);
		
		if (var1 % 2 == 0) {
			System.out.println("El número " + var1 + " es par.");
		}
		else {
			System.out.println("El número " + var1 + " es impar.");
		}

	}

}
