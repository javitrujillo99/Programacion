package Capitulo2.Bloque3;

import javax.swing.JOptionPane;

public class Ejercicio3Cap2Bloque3 {

	public static void main(String[] args) {
		String menu = "                        MENÚ\n"  //NO FUNCIONA EL \t Y LO HE HECHO CON ESPACIOS.
				+ "1.-Cálculo de la hipotenusa de un triángulo rectángulo.\n"
				+ "2.-Cálculo de la superficie de una circunferencia.\n"
				+ "3.-Cálculo del perímetro de una circunferencia.\n"
				+ "4.-Cálculo del área de un rectángulo.\n"
				+ "5.-Cálculo del área de un triángulo.\n"
				+ "0.-Salir de la aplicación.";
		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		String mensaje = "";
				switch (opcion) {
				case 1: //Cálculo de la hipotenusa de un triángulo rectángulo.
					float cateto1 = Float.parseFloat(JOptionPane.showInputDialog("Cateto 1: "));
					float cateto2 = Float.parseFloat(JOptionPane.showInputDialog("Cateto 2: "));
					float hipotenusa =  (float) Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
					mensaje =  "Resultado = " + hipotenusa;
					break;
				case 2: //Cálculo de la superficie de una circunferencia.
					float radio = Float.parseFloat(JOptionPane.showInputDialog("Radio de la circunferencia: "));
					float area = (float) (Math.PI * Math.pow(radio, 2));
					mensaje = "Resultado = " + area;
					break;
				case 3: //Cálculo del perímetro de una circunferencia.
					float radio1 = Float.parseFloat(JOptionPane.showInputDialog("Radio de la circunferencia: "));
					float perimetro = (float) (2 * Math.PI * radio1);
					mensaje = "Resultado = " + perimetro;
					break;
				case 4: //Cálculo del área de un rectángulo.
					float base = Float.parseFloat(JOptionPane.showInputDialog("Base del rectángulo: "));
					float altura = Float.parseFloat(JOptionPane.showInputDialog("Altura del rectángulo: "));
					float area1 = base * altura;
					mensaje = "Resultado = " + area1;
					break;
				case 5: //Cálculo del área de un triángulo.
					float base1 = Float.parseFloat(JOptionPane.showInputDialog("Base del triángulo: "));
					float altura1 = Float.parseFloat(JOptionPane.showInputDialog("Altura del triángulo: "));
					float area2 = base1 * altura1 / 2;
					mensaje = "Resultado = " + area2;
					break;
				case 0: //Salir de la aplicación.
					JOptionPane.showMessageDialog(null, "Gracias por usar la calculadora.");
					System.exit(0);
					default:mensaje = "Opción incorrecta";
			}
				JOptionPane.showMessageDialog(null, mensaje);
		}
	}
