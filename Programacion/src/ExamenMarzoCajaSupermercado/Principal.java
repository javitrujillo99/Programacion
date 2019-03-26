package ExamenMarzoCajaSupermercado;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	
	


	public static void main(String[] args) {
		SupervisorCajas supervisor = new SupervisorCajas();
		Caja caja = new Caja();
		String nombreSupermercado = FicheroPropiedades.getProperty("NOMBRE");
		System.out.println("Nombre del supermercado: " + nombreSupermercado);
		Cliente cliente = new Cliente();
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		listaArticulos = cliente.listaArticulos();
		for (int i = 0; i < listaArticulos.size(); i++) {
			System.out.println(listaArticulos.get(i).getDescripcion());
		}
		caja.agregarArticulos(cliente);
		
		caja.devolverArticulo();
		try {
			caja.pagar();
		} catch (CashInsuficienteException e) {
			System.out.println("Dinero insuficiente");
		}
		
	}

}
