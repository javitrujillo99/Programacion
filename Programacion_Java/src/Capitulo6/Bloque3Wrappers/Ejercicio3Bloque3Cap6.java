package Capitulo6.Bloque3Wrappers;

public class Ejercicio3Bloque3Cap6 {

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			String numeroHexadecimal = Integer.toHexString(i);
			System.out.println("Número " + i + " en hexadecimal: " + numeroHexadecimal);
		}
	}

}
