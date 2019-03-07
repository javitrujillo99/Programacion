package Capitulo6.Bloque2;

public class Ejercicio2Bloque2Cap6 {

	public static void main(String[] args) {
		for (float x = 0.0001f; x < 1; x += 0.0001) {
			float y1 = (float) Math.sqrt(x);
			System.out.println("x: " + x + ", y1: " + y1);
			float y2 = (float) (0 - Math.log(x));
			System.out.println("x: " + x + ", y2: " + y2);
			
			if (Math.abs(y2-y1) < 0.0001) {
				System.out.println("Solucion encontrada en x = " + x + ", y = " + y1);
				break;
			}
		}
	}

}
