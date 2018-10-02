package Capitulo2.Bloque2;

import javax.swing.JOptionPane;

public class Ejercicio2bloque2Cap2 {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Número 1: ");
		int var1 = Integer.parseInt(str);
		System.out.println("Número 1: " + var1 );
		
		str = JOptionPane.showInputDialog("Número 2: ");
		int var2 = Integer.parseInt(str);
		System.out.println("Número 2: " + var2 );
		
		str = JOptionPane.showInputDialog("Número 3: ");
		int var3 = Integer.parseInt(str);
		System.out.println("Número 3: " + var3 );
		
		str = JOptionPane.showInputDialog("Número 4: ");
		int var4 = Integer.parseInt(str);
		System.out.println("Número 4: " + var4 );
		
		str = JOptionPane.showInputDialog("Número 5: ");
		int var5 = Integer.parseInt(str);
		System.out.println("Número 5: " + var5 );
		int suma2 = 0;
		int suma3 = 0;
		int suma4 = 0;
		
			if (var1 < 0 || var2 < 0 || var3 < 0 || var4 < 0 || var5 < 0 ) {
				JOptionPane.showMessageDialog(null,"ERROR. Los números deben de ser 0 o mayores que 0");
			}
			else {	
				 {
					 	if (var1 <= 25) {
							 suma2 = suma2 + 1;	//	Lo mismo más corto sería suma2 ++ var1;
						}
						else {
						if (var1 <= 250) {
							 suma3 = suma3 + 1;
						}
						else {
							 suma4 = suma4 + 1;
					}
					}
				}
		 {
			 			if (var2 <= 25) {
			 			suma2 = suma2 + 1;		
			}
			else {
						if (var2 <= 250) {
						suma3 = suma3 + 1;
			}
			else {
						suma4 = suma4 + 1;
		}
		}
	}
		
		  {
			  			if (var3 <= 25) {
			  			suma2 = suma2 + 1;		
			}
			else {
						if (var3 <= 250) {
						suma3 = suma3 + 1;
			}
			else {
						suma4 = suma4 + 1;
		}
		}
	}
		  {
			  			if (var4 <= 25) {
			  			suma2 = suma2 + 1;		
			}
			else {
						if (var4 <= 250) {
						suma3 = suma3 + 1;
			}
			else {
						suma4 = suma4 + 1;

		}
		}
	}
		
		  {
			if (var5 <= 25) {
				 suma2 = suma2 + 1;		
			}
				else {
					if (var5 <= 250) {
				 suma3 = suma3 + 1;
			}
					else {
				 suma4 = suma4 + 1;
		}
		}
	}
		
		System.out.println("\nSe han introducido " + suma2 + " números entre 0 y 25");
		System.out.println("Se han introducido " + suma3 + " números entre 25 y 250" );
		System.out.println("Se han introducido " + suma4 + " números mayores que 250");
		}
		
	}
	}

