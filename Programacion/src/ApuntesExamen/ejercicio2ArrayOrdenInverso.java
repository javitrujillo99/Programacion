package ApuntesExamen;

public class ejercicio2ArrayOrdenInverso {

	public static void main(String[] args) {
		int array[] = new int [5], i = 0;
		System.out.println("Array original:");
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Array [" + i + "] = " + array[i]);
		}
		System.out.println("Orden inverso");
		for (i = array.length - 1; i >= 0; i--) {
			System.out.println("Array [" + i + "] = " + array[i]);
		}
		
	}

}
