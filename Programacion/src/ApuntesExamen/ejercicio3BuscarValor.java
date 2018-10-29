package ApuntesExamen;

import javax.swing.JOptionPane;

public class ejercicio3BuscarValor {

	public static void main(String[] args) {
		int array[] = new int [20], contador = 0;
		int i = 0;
	
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Array [" + i + "] = " + array[i]);
		}
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Introduce valor para buscar en el array"));
		for (i = 0; i < array.length; i++) {
			if (valor == array[i]) {
				JOptionPane.showMessageDialog(null, "El número " + valor + " está en el Array[" + i + "]");
			}
			else {
				contador++;
			}
		}
		if (contador == array.length) {
			JOptionPane.showMessageDialog(null, "El número no se encuentra en ningún array");
		}
	}
}
