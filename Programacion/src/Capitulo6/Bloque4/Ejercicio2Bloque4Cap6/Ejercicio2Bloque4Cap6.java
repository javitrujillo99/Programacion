package Capitulo6.Bloque4.Ejercicio2Bloque4Cap6;

import javax.swing.JOptionPane;

public class Ejercicio2Bloque4Cap6 {
	
	public static String pedirFrase() throws NoBombillaException, PalabraOfensivaException {
		String frase = JOptionPane.showInputDialog("Introduzca frase: ");
		if (!frase.contains("bombilla")) {
			throw new NoBombillaException();
		}
		if (frase.contains("tonto") || frase.contains("tonta") || frase.contains("idiota")) {
			throw new PalabraOfensivaException();
		}
		
	}

	public static void main(String[] args) {
		String frase;
		try {
			frase = pedirFrase();
			System.out.println("Palabra 'bombilla' encontrada");
		} catch (NoBombillaException e) {
			System.out.println("No ha introducido la palabra 'bombilla'");
		} catch (PalabraOfensivaException e) {
			System.out.println("Ha introducido una palabra ofensiva");
		} catch (CaracterDistintoEspacioException e) {
			System.out.println("La frase introducida no tiene caracteres distintos al espacio en blanco");
		} catch (FraseInferiorTresPalabrasException e) {
			System.out.println("La frase contiene menos de tres palabras");
		}

	}

}
