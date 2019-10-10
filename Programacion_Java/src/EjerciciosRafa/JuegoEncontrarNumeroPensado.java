package EjerciciosRafa;

import javax.swing.JOptionPane;

public class JuegoEncontrarNumeroPensado {

	public static void main(String[] args) {
		int numeroPensado =  (int) Math.round(Math.random() * 100), intento;
		//System.out.println("Número pensado: " + numeroPensado);
		
		do {
			 intento = Integer.parseInt(JOptionPane.showInputDialog("Busca número pensado de 0 a 100"));
			 if (intento > numeroPensado) {
				 JOptionPane.showMessageDialog(null, "Mi número pensado es inferior a " + intento);
			 }
			 else {
				 if (intento < numeroPensado) {
					 JOptionPane.showMessageDialog(null,"Mi número pensado es superior a " + intento);
				 }
				 else {
					 JOptionPane.showMessageDialog(null,"ENHORABUENA!!! Lo has conseguido!! El " + intento + " es mi número pensado.");
				 }
			 }
			
		}
		while (intento != numeroPensado);
	}

}
