package Capitulo4.Bloque2.Ejercicio2;

import javax.swing.JOptionPane;

public class ColeccionAntiguedades {

	public static void main(String[] args) {
		int opcion;
		Antiguedad antiguedad = null;
		do {
			String menu = "MENU\n"
					+ "1.- Joyas\n"
					+ "2.- Libros\n"
					+ "3.- Jarrones\n"
					+ "4.- Cuadros\n"
					+ "0.- Terminar";
					
			
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if (opcion > 0 && opcion < 5) {
			
				switch (opcion) {
				case 1:
					antiguedad = new Joyas();
					((Joyas) antiguedad).setMaterialFabricacion(JOptionPane.showInputDialog("Introduzca material de fabricación:"));
					break;
				case 2: 
					antiguedad = new Libros();
					((Libros) antiguedad).setAutor(JOptionPane.showInputDialog("Introduzca autor del libro:"));
					((Libros) antiguedad).setTitulo(JOptionPane.showInputDialog("Introduzca título del libro"));
					break;
				case 3:
					antiguedad = new Jarrones();
					((Jarrones) antiguedad).setForma(JOptionPane.showInputDialog("Introduzca forma"));
					break;
				case 4: 
					antiguedad = new Cuadros();
					((Libros) antiguedad).setAutor(JOptionPane.showInputDialog("Introduzca autor del cuadro:"));
					break;
				}
				
				antiguedad.setOrigen(JOptionPane.showInputDialog("Introduzca origen:"));
				antiguedad.setAñoFabricacion(Integer.parseInt(JOptionPane.showInputDialog("Introduzca año de fabricación:")));
				antiguedad.setPrecio(Float.parseFloat(JOptionPane.showInputDialog("Introduzca precio:")));
				System.out.println(antiguedad);
			}
		}
			while (opcion != 0);
	}
}
