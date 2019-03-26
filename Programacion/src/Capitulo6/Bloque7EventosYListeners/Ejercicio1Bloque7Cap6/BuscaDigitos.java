package Capitulo6.Bloque7EventosYListeners.Ejercicio1Bloque7Cap6;

public class BuscaDigitos implements PalabraContieneTresDigitosListener{
	

	/**
	 * 
	 */
	public BuscaDigitos() {
		Principal.addPalabraContieneTresDigitosListener(this);
	}

	@Override
	public void tresDigitosEncontrados(PalabraContieneTresDigitosEvent event) {
		System.out.println("La palabra contiene 3 dígitos");
		
	}

}
