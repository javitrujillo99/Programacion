package JuegoArkanoid;

import java.util.ArrayList;
import java.util.List;



public class Ladrillo extends Objeto {
	String[] ladrillos = new String[] {"ladrilloBueno.png" , "ladrilloVerde.png" ,"ladrilloAmarillo.png"
			,"ladrilloRojo.png" ,"ladrilloAzulito.png" ,"ladrilloRosa.png"};
	public static int numAzar;
	public static Ladrillo ladrilloColisionado;
	private static List<LadrilloDestruidoListener> ladrilloDestruidoListeners = new ArrayList<LadrilloDestruidoListener>();
	
	public Ladrillo(Stage stage, int i) {
		super(stage);
		setSpriteNames(new String[] {ladrillos[i]});
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void addLadrilloDestruidoListener(LadrilloDestruidoListener listener) {
		ladrilloDestruidoListeners.add(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void removeLadrilloDestruidoListener(LadrilloDestruidoListener listener) {
		ladrilloDestruidoListeners.remove(listener);
	}
	
	/**
	 * 
	 * @param event
	 */
	public static void fireLadrilloDestruidoListener(LadrilloDestruidoEvent event) {
		for (LadrilloDestruidoListener listener : ladrilloDestruidoListeners) {
			listener.ladrilloDestruido(event);
		}
	}
	
	
	public void collision(Objeto o) {
		Listener listener;
		if (o instanceof Pelota) {
			LadrilloDestruidoEvent event = new LadrilloDestruidoEvent(this);
			fireLadrilloDestruidoListener(event);
			
			Arkanoid.setContLadrillos(Arkanoid.getContLadrillos() - 1);
			remove();
			numAzar = 8;
			ladrilloColisionado = this;
					//(int)Math.round(Math.random() * (1 - 10) + 10);
		}
	}	
}
