package Capitulo5.Bloque1;


public class Ejercicio2Cap5Bloque1 {

	public static void main(String[] args) {
		int array [] = new int [5], i = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Número [" + i + "]" + " = " + array[i]);
		}
		System.out.println("\nAHORA EN ORDEN INVERSO:");
		for (i = array.length - 1; i >= 0; i--) {
			System.out.println("Número [" + i + "]" + " = " + array[i]);
		}
	}
}
