package Capitulo4.Bloque2.Ejercicio1;

import javax.swing.JOptionPane;

public class Tienda {

	public static void main(String[] args) {
		
		for (int i = 0; i < 4; i++) {
			ArticuloPerecedero art = new ArticuloPerecedero();
			art.setNombre(JOptionPane.showInputDialog("Introduzca nombre:"));
			art.setCodigo(JOptionPane.showInputDialog("Introduzca código:"));
			art.setPrecio(Float.parseFloat(JOptionPane.showInputDialog("Introduzca precio:")));
			art.setFechaCaducidad(JOptionPane.showInputDialog("Introduzca fecha de caducidad:"));
			System.out.println(art);
		}
	}

}
