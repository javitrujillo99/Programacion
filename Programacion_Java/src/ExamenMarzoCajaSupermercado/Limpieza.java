package ExamenMarzoCajaSupermercado;

public class Limpieza extends Articulo{
	private String colorArticulo;

	/**
	 * 
	 */
	public Limpieza() {
		super();
	}

	/**
	 * @param identificador
	 * @param nombre
	 * @param cantidad
	 * @param precioUnitario
	 */
	public Limpieza(int identificador, String nombre, int cantidad, int precioUnitario, String colorArticulo) {
		super(identificador, nombre, cantidad, precioUnitario);
		this.colorArticulo = colorArticulo;
	}
	

	public String getColorArticulo() {
		return colorArticulo;
	}

	public void setColorArticulo(String colorArticulo) {
		this.colorArticulo = colorArticulo;
	}

	@Override
	public String getDescripcion() {
		String descripcion;
		descripcion = "Identificador: " + this.getIdentificador() + " Nombre: " + this.getNombre() + " Cantidad: "
		+ this.getCantidad() + "PrecioUnitario: " + this.getPrecioUnitario() + " Color del articulo: " + this.colorArticulo;
		return descripcion;
	}
	
	
}
