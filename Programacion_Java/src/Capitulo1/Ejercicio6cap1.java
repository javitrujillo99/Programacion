package Capitulo1;

import javax.swing.JOptionPane;

public class Ejercicio6cap1 {

	public static void main(String[] args) {
		
		//Hipoteca que pide las variables al usuario.
		
		String str = JOptionPane.showInputDialog("Introduzca el euribor: ");
		float euribor = Float.parseFloat(str);
		System.out.println("El euribor es: " + euribor);
		
		str = JOptionPane.showInputDialog("Introduzca el diferencial: ");
		float diferencial = Float.parseFloat(str);
		System.out.println("El diferencial es: " + diferencial);
		
		str = JOptionPane.showInputDialog("Introduzca el capital: ");
		float capital = Float.parseFloat(str);
		System.out.println("El capital es: " + capital);
		
		str = JOptionPane.showInputDialog("Introduzca el plazo en meses para pagarlo: ");
		int meses = Integer.parseInt(str);
		System.out.println("El plazo son: " + meses);
		
		float iA = euribor + diferencial;
		float iM = iA / 12 / 100;
		float cuotaMensual = (float) (capital * ((iM * Math.pow ((1 + iM) , meses)) / (Math.pow ((1+iM) , meses) - 1)));
		float total = cuotaMensual * meses; 
		
		System.out.println("Préstamo: " + capital + "€");
		System.out.println("Periodo: " + meses + " meses");
		System.out.println("Euribor: " + euribor);
		System.out.println("Interés: " + diferencial);
		System.out.println("El interés anual es: " + iA);
		System.out.println("El interés mensual es: " + iM);
		System.out.println("La cuota mensual es: " + cuotaMensual + "€");
		System.out.println("Total a pagar: " + total + "€");
		    
		/*float euribor = (float) -0.167;
		float diferencial = (float) 0.89;
		int capital = 500000;
		int meses = 120;
		*/
	}

}
