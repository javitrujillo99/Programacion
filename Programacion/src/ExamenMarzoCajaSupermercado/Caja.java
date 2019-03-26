package ExamenMarzoCajaSupermercado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;




public class Caja {
	private HashMap<Integer, Articulo> hmCaja = new HashMap<Integer, Articulo>();
	Articulo articulo1;
	Articulo articulo2;
	Articulo articulo3;
	Articulo articulo4;
	Articulo articulo5;
	private static List<ArticuloDevueltoListener> listeners = new ArrayList<ArticuloDevueltoListener>();
	
	/**
	 * 
	 * @param cliente
	 */
	public void agregarArticulos(Cliente cliente) {
		//Saco cada articulo de los 5 que hay en la lista de articulos del cliente
		articulo1 = cliente.getListaArticulos().get(0);
		articulo2 = cliente.getListaArticulos().get(1);
		articulo3 = cliente.getListaArticulos().get(2);
		articulo4 = cliente.getListaArticulos().get(3);
		articulo5 = cliente.getListaArticulos().get(4);
		//Agrego cada articulo sacado al hashMap
		hmCaja.put(articulo1.getIdentificador(), articulo1);
		hmCaja.put(articulo2.getIdentificador(), articulo2);
		hmCaja.put(articulo3.getIdentificador(), articulo3);
		hmCaja.put(articulo4.getIdentificador(), articulo4);
		hmCaja.put(articulo5.getIdentificador(), articulo5);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void addArticuloDevueltoListener(ArticuloDevueltoListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void removeArticuloDevueltoListener(ArticuloDevueltoListener listener) {
		listeners.remove(listener);
	}
	
	/**
	 * 
	 * @param event
	 */
	public static void fireArticuloDevueltoListener(ArticuloDevueltoEvent event) {
		for (ArticuloDevueltoListener listener: listeners) {
			listener.articuloDevuelto(event);
		}
	}
	
	public int obtenerTotalDineroAPagar(HashMap hmCaja) {
		
		int precioTotal = 0;
		Articulo articulo;
		System.out.println("\nRecorrido del HashMap:");
		Object claves[] = hmCaja.keySet().toArray();
		for (int i = 0; i < claves.length; i++) {
			articulo = (Articulo) hmCaja.get(claves[i]);
			precioTotal += articulo.getCantidad() * articulo.getPrecioUnitario();
		}
		return precioTotal;
	}
	
	public void devolverArticulo() {
		System.out.println("Articulos disponibles:");
		Object claves[] = hmCaja.keySet().toArray();
		for (int i = 0; i < claves.length; i++) {
			System.out.println("Identificador " + claves[i].toString() + ". Descripcion "  + hmCaja.get(claves[i].toString()));
		}
		int identificador = Integer.parseInt(JOptionPane.showInputDialog("Introduzca identificador del articulo a devolver:"));
		hmCaja.remove(identificador);
		ArticuloDevueltoEvent event = new ArticuloDevueltoEvent(hmCaja.get(identificador));
		fireArticuloDevueltoListener(event);
	}
	
	public void pagar() throws CashInsuficienteException {
		int cuenta = obtenerTotalDineroAPagar(hmCaja);
		System.out.println("Total a pagar: " + cuenta);
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduzca cantidad que va a pagar: "));
		if (cantidad < cuenta) {
			throw new CashInsuficienteException();
		}
	}
	
	
	
}
