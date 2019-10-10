package Capitulo5.Bloque1;

import javax.swing.JOptionPane;

public class Ejercicio3Cap5Bloque1 {

	public static void main(String[] args) {
		int array [] = new int [150], i = 0, valor = 0, contadorNulos= 0;
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Número [" + (i + 1) + "]" + " = " + array[i]);
		}
		valor = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un valor entre 0 y 100"));
		for (i = 0; i < array.length; i++) {
			if (valor == array[i]) {
				JOptionPane.showMessageDialog(null, "Valor encontrado en la posición número " + (i + 1) + " del Array");
			}
			else {
				contadorNulos++;
			}
		}
		if (contadorNulos == array.length) {
			JOptionPane.showMessageDialog(null, "Valor no encontrado en la lista");
		}
	}
}
