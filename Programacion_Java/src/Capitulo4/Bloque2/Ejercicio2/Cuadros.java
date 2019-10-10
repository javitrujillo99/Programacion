package Capitulo4.Bloque2.Ejercicio2;

public class Cuadros extends Antiguedad {
	
	private String autor;

	
	/**
	 * 
	 */
	public Cuadros() {
		super();
	}

	
	/**
	 * 
	 * @param añoFabricacion
	 * @param origen
	 * @param precio
	 * @param autor
	 */
	public Cuadros(int añoFabricacion, String origen, float precio, String autor) {
		super(añoFabricacion, origen, precio);
		this.autor = autor;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	@Override
	public String toString() {
		return "Cuadros [autor=" + autor + ", getAñoFabricacion()=" + getAñoFabricacion() + ", getOrigen()="
				+ getOrigen() + ", getPrecio()=" + getPrecio() + "]";
	}
	
	

}
