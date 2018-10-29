package ApuntesExamen;

public class CambiarDeSignoNumerosPares {

	public static void main(String[] args) {
		int array [] = new int [10], i = 0;
		System.out.println("Array original:");
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * (-200) + 100);
			System.out.println("Array[" + i + "] = " + array[i]);
		}
		System.out.println("\nArray con los números pares cambiados de signo:");
		for (i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				array[i] = -array[i];
			}
			System.out.println("Array[" + i + "] = " + array[i]);
		}
	}
}
