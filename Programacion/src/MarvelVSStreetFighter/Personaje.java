package MarvelVSStreetFighter;


public abstract class Personaje {
	private int id;
	private String nombre;
	private int puntosVida;
	
	
	/**
	 * 
	 */
	public Personaje() {
		super();
	}
	/**
	 * @param id
	 * @param nombre
	 * @param puntosVida
	 */
	public Personaje(int id, String nombre, int puntosVida) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.puntosVida = puntosVida;
	}
	
	/**
	 * 
	 */
	public abstract void atacar();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntosVida() {
		return puntosVida;
	}
	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}
	
}
