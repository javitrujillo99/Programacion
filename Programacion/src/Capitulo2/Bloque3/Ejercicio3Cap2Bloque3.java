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
		if (opcion != 0) {
				switch (opcion) {
				case 1: //Cálculo de la hipotenusa de un triángulo.
					float cateto1 = Integer.parseInt(JOptionPane.showInputDialog("Cateto 1: "));
					float cateto2 = Integer.parseInt(JOptionPane.showInputDialog("Cateto 2: "));
					float hipotenusa =  (float) Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
					JOptionPane.showMessageDialog(null, "Resultado = " + hipotenusa);
					break;
				case 2: //Cálculo de la superficie de una circunferencia.
					float radio = Integer.parseInt(JOptionPane.showInputDialog("Radio de la circunferencia: "));
					float area = (float) (Math.PI * Math.pow(radio, 2));
					JOptionPane.showMessageDialog(null, "Resultado = " + area);
					break;
				case 3: //Cálculo del perímetro de una circunferencia.
					float radio1 = Integer.parseInt(JOptionPane.showInputDialog("Radio de la circunferencia: "));
					float perimetro = (float) (2 * Math.PI * radio1);
					JOptionPane.showMessageDialog(null, "Resultado = " + perimetro);
					break;
				case 4: //Cálculo del área de un rectángulo.
					float base = Integer.parseInt(JOptionPane.showInputDialog("Base del rectángulo: "));
					float altura = Integer.parseInt(JOptionPane.showInputDialog("Altura del rectángulo: "));
					float area1 = base * altura;
					JOptionPane.showMessageDialog(null, "Resultado = " + area1);
					break;
				case 5: //Cálculo del área de un triángulo.
					float base1 = Integer.parseInt(JOptionPane.showInputDialog("Base del triángulo: "));
					float altura1 = Integer.parseInt(JOptionPane.showInputDialog("Altura del triángulo: "));
					float area2 = base1 * altura1 / 2;
					JOptionPane.showMessageDialog(null, "Resultado = " + area2);
					break;
				case 0: //Salir de la aplicación.
					JOptionPane.showMessageDialog(null, "Gracias por usar la calculadora.");
					System.exit(0);
					default:JOptionPane.showMessageDialog(null,"Opción incorrecta") ;
				}
		}
	}
	}
