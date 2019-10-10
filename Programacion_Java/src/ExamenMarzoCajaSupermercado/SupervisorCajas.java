package ExamenMarzoCajaSupermercado;

public class SupervisorCajas implements ArticuloDevueltoListener{
	
	

	/**
	 * 
	 */
	public SupervisorCajas() {
		super();
		Caja.addArticuloDevueltoListener(this);
	}

	@Override
	public void articuloDevuelto(ArticuloDevueltoEvent event) {
		System.out.println("El supervisor de cajas ha sido informado de que un articulo ha sido devuelto");
	}

}
