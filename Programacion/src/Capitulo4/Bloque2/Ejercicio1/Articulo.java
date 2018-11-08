package Capitulo4.Bloque2.Ejercicio1;

public class Articulo {
	private String codigo;
	private String nombre;
	private float precio;
	
	
	/**
	 * 
	 */
	public Articulo() {
		super();
	}
	
	
	/**
	 * 
	 * @param codigo
	 * @param nombre
	 * @param precio
	 */
	public Articulo(String codigo, String nombre, float precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
