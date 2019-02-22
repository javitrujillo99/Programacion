package JuegoArkanoid;

public class PildoraNave extends Objeto {
	

	public PildoraNave(Stage stage) {
		super(stage);
		setSpriteNames(new String[] {"pildoraNave.png"});
	}
	
	public void act() {
		this.setY(this.getY() + 2);
	}
	
	public void collision(Objeto o) {
		if (o instanceof Nave) {
			remove();
			Arkanoid.getInstancia().getNave().setSpriteNames(new String[] {"naveGrande.png"});
		}
	}

}
