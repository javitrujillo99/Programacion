package ExamenMarzoCajaSupermercado;

public class Lacteos extends Articulo{
	private String lugarProcedencia;

	/**
	 * 
	 */
	public Lacteos() {
		super();
	}

	

	/**
	 * @param identificador
	 * @param nombre
	 * @param cantidad
	 * @param precioUnitario
	 */
	public Lacteos(int identificador, String nombre, int cantidad, int precioUnitario, String lugarProcedencia) {
		super(identificador, nombre, cantidad, precioUnitario);
		this.lugarProcedencia = lugarProcedencia;
	}
	
	
	public String getLugarProcedencia() {
		return lugarProcedencia;
	}

	public void setLugarProcedencia(String lugarProcedencia) {
		this.lugarProcedencia = lugarProcedencia;
	}

	@Override
	public String getDescripcion() {
		String descripcion;
		descripcion = "Identificador: " + this.getIdentificador() + " Nombre: " + this.getNombre() + " Cantidad: "
		+ this.getCantidad() + "PrecioUnitario: " + this.getPrecioUnitario() + " Lugar procedencia: " + this.lugarProcedencia;
		return descripcion;
	}

	

	
	

}
