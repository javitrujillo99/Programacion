package Capitulo4.Bloque2.EjercicioRafa;

public class PersonaND extends Persona {
	private String descricpion;

	/**
	 * 
	 */
	public PersonaND() {
		super();
	}
	
	/**
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 * @param descripcion
	 */
	public PersonaND(String nombre, String apellidos, String fechaNacimiento, String descripcion) {
		super(nombre, apellidos, fechaNacimiento);
		this.descricpion = descripcion;
	}

	public String getDescricpion() {
		return descricpion;
	}

	public void setDescricpion(String descricpion) {
		this.descricpion = descricpion;
	}

	@Override
	public String toString() {
		return "PersonaND [descricpion=" + descricpion + ", getNombre()=" + getNombre() + ", getApellidos()="
				+ getApellidos() + ", getFechaNacimiento()=" + getFechaNacimiento() + "]";
	}
	
	
	
	
}
