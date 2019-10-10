package Capitulo6.Bloque1HashMap.Ejercicio1Bloque1Cap6;

public class Articulo {
	private String codBarras;
	private String estante;
	private String descripcion;
	/**
	 * @param codigoBarras
	 * @param estante
	 * @param descripcion
	 */
	public Articulo(String codBarras, String estante, String descripcion) {
		super();
		this.codBarras = codBarras;
		this.estante = estante;
		this.descripcion = descripcion;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
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
	@Override
	public String toString() {
		return "Articulo [codBarras=" + codBarras + ", estante=" + estante + ", descripcion=" + descripcion + "]";
	}
	
	
}
