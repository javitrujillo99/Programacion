package Capitulo4.Bloque2.Ejercicio2;

public class Antiguedad {
	private int aņoFabricacion;
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
	 * @param aņoFabricacion
	 * @param origen
	 * @param precio
	 */
	public Antiguedad(int aņoFabricacion, String origen, float precio) {
		super();
		this.aņoFabricacion = aņoFabricacion;
		this.origen = origen;
		this.precio = precio;
	}


	public int getAņoFabricacion() {
		return aņoFabricacion;
	}


	public void setAņoFabricacion(int aņoFabricacion) {
		this.aņoFabricacion = aņoFabricacion;
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
