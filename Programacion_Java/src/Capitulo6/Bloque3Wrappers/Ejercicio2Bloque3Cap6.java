package Capitulo6.Bloque3Wrappers;

import javax.swing.JOptionPane;

public class Ejercicio2Bloque3Cap6 {
	private static char caracter;
	
	public static boolean contieneMayuscula(String contrasenia) {
		for (int i = 0; i < contrasenia.length(); i++) {
			caracter = contrasenia.charAt(i);
			if (Character.isUpperCase(caracter)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
 	}
	
	public static boolean contieneMinuscula(String contrasenia) {
		
		for (int i = 0; i < contrasenia.length(); i++) {
			caracter = contrasenia.charAt(i);
			if (Character.isLowerCase(caracter)) {
				return true;
			}
		}
		return false;
 	}
	
	public static boolean contieneAlMenosUnDigito(String contrasenia) {
		for (int i = 0;  i < contrasenia.length(); i++) {
			caracter = contrasenia.charAt(i);
			if (Character.isDigit(caracter)) {
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean contieneUnCaracterNoAlfanumerico(String contrasenia) {
		for (int i = 0;  i < contrasenia.length(); i++) {
			caracter = contrasenia.charAt(i);
			if (!Character.isLetterOrDigit(caracter)) {
				return true;
			}
		}
		return false;
	}
	

	public static void main(String[] args) {
		boolean mayuscula;
		boolean minuscula;
		boolean digito;
		boolean alfanumerico;
		do {
		String contrasenia = JOptionPane.showInputDialog("Introduzca contraseña. La contraseña debe contener:\n- Una mayúscula"
					+ "\n- Una minúscula\n- Un dígito\n- Un carácter no alfanumérico");
			mayuscula = contieneMayuscula(contrasenia);
			minuscula = contieneMinuscula(contrasenia);
			digito = contieneAlMenosUnDigito(contrasenia);
			alfanumerico = contieneUnCaracterNoAlfanumerico(contrasenia);
			if (!mayuscula) {
				JOptionPane.showMessageDialog(null, "Debe introducir al menos una mayuscula");
			}
			if (!minuscula) {
				JOptionPane.showMessageDialog(null, "Debe introducir al menos minuscula");
			}
			if (!digito) {
				JOptionPane.showMessageDialog(null, "Debe introducir al menos un digito");
			}
			if (!alfanumerico) {
				JOptionPane.showMessageDialog(null, "Debe introducir al menos un caracter no alfanumerico");
			}
		} while (!mayuscula || !minuscula || !digito || !alfanumerico);
		JOptionPane.showMessageDialog(null, "Contraseña introducida correctamente");
	}

}
