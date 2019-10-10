package PrimerExamenProgramacion2018;

import javax.swing.JOptionPane;

public class MainEjercicioB {

	public static void main(String[] args) {
		//Declaración de variables array, liminf y limSup
		int array [] = new int [100], i = 0;
		int limInf = Integer.parseInt(JOptionPane.showInputDialog("Escriba límite inferior: "));
		int limSup = Integer.parseInt(JOptionPane.showInputDialog("Escriba límite superior: "));
		
		System.out.println("Array en orden normal:");
		//Generación e impresión en pantalla del array entre los límites establecidos en orden normal
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * (limSup - limInf) + limInf);
			System.out.println("Array [" + i + "] = " + array[i]);
		}
		System.out.println("\nArray en orden invertido:");
		//Generación e impresión en pantalla del array entre los límites establecidos en orden invertido
		for (i = array.length - 1; i >= 0; i--) {
			System.out.println("Array [" + i + "] = " + array[i]);
		}
	}
}
