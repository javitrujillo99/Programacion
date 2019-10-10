package PrimerExamenProgramacion2018;

public class MainEjercicioD {

	public static void main(String[] args) {
		//Declaración de las variables longitudArray, array1, array2 y repetido
		int longitudArray = 5, i = 0;
		int array1 [] = new int [longitudArray];
		int array2 [] = new int [longitudArray];
		
		//Generación del array1 e impresión en pantalla
		System.out.println("Array 1:");
		for (i = 0; i < array1.length; i++) {
			array1[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Array [" + i + "] = " + array1[i]);
		}
		//Generación del array2
		System.out.println("\nArray 2:");
		for (i = 0; i < array2.length; i++) {
			boolean repetido = false;
			//Declaración de la variable lugar que indica en qué posición se pondrá del array1 en el array2
			int lugar = (int) Math.round(Math.random() * (longitudArray - 1));
			//Generación de una variable j que lea el array
			for (int j = 0; j < array2.length; j++) {
				//Condición de que las variables del array2 sí estén repetidas
				if (array2[j] == array1[i]) {
					repetido = true;
				}
				//Condición en la que las variables del array2 no están repetidas, en tal caso copiamos la variable en el array2
				else {
					array2[i] = array1[lugar];
				}
			}
			//Generación de otro lugar al azar en caso de que se repita
			if (repetido == true) {
				lugar = (int) Math.round(Math.random() * (longitudArray - 1));
			}
		}
		//Impresión en pantalla del array
		for (i = 0; i < array2.length; i++) {
			System.out.println("Array [" + i + "] = " + array2[i]);
		}
	}
}
