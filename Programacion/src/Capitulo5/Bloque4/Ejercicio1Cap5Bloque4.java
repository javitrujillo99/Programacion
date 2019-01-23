package Capitulo5.Bloque4;

public class Ejercicio1Cap5Bloque4 {
	int numAleat = (int) (Math.round(Math.random() * 10));
	int[] array = new int[numAleat];

	public static void main(String[] args) {
		int numAleat = (int) (Math.round(Math.random() * 10));
		int[] array = new int[numAleat];
		ejercicio(array);
	} 
	
	private static int ejercicio(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int num = (int) (Math.round(Math.random() * 100));
			array[i] = num;
			System.out.println(array[i]);
		}
		if (array.length % 2 == 0) {
			System.out.println("La longitud del array es: " + array.length + " , es un numero par");
			System.out.println("- 1");
			return -1;
		}
		else {
			System.out.println("La longitud del array es: " + array.length + " , es un numero impar");
			int posicionMedia = array[array.length / 2];
			System.out.println("El numero de la posicion " + (array.length / 2) + " (posicion media) es: " + posicionMedia);
			return posicionMedia;
		}
	}
	
}


