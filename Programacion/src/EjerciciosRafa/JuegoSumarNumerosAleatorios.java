package EjerciciosRafa;

import javax.swing.JOptionPane;

public class JuegoSumarNumerosAleatorios {

	public static void main(String[] args) {
		int numeros = 0, sumatorio = 0, i = 0;
		for (i = 1; i < 10001; i++) {
			numeros = (int) Math.round(Math.random()*1000);
			System.out.println(numeros);
			sumatorio += numeros;
		}
		JOptionPane.showMessageDialog(null,"La suma de los " + (i - 1) + " números es: " + sumatorio);
	}
}