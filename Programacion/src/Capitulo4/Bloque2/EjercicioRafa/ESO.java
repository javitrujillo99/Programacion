package Capitulo4.Bloque2.EjercicioRafa;

public class ESO extends Matricula {
	private boolean pmar;

	/**
	 * 
	 */
	public ESO() {
		super();
	}

	/**
	 * 
	 * @param fecha
	 * @param codigo
	 * @param pmar
	 */
	public ESO(String fecha, String codigo, boolean pmar) {
		super(fecha, codigo);
		this.pmar = pmar;
	}

	public boolean isPmar() {
		return pmar;
	}

	public void setPmar(boolean string) {
		this.pmar = string;
	}

	@Override
	public String toString() {
		return "ESO [pmar=" + pmar + ", getFecha()=" + getFecha() + ", getCodigo()=" + getCodigo() + ", getClass()="
				+ getClass() + "]";
	}
	
}
