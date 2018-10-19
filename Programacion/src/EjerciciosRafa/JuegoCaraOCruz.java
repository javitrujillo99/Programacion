package EjerciciosRafa;

import javax.swing.JOptionPane;

public class JuegoCaraOCruz {

	public static void main(String[] args) {
		int num, contadorPersona = 0,contadorOrdenador = 0;
		do {
			int aleatorio = (int) Math.round(Math.random());
			num = Integer.parseInt(JOptionPane.showInputDialog("ELIJA: (AL MEJOR DE 5) \n CARA = 0 \n CRUZ = 1"));
			if (num < 0 || num > 1) {
				JOptionPane.showMessageDialog(null, "ERROR, TIENE QUE SER 0 O 1 TOLAI");
				System.exit(0);
			}
			else
				if (aleatorio == num) {
					contadorPersona++;
					JOptionPane.showMessageDialog(null, "Salió " + aleatorio + ", 1 punto para ti.\nMarcador: " + contadorPersona + " - " + contadorOrdenador);
				}
				else {
					contadorOrdenador++;
					JOptionPane.showMessageDialog(null, "Salió " + aleatorio + ", 1 punto para el ordenador.\nMarcador: " + contadorPersona + " - " + contadorOrdenador);
				}
			}
			while (contadorPersona != 3 && contadorOrdenador != 3);
			if (contadorPersona == 3) {
				JOptionPane.showMessageDialog(null, "ENHORABUEA!!!! HAS GANADO!");
			}
			else {
				if (contadorOrdenador == 3) {
				JOptionPane.showMessageDialog(null, "MALA SUERTE... LA PRÓXIMA VEZ SERÁ PARGUELITA");
				}
			}
	}

}
