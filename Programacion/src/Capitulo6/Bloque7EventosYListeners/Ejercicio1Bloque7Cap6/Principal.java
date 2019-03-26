package Capitulo6.Bloque7EventosYListeners.Ejercicio1Bloque7Cap6;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	static List<PalabraContieneTresDigitosListener> palabrasConTresDigitosListeners =
			new ArrayList<PalabraContieneTresDigitosListener>();
	
	/**
	 * 
	 * @param listener
	 */
	public static void addPalabraContieneTresDigitosListener (PalabraContieneTresDigitosListener listener) {
		palabrasConTresDigitosListeners.add(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void removePalabraContieneTresDigitosListener (PalabraContieneTresDigitosListener listener) {
		palabrasConTresDigitosListeners.remove(listener);
	}
	
	/**
	 * 
	 * @param event
	 */
	public static void firePalabraContieneTresDigitosListener (PalabraContieneTresDigitosEvent event) {
		for (PalabraContieneTresDigitosListener listener : palabrasConTresDigitosListeners) {
			listener.tresDigitosEncontrados(event);
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String palabra;
		char caracter;
		BuscaDigitos buscaDigitos = new BuscaDigitos();
		do {
			int contador = 0;
			palabra = JOptionPane.showInputDialog("Introduzca palabra: ");
			for (int i = 0; i < palabra.length(); i++) {
				caracter = palabra.charAt(i);
				if (Character.isDigit(caracter)) {
					contador++;
				}
			}
			if (contador == 3) {
				PalabraContieneTresDigitosEvent event = new PalabraContieneTresDigitosEvent(palabra);
				firePalabraContieneTresDigitosListener(event);
			}
		} while(!palabra.equals("salir"));

	}

}
