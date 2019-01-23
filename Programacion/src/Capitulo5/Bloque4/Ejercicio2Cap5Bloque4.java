package Capitulo5.Bloque4;

public class Ejercicio2Cap5Bloque4 {
	
	public static void main(String[] args) {
		int array[] = new int[200];
		calculaPorcentajeAprobado(array);

	}
	
	public static void calculaPorcentajeAprobado (int array[]) {
		int contadorAprobados = 0;
		int contadorSuspensos = 0;
		for (int i = 0; i < array.length; i++) {
			int num = (int) (Math.round(Math.random() * 10));
			array[i] = num;
			if (array[i] >= 5) {
				contadorAprobados++;
			}
			else {
				contadorSuspensos++;
			}
		}
		double porcentajeAprobados = contadorAprobados * 100 / ((float) array.length);
		double porcentajeSuspensos = contadorSuspensos * 100.0 / ((float)array.length);
		System.out.println("Porcentaje de aprobados: " + porcentajeAprobados);
		System.out.println("Porcentaje de suspensos: " + porcentajeSuspensos);
	}

}
