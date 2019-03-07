package Capitulo6.Bloque1.Ejercicio1Bloque1Cap6;

import javax.swing.JOptionPane;

public class Ejercicio1Bloque1Cap6 {

	public static void main(String[] args) {
		String mensaje;		
		int num1, num2, opcion;
		String menu = "MENU\n"
				+ "1.- Añadir artículo nuevo\n"
				+ "2.- Borrar artículo\n"
				+ "3.- Actualizar estante de un artículo\n"
				+ "4.- Imprimir artículos\n"
				+ "0.- Salir\n";
		
		opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
				
		// Resolución de la operación según el tipo de operación pedido por el usuario
		switch (opcion) {
		case 1: 
			break;
		case 2: 
			break;
		case 3: 
			break;
		case 4: 
			break;
		case 0: // Salir
			System.exit(0);
		
		}
	}
}
