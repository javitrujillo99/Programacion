package JuegoArkanoid;

public class VidaExtra extends Objeto{

	public VidaExtra(Stage stage) {
		super(stage);
		setSpriteNames(new String[] {("vidaExtra.png")});
	}
	public void act() {
		this.setY(this.getY() + 2);
	}
	public void collision (Objeto o) {
		if (o instanceof Nave) {
			remove();
			Arkanoid.getInstancia().setContadorVidas(Arkanoid.getInstancia().getContadorVidas() + 1);
		}
	}
}
