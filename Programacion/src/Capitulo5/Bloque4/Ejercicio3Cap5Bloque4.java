package Capitulo5.Bloque4;

public class Ejercicio3Cap5Bloque4 {
	private static int parteEntera;
	private static float parteDecimal;
	
	public static void main(String[] args) {
		float array[] = creaArray();
		imprimeArray(array);
		examinarNumeros(array);
		}
	
	private static float[] creaArray() {
		float array[] = new float[20];
		for (int i = 0; i < array.length; i++) {
			array[i] = crearNumeroDecimalPorPartes(parteEntera, parteDecimal);
		}
		return array;
	}
	
	private static void imprimeArray(float array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	private static int examinarNumeros(float array[]) {
		int contador = 0;
		for (int i = 0; i < array.length; i++) {
			parteEntera = (int) array[i];
			parteDecimal = array[i] - parteEntera;
			if (parteDecimal <= 0.49) {
				contador++;
			}
		}
		System.out.println("Numeros cuyos decimales estan entre 00 y 49: " + contador);
		return contador;
	}
	
	private static float crearNumeroDecimalPorPartes(int parteEntera, float parteDecimal) {
		parteEntera = (int) (Math.round(Math.random() * 100));
		float parteDecimalPrimitiva = (int) (Math.round(Math.random() * (99 - 1) + 1));
		parteDecimal = parteDecimalPrimitiva / 100;
		float numeroCompleto = (float) (parteEntera + parteDecimal);
		return numeroCompleto;
	}
	
	
}
	
