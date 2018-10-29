package ApuntesExamen;

import javax.swing.JOptionPane;

public class MENUS {

	public static void main(String[] args) {
		// Declaración de todas la variables necesarias
		String mensaje;		
		int num1, num2, opcion;
		String menu = "MENU\n"
				+ "1.- Hipotenusa de triángulo rectángulo\n"
				+ "2.- Cálculo de la superficie de un círculo\n"
				+ "3.- Cálculo del perímetro de una circunferencia\n"
				+ "4.- Cálculo del área de un rectángulo\n"
				+ "5.- Cálculo del área de un triángulo\n"
				+ "0.- Salir\n";
		
		opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
				
		// Resolución de la operación según el tipo de operación pedido por el usuario
		switch (opcion) {
		case 1: // Hipotenusa de triángulo rectángulo
			// Petición de los dos valores, en todos los casos se piden DOS valores
			float cateto1 = Float.parseFloat(JOptionPane.showInputDialog("Intoduzca primer cateto"));
			float cateto2 = Float.parseFloat(JOptionPane.showInputDialog("Introduzca segundo cateto"));
			mensaje = "Resultado: " + (Math.sqrt(cateto1*cateto1 + Math.pow(cateto2, 2)));
			break;
		case 2: // Cálculo de la superficie de un círculo
			float radio = Float.parseFloat(JOptionPane.showInputDialog("Intoduzca radio"));
			mensaje = "Resultado: " + (Math.PI * Math.pow(radio, 2));
			break;
		case 3: // Cálculo del perímetro de una circunferencia
			radio = Float.parseFloat(JOptionPane.showInputDialog("Intoduzca radio"));
			mensaje = "Resultado: " + (2 * Math.PI * radio);
			break;
		case 4: // Cálculo del área de un rectángulo
			float base = Float.parseFloat(JOptionPane.showInputDialog("Intoduzca base"));
			float altura = Float.parseFloat(JOptionPane.showInputDialog("Introduzca altura"));
			mensaje = "Resultado: " + (base * altura);
			break;
		case 5: // Cálculo del área de un triángulo
			base = Float.parseFloat(JOptionPane.showInputDialog("Intoduzca base"));
			altura = Float.parseFloat(JOptionPane.showInputDialog("Introduzca altura"));
			mensaje = "Resultado: " + (base * altura / 2);
			break;
		case 6: // Potencia de dos números
			mensaje = "Resultado: ";
			break;
		case 7: // raíz n-ésima de un número
			mensaje = "Resultado: ";
			break;
		case 0: // Salir
			mensaje = "Gracias por usar la calculadora";
			System.exit(0);
		default:
			mensaje = "Opción incorrecta, elija bien";
		}  
		
		// Saca la información al usuario
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
