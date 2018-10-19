package Capitulo5.Bloque3;

public class Ejercicio1Cap5Bloque3 {

	public static void main(String[] args) {
		int array [] = new int [5], i = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Número [" + i + "] " + "= " + array[i]);
		}	
	}
}
