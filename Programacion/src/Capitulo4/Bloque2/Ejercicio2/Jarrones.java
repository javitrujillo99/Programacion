package Capitulo4.Bloque2.Ejercicio2;

public class Jarrones extends Antiguedad {
	
	private String forma;

	/**
	 * 
	 */
	public Jarrones() {
		super();
	}

	
	/**
	 * 
	 * @param añoFabricacion
	 * @param origen
	 * @param precio
	 * @param forma
	 */
	public Jarrones(int añoFabricacion, String origen, float precio, String forma) {
		super(añoFabricacion, origen, precio);
		this.forma = forma;
	}


	public String getForma() {
		return forma;
	}


	public void setForma(String forma) {
		this.forma = forma;
	}


	@Override
	public String toString() {
		return "Jarrones [forma=" + forma + ", getAñoFabricacion()=" + getAñoFabricacion() + ", getOrigen()="
				+ getOrigen() + ", getPrecio()=" + getPrecio() + "]";
	}
	
	

}
