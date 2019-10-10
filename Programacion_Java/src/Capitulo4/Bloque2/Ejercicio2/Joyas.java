package Capitulo4.Bloque2.Ejercicio2;

public class Joyas extends Antiguedad {
	
	private String materialFabricacion;

	
	/**
	 * 
	 */
	public Joyas() {
		super();
	}

	
	/**
	 * 
	 * @param añoFabricacion
	 * @param origen
	 * @param precio
	 * @param materialFabricacion
	 */
	public Joyas(int añoFabricacion, String origen, float precio, String materialFabricacion) {
		super(añoFabricacion, origen, precio);
		this.materialFabricacion = materialFabricacion;
	}


	public String getMaterialFabricacion() {
		return materialFabricacion;
	}


	public void setMaterialFabricacion(String materialFabricacion) {
		this.materialFabricacion = materialFabricacion;
	}


	@Override
	public String toString() {
		return "Joyas [materialFabricacion=" + materialFabricacion + ", getAñoFabricacion()=" + getAñoFabricacion()
				+ ", getOrigen()=" + getOrigen() + ", getPrecio()=" + getPrecio() + "]";
	}
	
	
	
	
	
	
	
}
