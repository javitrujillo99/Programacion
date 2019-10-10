package Capitulo4.Bloque2.EjercicioRafa;

public class PersonaD extends Persona {
	private String DNI;

	/**
	 * 
	 */
	public PersonaD() {
		super();
	}

	/**
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 * @param DNI
	 */
	public PersonaD(String nombre, String apellidos, String fechaNacimiento, String DNI) {
		super(nombre, apellidos, fechaNacimiento);
		this.DNI = DNI;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	@Override
	public String toString() {
		return "PersonaD [DNI=" + DNI + ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos()
				+ ", getFechaNacimiento()=" + getFechaNacimiento() + "]";
	}
	
	
	

}
