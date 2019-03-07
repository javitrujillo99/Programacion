package Capitulo6.Bloque1.Ejercicio1Bloque1Cap6;

public class Articulo {
	private String codigoBarras;
	private String estante;
	private String descripcion;
	/**
	 * @param codigoBarras
	 * @param estante
	 * @param descripcion
	 */
	public Articulo(String codigoBarras, String estante, String descripcion) {
		super();
		this.codigoBarras = codigoBarras;
		this.estante = estante;
		this.descripcion = descripcion;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getEstante() {
		return estante;
	}
	public void setEstante(String estante) {
		this.estante = estante;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
