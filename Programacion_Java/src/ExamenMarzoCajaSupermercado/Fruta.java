package ExamenMarzoCajaSupermercado;

public class Fruta extends Articulo{
	private String tipoVitaminas;

	/**
	 * 
	 */
	public Fruta() {
		super();
	}

	/**
	 * @param identificador
	 * @param nombre
	 * @param cantidad
	 * @param precioUnitario
	 */
	public Fruta(int identificador, String nombre, int cantidad, int precioUnitario, String tipoVitaminas) {
		super(identificador, nombre, cantidad, precioUnitario);
		this.tipoVitaminas = tipoVitaminas;
	}

	public String getTipoVitaminas() {
		return tipoVitaminas;
	}

	public void setTipoVitaminas(String tipoVitaminas) {
		this.tipoVitaminas = tipoVitaminas;
	}

	@Override
	public String getDescripcion() {
		String descripcion;
		descripcion = "Identificador: " + this.getIdentificador() + " Nombre: " + this.getNombre() + " Cantidad: "
		+ this.getCantidad() + "PrecioUnitario: " + this.getPrecioUnitario() + " Tipos de vitaminas: " + this.tipoVitaminas;
		return descripcion;
	}
	
}
