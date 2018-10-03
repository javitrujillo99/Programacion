package Capitulo2.Bloque3;

import javax.swing.JOptionPane;

public class Ejercicio3Cap2Bloque3 {

	public static void main(String[] args) {
		String menu = "                        MENÚ\n"  //NO FUNCIONA EL \t Y LO HE HECHO CON ESPACIOS.
				+ "1.-Cálculo de la hipotenusa de un triángulo.\n"
				+ "2.-Cálculo de la superficie de una circunferencia.\n"
				+ "3.-Cálculo del perímetro de una circunferencia.\n"
				+ "4.-Cálculo del área de un rectángulo.\n"
				+ "5.-Cálculo del área de un triángulo.\n"
				+ "0.-Salir de la aplicación.";

		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		

	}

}
