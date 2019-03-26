package ExamenMarzoCajaSupermercado;

public class ArticuloDevueltoEvent {
	private Articulo articulo;

	/**
	 * @param articulo
	 */
	public ArticuloDevueltoEvent(Articulo articulo) {
		super();
		this.articulo = articulo;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
}
