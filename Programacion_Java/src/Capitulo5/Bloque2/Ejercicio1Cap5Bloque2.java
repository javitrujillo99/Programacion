package Capitulo5.Bloque2;

public class Ejercicio1Cap5Bloque2 {

	public static void main(String[] args) {
		int array [] = new int [150], i = 0;
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * (-200) + 100);
			System.out.println("Número [" + i + "] " + "= " + array[i]);
			if (array[i] > 0 && (array[i] % 2 == 0)) {
				array[i] = -array[i];
			}
			else {
				if (array[i] < 0 && (array[i] % 2 == 0))
				array[i] = -array[i];
			}
			System.out.println("Número [" + i + "] " + "con signo cambiado = " + array[i]);
		}
	}
}
