package Capitulo4.Bloque2.Ejercicio3;

public class Fruto extends ComponenteDeArbol {
	private String nombreFruto;


	/**
	 * 
	 */
	public Fruto() {
		super();
	}
	
	
	/**
	 * @param nombreFruto
	 */
	

	public String getNombreFruto() {
		return nombreFruto;
	}


	/**
	 * @param nombreArbol
	 * @param familiaArbol
	 */
	public Fruto(String nombreArbol, String familiaArbol, String nombreFruto) {
		super(nombreArbol, familiaArbol);
		this.nombreFruto = nombreFruto;
	}


	public void setNombre(String nombreFruto) {
		this.nombreFruto = nombreFruto;
	}


	@Override
	public String toString() {
		return "Fruto [nombre=" + nombreFruto + "]";
	}
	

	
	
	

}
