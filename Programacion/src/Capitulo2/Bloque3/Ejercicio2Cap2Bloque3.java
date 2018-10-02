package Capitulo2.Bloque3;

import javax.swing.JOptionPane;

public class Ejercicio2Cap2Bloque3 {

	public static void main(String[] args) {
		String menu = "Menu\n"
				+ "1.-Suma de dos números\n"
				+ "2.-Resta de dos números";
		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		if (opcion < 1 || opcion > 3) {
			JOptionPane.showMessageDialog(null,"SYNTAX ERROR");
			System.exit(0);
			
		}
			
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca primer número: ")); 
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca segundo número: "));
		int suma = num1 + num2;
		int resta = num1 - num2;
		int multiplicacion = num1 * num2;
		
		switch (opcion) {
		case 1: //Suma de dos números
			JOptionPane.showMessageDialog(null, "Resultado = " + suma);
			break;
		case 2: //Resta de dos números
			JOptionPane.showMessageDialog(null, "Resultado = " + resta);
			break;
		case 3: //Multiplicación de dos números
			JOptionPane.showMessageDialog(null, "Resultado = " + multiplicacion);
			break;

		}

	}

}
