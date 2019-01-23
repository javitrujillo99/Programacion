package Capitulo5.Bloque5.CajaSupermercado;

import javax.swing.JOptionPane;

public class Cliente {
	private String dni = JOptionPane.showInputDialog("Introduce DNI");
	private String nombre = JOptionPane.showInputDialog("Introduce nombre");
	
	/**
	 * 
	 */
	public Cliente() {
		super();
	}

	/**
	 * @param dni
	 * @param nombre
	 */
	public Cliente(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "DNI: " + dni + "\t\t\tNombre: " + nombre;
	}
	
}
