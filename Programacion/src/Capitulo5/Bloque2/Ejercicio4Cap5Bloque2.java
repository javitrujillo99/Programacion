package Capitulo5.Bloque2;

public class Ejercicio4Cap5Bloque2 {

	public static void main(String[] args) {
		int array [] = new int [5], i = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Número [" + i + "] " + "= " + array[i]);
		}
		for (i = 0; i < array.length; i++) {
			System.out.println("Número [" + i + "] " + "= " + array[i]);
		}
	}

}
