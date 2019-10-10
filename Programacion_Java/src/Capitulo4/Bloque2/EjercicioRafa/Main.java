package Capitulo4.Bloque2.EjercicioRafa;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// Gestión de creación de la persona
				int opcion = menuPersona();
				if (opcion >= 1 && opcion <= 2) {
					Persona persona = construyePersona(opcion);
					System.out.println("Persona " + persona.toString());
				}

				// Gestión de creación de la matrícula
				opcion = menuMatricula();
				if (opcion >= 1 && opcion <= 3) {
					Matricula mat = construyeMatricula(opcion);
					System.out.println("Matrícula " + mat.toString());
				}
			
			}
			/**
			 * 
			 */
			public static int menuPersona () {
				String menuPersona = "Introduzca el tipo de persona"
						+ "\n\n1.- No documentada"
						+ "\n2.- Documentada por DNI";
				
				int opcionPersona = Integer.parseInt(JOptionPane.showInputDialog(
						menuPersona));
				return opcionPersona;
			}
			
			
			/**
			 * 
			 * @param tipoPersona
			 * @return
			 */
			public static Persona construyePersona (int tipoPersona) {
				Persona persona = null;
				
				switch (tipoPersona) {
				case 1: // No documentada
					persona = new PersonaND();
					((PersonaND) persona).setDescricpion(JOptionPane.showInputDialog("Introduzca descripción:"));
					break;
				case 2: // Documentada por DNI
					persona = new PersonaD();
					PersonaD perSiDoc = (PersonaD) persona;
					perSiDoc.setNombre(JOptionPane.showInputDialog("Introduzca dni:"));
					break;
				}
				
				persona.setNombre(JOptionPane.showInputDialog("Introduzca nombre:"));
				persona.setApellidos(JOptionPane.showInputDialog("Introduzca apellidos:"));
				persona.setFechaNacimiento(JOptionPane.showInputDialog("Introduzca fecha de nacimiento:"));
				
				return persona;
			}
			
			
			
			/**
			 * 
			 */
			public static int menuMatricula () {
				String menu = "Introduzca el tipo de matrícula"
						+ "\n\n1.- Matrícula en ESO"
						+ "\n2.- Matrícula en Bach"
						+ "\n3.- Matrícula en FP";
				
				int opcion = Integer.parseInt(JOptionPane.showInputDialog(
						menu));
				return opcion;
			}
			
			
			/**
			 * 
			 * @param tipoPersona
			 * @return
			 */
			public static Matricula construyeMatricula (int tipo) {
				Matricula matricula = null;
				
				switch (tipo) {
				case 1: // en ESO
					matricula = new ESO();
					((ESO) matricula).setPmar(Boolean.parseBoolean(JOptionPane.showInputDialog("Introduzca descripción:")));
					break;
				case 2: // en Bach
					matricula = new Bachillerato();
					((Bachillerato) matricula).setModalidad(JOptionPane.showInputDialog("Introduzca descripción:"));
					break;
				case 3: // en FP
					matricula = new FP();
					((FP) matricula).setDual(Boolean.parseBoolean(JOptionPane.showInputDialog("Introduzca descripción:")));
					break;
				}
				
				matricula.setCodigo(JOptionPane.showInputDialog("Introduzca código:"));
				matricula.setFecha(JOptionPane.showInputDialog("Introduzca fecha:"));
				
				return matricula;
	}
}
