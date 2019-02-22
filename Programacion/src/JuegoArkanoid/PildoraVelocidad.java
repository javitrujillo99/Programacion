package JuegoArkanoid;

public class PildoraVelocidad extends Objeto{
	

	public PildoraVelocidad(Stage stage) {
		super(stage);
		setSpriteNames(new String[] {"pastillaBuena.png"});
	}
	public void act() {
		this.setY(this.getY() + 2);
	}
	
	public void collision(Objeto o) {
		if (o instanceof Nave) {
			remove();
			Arkanoid.getInstancia().getPelota().setPixelsXFrame(Arkanoid.getInstancia().getPelota().getPixelsXFrame() + 2);
		}
	}
	

}
