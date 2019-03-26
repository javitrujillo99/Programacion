package Capitulo6.Bloque6FicheroDePropiedades;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Ejercicio1Bloque6Cap6 {
	private static Properties propiedades = null;
	
	private static Properties getPropiedades() {
		if (propiedades == null) {
			propiedades = new Properties();
		    
			try {
				propiedades.load(propiedades.getClass().getResourceAsStream("/Capitulo6/Bloque6FicheroDePropiedades/Fichero.properties"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}
		return propiedades;
	}
	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static String getProperty(String nombrePropiedad) {
		return getPropiedades().getProperty(nombrePropiedad);
	}
	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static int getIntProperty (String nombrePropiedad) {
		return Integer.parseInt(getPropiedades().getProperty(nombrePropiedad));
	}
	
	

	public static void main(String[] args) {
		String usuario = Ejercicio1Bloque6Cap6.getProperty("USUARIO");
		String password = Ejercicio1Bloque6Cap6.getProperty("PASSWORD");
		
		System.out.println("Usuario leido del fichero de propiedades: " + usuario);
		System.out.println("Contraseña leida del fichero de propiedades: " + password);
	}

}
