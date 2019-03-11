package Capitulo6.Bloque2Math;

import javax.swing.JOptionPane;

public class Ejercicio1Bloque2Cap6 {
	
	public static void resolverEcuacionesSegundoGrado() {
		float a = Float.parseFloat(JOptionPane.showInputDialog("Introduzca parámetro a"));
		float b = Float.parseFloat(JOptionPane.showInputDialog("Introduzca parámetro b"));
		float c = Float.parseFloat(JOptionPane.showInputDialog("Introduzca parámetro c"));
		float solucion1 = (float) ((-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a));
		float solucion2 = (float) ((-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a));
		System.out.println("Soluciones: " + solucion1 + ", " + solucion2);
	}
	

	public static void main(String[] args) {
		resolverEcuacionesSegundoGrado();
	}

}
