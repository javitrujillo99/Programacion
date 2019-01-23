package Capitulo5.Bloque5.CajaSupermercado;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Cliente> lista = new ArrayList<Cliente>();
	private static List<Cliente> lista2 = new ArrayList<Cliente>();

	
	public static void main(String[] args) {
		int i = 0;
		do {
		agregarCliente();
		i++;
		}while (i != 4);
		//despacharCliente();
		System.out.println("Lista original:");
		imprimeList(lista);
		dividirCola();
		System.out.println("\nCola dividida: ");
		imprimeList(lista2);
		System.out.println("\nSegunda cola: ");
		imprimeList(lista);
	}
	
	/**
	 * 
	 */
	private static void agregarCliente() {
		Cliente cliente = new Cliente();
		lista.add(0, cliente);	
	}
	
	/**
	 * 
	 * @param linea
	 */
	private static void imprimeList (List<Cliente> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).toString());
		}
	}
	
	private static void despacharCliente() {
		Cliente clienteBorrado = lista.remove(lista.size() - 1);
	}
	
	private static void dividirCola() {
		lista2.addAll(lista.subList(0, lista.size() / 2));
		lista.removeAll(lista.subList(0, lista.size() / 2));
	}
	
}