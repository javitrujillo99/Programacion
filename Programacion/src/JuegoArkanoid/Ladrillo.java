package JuegoArkanoid;


public class Ladrillo extends Objeto {
	String[] ladrillos = new String[] {"ladrilloBueno.png" , "ladrilloVerde.png" ,"ladrilloAmarillo.png"
			,"ladrilloRojo.png" ,"ladrilloAzulito.png" ,"ladrilloRosa.png"};
	public static int numAzar;
	public static Ladrillo ladrilloColisionado;
	
	public Ladrillo(Stage stage, int i) {
		super(stage);
		setSpriteNames(new String[] {ladrillos[i]});
	}
	
	
	public void collision(Objeto o) {
		if (o instanceof Pelota) {
			Arkanoid.setContLadrillos(Arkanoid.getContLadrillos() - 1);
			remove();
			numAzar = 8;
			ladrilloColisionado = this;
					//(int)Math.round(Math.random() * (1 - 10) + 10);
		}
	}	
}
