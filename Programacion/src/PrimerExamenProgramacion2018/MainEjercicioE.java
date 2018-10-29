package PrimerExamenProgramacion2018;

public class MainEjercicioE {

	public static void main(String[] args) {
		//Declaración de las variables array, i,  y repetido
		int array [] = new int [20], i = 0;		
		//Generación del array con 20 números al azar entre 0 y 40
		for (i = 0; i < array.length; i++) {
			boolean repetido = false;
			array[i] = (int) Math.round(Math.random() * 40);
			//Generación de una variable j que lee el array y comprueba si está repetido el número generado al azar
			for (int j = 0; j < i; j++) {
				//Condición en el caso en el que el número generado está repetido
				if (array[j] == array[i]) {
					repetido = true;
				}
				//Condición en el caso en el que el número generado no está repetido, en tal caso añadimos el valor
				else {
					array [i] = array[i];
				}
			}
			//Generación de otro número al azar en caso de que se repita
			if (repetido == true) {
			array[i] = (int) Math.round(Math.random() * 40);
			}
		}
		//Impresión en pantalla del array
		for (i = 0; i < array.length; i++) {
			System.out.println("Array [" + i + "] = " + array[i]);
		}
	}
}
