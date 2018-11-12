package Capitulo4.Bloque2.EjercicioRafa;

public class FP extends Matricula {
	private boolean dual;

	/**
	 * 
	 */
	public FP() {
		super();
	}

	/**
	 * 
	 * @param fecha
	 * @param codigo
	 * @param dual
	 */
	public FP(String fecha, String codigo, boolean dual) {
		super(fecha, codigo);
		this.dual = dual;
	}

	public boolean isDual() {
		return dual;
	}

	public void setDual(boolean dual) {
		this.dual = dual;
	}

	@Override
	public String toString() {
		return "FP [dual=" + dual + ", getFecha()=" + getFecha() + ", getCodigo()=" + getCodigo() + ", getClass()="
				+ getClass() + "]";
	}
	
	
	

}
