package Capitulo4.Bloque2.Ejercicio1;

public class ArticuloPerecedero extends Articulo {
	
	private String fechaCaducidad;

	
	public ArticuloPerecedero() {
		super();
	}
	
	
	public ArticuloPerecedero(String codigo, String nombre, float precio, String fechaCaducidad) {
		super(codigo, nombre, precio);
		this.fechaCaducidad = fechaCaducidad;
	}


	public String getFechaCaducidad() {
		return fechaCaducidad;
	}


	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}


	@Override
	public String toString() {
		return "ArticuloPerecedero [fechaCaducidad=" + fechaCaducidad + ", getCodigo()=" + getCodigo()
				+ ", getNombre()=" + getNombre() + ", getPrecio()=" + getPrecio() + "]";
	}
	
	
	

}
