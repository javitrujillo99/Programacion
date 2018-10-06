package Capitulo3.Bloque2;

import javax.swing.JOptionPane;

public class Ejercicio2Cap3Bloque2 {

	public static void main(String[] args) {
		int mayor = 0, menor = 0;
		int n = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de variables que quiere que le pidan: "));
		if (n <= 0) {
			JOptionPane.showMessageDialog(null,"ERROR, el número debe ser mayor que 0.");
			System.exit(0);
		}
		for (int i = 1; i <= n; i++) {
			int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número " + i));
				if (numero > mayor) {
					mayor = numero;
				}
				if (numero < menor) {
					menor = numero;
				}
			}
		JOptionPane.showMessageDialog(null, "El mayor es: " + mayor + "\nEl menor es: " + menor);
		}
	}

