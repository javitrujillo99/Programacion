package ExamenMarzoCajaSupermercado;

public class Bebida extends Articulo{
	private String cantidadAzucares;

	/**
	 * 
	 */
	public Bebida() {
		super();
	}

	/**
	 * @param identificador
	 * @param nombre
	 * @param cantidad
	 * @param precioUnitario
	 */
	public Bebida(int identificador, String nombre, int cantidad, int precioUnitario, String cantidadAzucares) {
		super(identificador, nombre, cantidad, precioUnitario);
		this.cantidadAzucares = cantidadAzucares;
	}

	public String getCantidadAzucares() {
		return cantidadAzucares;
	}

	public void setCantidadAzucares(String cantidadAzucares) {
		this.cantidadAzucares = cantidadAzucares;
	}

	@Override
	public String getDescripcion() {
		String descripcion;
		descripcion = "Identificador: " + this.getIdentificador() + " Nombre: " + this.getNombre() + " Cantidad: "
		+ this.getCantidad() + "PrecioUnitario: " + this.getPrecioUnitario() + " Cantidad de azucares: " + this.cantidadAzucares;
		return descripcion;
	}
	
}
