package Capitulo2.Bloque3;

import javax.swing.JOptionPane;

public class Ejercicio4Cap2Bloque3 {

	public static void main(String[] args) {
		int coste = Integer.parseInt(JOptionPane.showInputDialog("Coste: "));
		System.out.println("Coste = " + coste);
		int dinero = Integer.parseInt(JOptionPane.showInputDialog("Dinero introducido: "));
		System.out.println("Dinero introducido = " + dinero );
		int cambio = dinero - coste;
		System.out.println("Cambio = " + cambio);
		int monedas100 = cambio / 100;
		int resto100 = cambio % 100;
		int monedas50 = resto100 / 50;
		int resto50 = resto100 % 50;
		int monedas25 = resto50 / 25;
		int resto25 = resto50 % 25;
		int monedas5 = resto25 / 5;
		int resto5 = resto25 % 5;
		int monedas1 = resto5;
		
		if (cambio > 100) {
		System.out.println("\nMonedas de 100: " + monedas100 + "\n"
				+ "Monedas de 50: " + monedas50 + "\n"
						+ "Monedas de 25: " + monedas25 + "\n"
								+ "Monedas de 5: " + monedas5 + "\n"
										+ "Monedas de 1: " + monedas1); 
		}
		else {
			if (cambio > 50) {
				System.out.println("\nMonedas de 50: " + monedas50 + "\n"
						+ "Monedas de 25: " + monedas25 + "\n"
						+ "Monedas de 5: " + monedas5 + "\n"
								+ "Monedas de 1: " + monedas1);
			}
			else {
				if (cambio > 25) {
					System.out.println("\nMonedas de 25: " + monedas25 + "\n"
						+ "Monedas de 5: " + monedas5 + "\n"
								+ "Monedas de 1: " + monedas1);
				}
				else {
					if (cambio > 5) {
						System.out.println("\nMonedas de 5: " + monedas5 + "\nMonedas de 1: " + monedas1);
					}
				}
			}
		}
	}
}
