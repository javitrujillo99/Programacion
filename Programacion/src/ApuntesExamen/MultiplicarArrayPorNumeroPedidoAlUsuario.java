package ApuntesExamen;

import javax.swing.JOptionPane;

public class MultiplicarArrayPorNumeroPedidoAlUsuario {

	public static void main(String[] args) {
		int array [] = new int [10], i = 0;
		int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un valor"));
		System.out.println("Array original:");
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.println("Array[" + i + "] = " + array[i]);
		}
		System.out.println("\nArray multiplicado por " + num + ":");
		for (i = 0; i < array.length; i++) {
			array[i] = num * array[i];
			System.out.println("Array[" + i + "] = " + array[i]);
		}
	}
}
