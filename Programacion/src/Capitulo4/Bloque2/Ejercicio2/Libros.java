package Capitulo4.Bloque2.Ejercicio2;

public class Libros extends Antiguedad {
	
	private String autor;
	private String titulo;
	
	/**
	 * 
	 */
	public Libros() {
		super();
	}

	
	/**
	 * 
	 * @param añoFabricacion
	 * @param origen
	 * @param precio
	 * @param autor
	 * @param titulo
	 */
	public Libros(int añoFabricacion, String origen, float precio, String autor, String titulo) {
		super(añoFabricacion, origen, precio);
		this.autor = autor;
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	@Override
	public String toString() {
		return "Libros [autor=" + autor + ", titulo=" + titulo + ", getAñoFabricacion()=" + getAñoFabricacion()
				+ ", getOrigen()=" + getOrigen() + ", getPrecio()=" + getPrecio() + "]";
	}
	
	
	
	
	
	

}
