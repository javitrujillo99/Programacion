package ExamenMarzoCajaSupermercado;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private List<Articulo> listaArticulos = new ArrayList<Articulo>();
	private Articulo lacteo = new Lacteos(001, "Huevo", 3, 2, "Galicia");
	private Articulo limpieza = new Limpieza(002, "Limpiacristales", 1, 3, "Verde");
	private Articulo carne = new Carne(003, "Chuleton", 3, 10, "Carne roja");
	private Articulo bebida = new Bebida(004, "Pepsi", 5, 1, "20mg por cada 100ml");
	private Articulo fruta = new Fruta(005, "Naranja", 10, 1, "C y D");
	
	/**
	 * @return 
	 */
	public List<Articulo> listaArticulos() {
		listaArticulos.add(lacteo);
		listaArticulos.add(limpieza);
		listaArticulos.add(carne);
		listaArticulos.add(bebida);
		listaArticulos.add(fruta);
		return listaArticulos;
	}

	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}

	public void setListaArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}



	public Articulo getLacteo() {
		return lacteo;
	}

	public void setLacteo(Articulo lacteo) {
		this.lacteo = lacteo;
	}

	public Articulo getLimpieza() {
		return limpieza;
	}

	public void setLimpieza(Articulo limpieza) {
		this.limpieza = limpieza;
	}

	public Articulo getCarne() {
		return carne;
	}

	public void setCarne(Articulo carne) {
		this.carne = carne;
	}

	public Articulo getBebida() {
		return bebida;
	}

	public void setBebida(Articulo bebida) {
		this.bebida = bebida;
	}

	public Articulo getFruta() {
		return fruta;
	}

	public void setFruta(Articulo fruta) {
		this.fruta = fruta;
	}
	

	
	
	

}
