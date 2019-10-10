package ExamenMarzoCajaSupermercado;


public abstract class Articulo {
	private int identificador;
	private String nombre;
	private int cantidad;
	private int precioUnitario;
	
	
	/**
	 * 
	 */
	public Articulo() {
		super();
	}
	
	/**
	 * @param identificador
	 * @param nombre
	 * @param cantidad
	 * @param precioUnitario
	 */
	public Articulo(int identificador, String nombre, int cantidad, int precioUnitario) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}
	
	public abstract String getDescripcion();
	
	

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
}
