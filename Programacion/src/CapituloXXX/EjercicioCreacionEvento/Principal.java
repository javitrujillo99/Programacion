package CapituloXXX.EjercicioCreacionEvento;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {
	
	static List<PalabraIntroducidaListener> palabraIntroducidaListeners = 
			new ArrayList<PalabraIntroducidaListener>();
	
	/**
	 * 
	 * @param listener
	 */
	public static void addPalabraIntroducidaListener(PalabraIntroducidaListener listener) {
		palabraIntroducidaListeners.add(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void removePalabraIntroducidaListener(PalabraIntroducidaListener listener) {
		palabraIntroducidaListeners.remove(listener);
	}
	
	/**
	 * 
	 * @param e
	 */
	public static void firePalabraIntroducidaListener(PalabraIntroducidaEvent e)  {
		for (PalabraIntroducidaListener listener: palabraIntroducidaListeners) {
			listener.palabraIntroducida(e);
		}
	}

	public static void main(String[] args) {
		Carlos carlos = new Carlos();
		while (true) {
			String palabra = JOptionPane.showInputDialog("Introduzca una palabra: ");
			if (palabra.equals("avioneta")) {
				PalabraIntroducidaEvent event = new PalabraIntroducidaEvent(palabra);
				firePalabraIntroducidaListener(event);
			}
		}

	}

}
