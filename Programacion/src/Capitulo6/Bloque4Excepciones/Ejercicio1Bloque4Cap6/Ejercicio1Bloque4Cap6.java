package Capitulo6.Bloque4Excepciones.Ejercicio1Bloque4Cap6;

import java.util.Scanner;


public class Ejercicio1Bloque4Cap6 {
	
	public static int pideNumeroPar() throws NumeroImparException {
		System.out.println("Introduzca número: ");
		Scanner sc = new Scanner(System.in);
		int numero = sc.nextInt();
		if(numero % 2 == 1) { 	//Es impar
			throw new NumeroImparException();
		}
		
		return numero;
	}

	public static void main(String[] args) {
		int numero;
		try {
			numero = pideNumeroPar();
			System.out.println("Número par del usuario: " + numero);
		} catch(NumeroImparException e) {
			System.out.println("Número impar introducido");
		}
		
	}

}
