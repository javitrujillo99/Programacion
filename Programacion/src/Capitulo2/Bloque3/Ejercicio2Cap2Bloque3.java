package Capitulo2.Bloque3;

import javax.swing.JOptionPane;

public class Ejercicio2Cap2Bloque3 {

	public static void main(String[] args) {
		//NO ENTIENDO POR QUÉ NO SALE BIEN LA RAÍZ CÚBICA Y LA RAÍZ ENÉSIMA, PREGUNTAR A RAFA.
		
		
		String menu = "                        MENÚ\n"
				+ "1.-Suma de dos números\n"
				+ "2.-Resta de dos números\n"
				+ "3.-Multiplicación de dos números\n"
				+ "4.-División de dos números\n"
				+ "5.-Raíz cuadrada de un número\n"
				+ "6.-Raíz cúbica de un número\n"
				+ "7. Raíz enésima de un número\n"
				+ "8. Cuadrado de un número\n"
				+ "9. Número elevado al cubo\n"
				+ "10.-Número elevado a lo que indique el usuario";
		
		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		if (opcion < 1 || opcion > 10) {
			JOptionPane.showMessageDialog(null,"SYNTAX ERROR");
			System.exit(0);
		}
		if (opcion >= 1 && opcion <= 4) {
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca primer número: ")); 
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca segundo número: "));
		int suma = num1 + num2;
		int resta = num1 - num2;
		int multiplicacion = num1 * num2;
		int division = num1 / num2;
		int resto = num1 % num2;
		
		
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
		case 4: //División de dos números
			JOptionPane.showMessageDialog(null, "Resultado = " + division + "\nResto = " + resto);
			break;
		}
		}
		else {
		int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número: "));
		int raiz = (int) Math.sqrt(num);
		int raizcubica= (int) Math.pow(num, (1/3));
		int cuadrado = num * num;
		int cubo = cuadrado * num;
		
		switch (opcion) {
		case 5: //Raíz cuadrada de un número
			JOptionPane.showMessageDialog(null, "Resultado = " + raiz);
			break;	
		case 6: //Raíz cúbica de un número
			JOptionPane.showMessageDialog(null, "Resultado = " + raizcubica);
			break;
		case 7: //La raíz enésima de un número, n lo indica el usuario.
			int n = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el índice de la raíz: "));
			int raizenesima = (int) Math.pow(num, (1/n));
			JOptionPane.showMessageDialog(null, "Resultado = " + raizenesima);
			break;
		case 8: //Un número elevado al cuadrado
			JOptionPane.showMessageDialog(null, "Resultado = " + cuadrado);
			break;	
		case 9: //Un número elevado al cubo
			JOptionPane.showMessageDialog(null, "Resultado = " + cubo);
			break;
		case 10: //Un número elevado a un número que indique el usuario
			int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca a qué número quiere elevar: "));
			int potencia = (int) Math.pow(num, num2);
			JOptionPane.showMessageDialog(null, "Resultado = " + potencia);
			break;
		}
		}
	}

}
