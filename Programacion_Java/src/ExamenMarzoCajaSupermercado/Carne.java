package ExamenMarzoCajaSupermercado;

public class Carne extends Articulo{
	private String tipoCarne;

	/**
	 * 
	 */
	public Carne() {
		super();
	}

	/**
	 * @param identificador
	 * @param nombre
	 * @param cantidad
	 * @param precioUnitario
	 */
	public Carne(int identificador, String nombre, int cantidad, int precioUnitario, String tipoCarne) {
		super(identificador, nombre, cantidad, precioUnitario);
		this.tipoCarne = tipoCarne;
	}

	public String getTipoCarne() {
		return tipoCarne;
	}

	public void setTipoCarne(String tipoCarne) {
		this.tipoCarne = tipoCarne;
	}

	@Override
	public String getDescripcion() {
		String descripcion;
		descripcion = "Identificador: " + this.getIdentificador() + " Nombre: " + this.getNombre() + " Cantidad: "
		+ this.getCantidad() + "PrecioUnitario: " + this.getPrecioUnitario() + " Tipo de carne: " + this.tipoCarne;
		return descripcion;
	}
	
}
