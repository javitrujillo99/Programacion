package Capitulo4.Bloque2.Ejercicio3;

public class Hoja extends ComponenteDeArbol {
	private String color;

	/**
	 * 
	 */
	public Hoja() {
		super();
	}

	
	
	/**
	 * @param nombreArbol
	 * @param familiaArbol
	 * @param color
	 */
	public Hoja(String nombreArbol, String familiaArbol, String color) {
		super(nombreArbol, familiaArbol);
		this.color = color;
	}



	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Hoja [color=" + color + "]";
	}
	
	
	
	

}
