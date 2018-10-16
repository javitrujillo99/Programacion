package Capitulo5.Bloque1;


public class Ejercicio2Cap5Bloque1 {

	public static void main(String[] args) {
		int array [] = new int [150];
		for (int i = array.length; i > 0; i--) {
			int numeros = (int) Math.round(Math.random() * 100);
			System.out.println("Número [" + i + "]" + " = " + numeros);
		}
	}
}
