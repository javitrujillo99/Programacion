package Capitulo4.Bloque1;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		//float media = media4Valores(4,5,6,(float) 7.8);
		//EJERCICIO 1 System.out.println("La media es: " + media);
		int num1 = 0, num2 = 0;
		peticion2NumerosYMayor();
		System.out.println("El mayor es: " + mayor(num1, num2));
	}
	
	//Ejercicio 1
	public static float media4Valores(int num1, int num2, int num3, float num4) {
		float media = (num1 + num2 + num3 + num4) / 4;
		return media;
	}
	
	public static void peticion2NumerosYMayor() {
		int num1 = pideNumeroEntero(0, 10);
		int num2 = pideNumeroEntero(0, 10);
		System.out.println("El mayor es: " + mayor(num1, num2));
	}
	
	public static int mayor (int num1, int num2) {
		if (num1 > num2) {
			return num1;
		}
		else {
			return num2;
		}
	}
	
	
	public static int pideNumeroEntero (int limInf, int limSup) {
			int num;
			do {
				num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número: "));
		}	while (num > limInf || num < limSup);
			return num;
	}
	
	
	
}