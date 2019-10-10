package Capitulo4.Bloque2.Ejercicio2;

public class Antiguedad {
	private int añoFabricacion;
	private String origen;
	private float precio;
	
	
	/**
	 * 
	 */
	public Antiguedad() {
		super();
	}
	
	
	/**
	 * 
	 * @param añoFabricacion
	 * @param origen
	 * @param precio
	 */
	public Antiguedad(int añoFabricacion, String origen, float precio) {
		super();
		this.añoFabricacion = añoFabricacion;
		this.origen = origen;
		this.precio = precio;
	}


	public int getAñoFabricacion() {
		return añoFabricacion;
	}


	public void setAñoFabricacion(int añoFabricacion) {
		this.añoFabricacion = añoFabricacion;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}	
}
