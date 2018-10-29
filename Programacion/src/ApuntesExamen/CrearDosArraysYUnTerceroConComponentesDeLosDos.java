package ApuntesExamen;

public class CrearDosArraysYUnTerceroConComponentesDeLosDos {

	public static void main(String[] args) {
		int longitudArray = 10;
		int array1 [] = new int [longitudArray];
		int array2 [] = new int [longitudArray];
		int array3 [] = new int [longitudArray];
		int i = 0;
		System.out.println("Array 1:");
		for (i = 0; i < array1.length; i++) {
			array1[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Array[" + i + "] = " + array1[i]);
			if (i % 2 != 0) {
				array3[i] = array1[i];
			}
		}
		System.out.println("\nArray 2:");
		for (i = 0; i < array2.length; i++) {
			array2[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Array[" + i + "] = " + array2[i]);
			if (i % 2 == 0) {
				array3[i] = array2[i];
			}
		}
		System.out.println("\nArray 3:");
		for (i = 0; i < array3.length; i++) {
			System.out.println("Array[" + i + "] = " + array3[i]);
		}

	}

}
