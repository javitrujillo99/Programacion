package Capitulo3.Bloque3.EjerciciosConFor;

import javax.swing.JOptionPane;

public class Ejercicio7Cap3Bloque3 {

	public static void main(String[] args) {
		String mensaje = "Introduzca número (0 -> Terminar)";
		int numero = 1, contadorNumerosPositivos = 0, contadorNumerosNegativos = 0;
		for (; numero != 0;) {
			numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			
				if (numero > 0) {
					contadorNumerosPositivos++; 
				}
				if (numero < 0) {
					contadorNumerosNegativos++; 
				}
			}
		JOptionPane.showMessageDialog(null, "Números positivos: " + contadorNumerosPositivos + "\n"
				+ "Números negativos: " + contadorNumerosNegativos);
	}

}
