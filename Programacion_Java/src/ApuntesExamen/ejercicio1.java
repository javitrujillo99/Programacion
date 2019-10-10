package ApuntesExamen;

import javax.swing.JOptionPane;

public class ejercicio1 {

	public static void main(String[] args) {
		int array [] = new int [150], i = 0;
		int limInf = Integer.parseInt(JOptionPane.showInputDialog("Escriba límite inferior: "));
		int limSup = Integer.parseInt(JOptionPane.showInputDialog("Escriba límite superior: "));
		
		for (i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * (limSup - limInf) + limInf);
			System.out.println("Array [" + i + "] = " + array[i]);
		}

	}

}
