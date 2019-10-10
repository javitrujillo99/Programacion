package Pruebas;



public class PruebaTiempo {

private static final int FILAS = 6;
private static final int COLUMNAS = 7;

	public static int[][] calendario(int FILAS, int COLUMNAS) {
		int[][] calendario = new int[FILAS][COLUMNAS];
		int dias = 1;
		for (int i = 0; i < FILAS; i++) {
			System.out.println(" ");
			for (int j = 0; j < COLUMNAS; j++) {
				calendario[i][j] = dias;
				System.out.print(" " + calendario[i][j]);
				dias++;
			}
		}
		return calendario;
	}


	public static void main(String[] args) {
		calendario(FILAS, COLUMNAS);
	}
	
}


