package PrimerExamenProgramacion2018;

public class MainEjercicioC {

	public static void main(String[] args) {
		//Declaración de la variable array
		int array [] = new int [20], i = 0;
		
		//Generación del array entre los límites establecidos
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * (100 - 25) + 25);
			//Impresión en pantalla de los números pares en caso de que lo sean
			if (array[i] % 2 == 0) {
				System.out.println("Array [" + i + "] = " + array[i]);
			}
			//En caso de que no sea par, proceso en el que volvemos atrás una vez la i
			else {
				i--;
			}
		}
	}
}
