package Capitulo5.Bloque5;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class EditorDeTextos {
	
	private static int opcion;
	private static List<String> linea = new ArrayList<String>();
	
	public static void main(String[] args) {
		do {
		//imprimirMenu();
		//desarrollarLista(opcion);
			opcion = Integer.parseInt(JOptionPane.showInputDialog(" 1) Añadir una línea al texto. \n" + 
					" 2) Insertar una línea en cualquier posición del texto.\n" + 
					" 3) Editar una línea (reescribir su contenido).\n" + 
					" 4) Borrar una línea.\n" + 
					" 5) Cortar un conjunto de líneas, (marcadas por su posición inicial y final).\n" + 
					" 6) Pegar un conjunto de líneas cortadas en una determinada posición.\n" + 
					" 7) Imprimir el texto. Cada línea aparecerá numerada. \n" +
					" 0) Salir."));
			switch (opcion) {
			case 1:
				agregarLinea();
				break;
			case 2:
				insertarLinea();
				break;
			case 3:
				//editarLinea();
				break;
			case 4:
				borrarLinea();
				break;
			case 5:
				//cortarLineas();
				break;
			case 6:
				//pegarLineas();
				break;
			case 7:
				imprimeList(linea);
				break;
			}
		}while (opcion != 0);
	}
	
	/**
	 * 
	 */
	
	/*private static void imprimirMenu() {
		opcion = Integer.parseInt(JOptionPane.showInputDialog(null, " 1) Añadir una línea al texto. \n" + 
				" 2) Insertar una línea en cualquier posición del texto.\n" + 
				" 3) Editar una línea (reescribir su contenido).\n" + 
				" 4) Borrar una línea.\n" + 
				" 5) Cortar un conjunto de líneas, (marcadas por su posición inicial y final).\n" + 
				" 6) Pegar un conjunto de líneas cortadas en una determinada posición.\n" + 
				" 7) Imprimir el texto. Cada línea aparecerá numerada. \n" +
				" 0) Salir."));
		}
	
	/**
	 * 
	 */
	/*
	private static void desarrollarLista (int opcion) {
		switch (opcion) {
		case 1: 
			agregarLinea();
			break;
		case 2:
			insertarLinea();
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		}
	}
	*/
	
	/*
	 * 
	 */
	private static void agregarLinea() {
		String lineaUsuario = JOptionPane.showInputDialog("Introduzca línea a añadir: ");
		linea.add(lineaUsuario);
	}
	
	private static void borrarLinea() {
		int posicionLinea = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca línea a borrar:"));
		linea.remove(posicionLinea);
	}
	
	/**
	 * 
	 */
	private static void insertarLinea() {
		int posicion = Integer.parseInt(JOptionPane.showInputDialog("Introduzca en que posición quiere añadir la línea:"));
		String lineaUsuario = JOptionPane.showInputDialog("Introduzca línea:");
		linea.add(posicion, lineaUsuario);
	}
	
	
	/**
	 * 
	 */
	private static void editarLinea() {
		String lineaUsuario = JOptionPane.showInputDialog("Introduzca línea a añadir: ");
	}
	/**
	 * 
	 * @param lista
	 */
	private static void imprimeList (List<String> linea) {
		for (int i = 0; i < linea.size(); i++) {
			System.out.println(linea.get(i).toString());
		}
	}
	

}
