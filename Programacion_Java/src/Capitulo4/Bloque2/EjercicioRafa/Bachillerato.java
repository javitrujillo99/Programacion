package Capitulo4.Bloque2.EjercicioRafa;

public class Bachillerato extends Matricula {
	private String modalidad;

	/**
	 * 
	 */
	public Bachillerato() {
		super();
	}

	/**
	 * 
	 * @param fecha
	 * @param codigo
	 * @param modalidad
	 */
	public Bachillerato(String fecha, String codigo, String modalidad) {
		super(fecha, codigo);
		this.modalidad = modalidad;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	@Override
	public String toString() {
		return "Bachillerato [modalidad=" + modalidad + ", getFecha()=" + getFecha() + ", getCodigo()=" + getCodigo()
				+ ", getClass()=" + getClass() + "]";
	}
	
	

}
