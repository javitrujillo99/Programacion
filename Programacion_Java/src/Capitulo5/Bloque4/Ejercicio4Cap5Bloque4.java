package Capitulo5.Bloque4;

import javax.swing.JOptionPane;

public class Ejercicio4Cap5Bloque4 {
	
	
	public static void main(String[] args) {
		int matriz[][] = creaMatriz();
		imprimeMatriz(matriz);
		comprobarSiMatrizEsPositiva(matriz);
		comprobarSiMatrizEsDiagonal(matriz);
		comprobarSiMatrizEsTriangularSuperior(matriz);
		comprobarSiEsSimetrica(matriz);
		comprobarSiEsDispersa(matriz);
		convertirMatrizEnArrayUnidimensional(matriz);
		obtenerMatrizTraspuesta(matriz);
		obtenerMatrizOpuesta(matriz);
		//eliminarFilaImpuestaPorUsuario(matriz);
		
	}
	private static int[][] creaMatriz () {
				
				int matriz[][] = new int[3][5];
				
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						matriz[i][j] = (int) Math.round(Math.random()*100);
					}
				}
		/*		
				// Otra forma
				int matriz[][] = new int[][] {
					{2,		0, 		4, 	    5, 		5},
					{2, 	7, 		0,		5,		5},
					{2, 	7, 		4, 		0, 		5},
					{2, 	7, 		4, 	    5, 		0},
					{0, 	7, 		4, 		5, 		5}
				};
				*/
				return matriz;
			}
	
	private static void imprimeMatriz (int matriz[][]) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
	
	private static boolean comprobarSiMatrizEsPositiva(int matriz[][]) {
		boolean sonTodosPositivos = true;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] < 0) {
					sonTodosPositivos =  false;
				}
				
			}
		}
		if (sonTodosPositivos) {
			System.out.println("\nTodos los numeros son positivos");
		}
		else {
			System.out.println("\nTodos los numeros no son positivos");
		}
		return sonTodosPositivos;
	}
	
	private static boolean comprobarSiMatrizEsDiagonal(int matriz[][]) {
		boolean esDiagonal = true;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (i != j && matriz[i][j] != 0) {
					esDiagonal = false;
				}
			}
		}
		if (esDiagonal) {
			System.out.println("La matriz es diagonal");
		}
		else {
			System.out.println("La matriz no es diagonal");
		}
		return esDiagonal;
	}
	
	private static boolean comprobarSiMatrizEsTriangularSuperior(int matriz[][]) {
		boolean esTriangularSuperior = true;
		for (int i = 1; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (i > j && matriz[i][j] != 0) {
					esTriangularSuperior = false;
				}
			}
		}
		if (esTriangularSuperior) {
			System.out.println("La matriz es triangular superior");
		}
		else {
			System.out.println("La matriz no es triangular superior");
		}
		return esTriangularSuperior;
	}
	
	private static boolean comprobarSiEsSimetrica (int matriz[][]) {
		boolean esSimetrica = true;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] != matriz[j][i])
					esSimetrica = false;
			}
		}
		if (esSimetrica) {
			System.out.println("La matriz es simetrica");
		}
		
		else {
			System.out.println("La matriz no es simetrica");
		}
		
		return esSimetrica;
	}
	
	private static boolean comprobarSiEsDispersa(int matriz[][]) {
		boolean filaDispersa = false;
		boolean matrizEsDispersa = false;
		boolean columnaDispersa = false;
		int contador = 0;
		int contador1 = 0;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == 0) {
					filaDispersa = true;
				}
				else {
					filaDispersa = false;
				}
				if (filaDispersa) {
					contador++;
				}
			}
		}
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[j][i] == 0) {
					columnaDispersa = true;
				}
				else {
					columnaDispersa = false;
				}
				if (columnaDispersa) {
					contador1++;
				}
			}
		}
		if (contador == matriz[0].length && contador1 == matriz.length) {
			matrizEsDispersa = true;
			System.out.println("La matriz es dispersa");
		}
		else {
			System.out.println("La matriz NO es dispersa");
		}
		return matrizEsDispersa;
	}
	
	private static int[] convertirMatrizEnArrayUnidimensional(int matriz[][]) {
		int arrayUnidimensional[] = new int[matriz.length * matriz[0].length];
		System.out.println("\nMatriz convertida en array unidimensional");
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					arrayUnidimensional[matriz.length * i + j] = matriz[i][j];
					System.out.print(arrayUnidimensional[matriz.length * i + j] + " ");
				}
			}
		return arrayUnidimensional;
	}
	
	private static int[][] obtenerMatrizTraspuesta(int matriz[][]) {
		int matrizTraspuesta[][] = new int [matriz[0].length][matriz.length];
		System.out.println("\n\nMatriz traspuesta: ");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matrizTraspuesta[j][i] = matriz[i][j];
				System.out.println(matrizTraspuesta[j][i]);
			}
		}

		
		return matrizTraspuesta;
	}
	
	private static int[][] obtenerMatrizOpuesta(int matriz[][]) {
		int matrizNegativa[][] = new int[matriz.length][matriz[0].length];
		System.out.println("\n\nMatriz Opuesta:");
		for (int i = 0; i < matriz.length; i++) {
			System.out.println();
			for (int j = 0; j < matriz[i].length; j++) {
				matrizNegativa[i][j] = -matriz[i][j];
				System.out.print(matrizNegativa[i][j] + " ");
			}
		}
		return matrizNegativa;
	}
	
	private static int[][] eliminarFilaImpuestaPorUsuario(int matriz[][], int numFila) {
		int nuevaMatriz[][] = new int[matriz.length - 1][matriz[0].length];
		numFila = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la fila que quiere eliminar:"));
		for (int i = 0; i < matriz.length; i++) {
			System.out.println();
			for (int j = 0; j < matriz[i].length; j++) {
				if (i == numFila) {
					System.out.println(" ");
				}
			}
		}
		return nuevaMatriz;	
	}
}
