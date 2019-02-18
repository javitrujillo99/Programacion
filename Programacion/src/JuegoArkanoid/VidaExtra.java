package JuegoArkanoid;

public class VidaExtra extends Objeto{
	protected float vy;
	private TrayectoriaRecta trayectoria = null;
	private PuntoAltaPrecision coordenadas = null;
	private float pixelsXFrame = 3;

	public VidaExtra(Stage stage) {
		super(stage);
		setSpriteNames(new String[] {("vidaExtra.png")});
	}
	public void act() {
		if (this.trayectoria == null) {
			this.coordenadas = new PuntoAltaPrecision(x, y);
			this.trayectoria = new TrayectoriaRecta(1, coordenadas, true);
		}
		this.coordenadas = this.trayectoria.getPuntoADistanciaDePunto(this.coordenadas, pixelsXFrame);
		if (pixelsXFrame < 5) {
			pixelsXFrame *= 1.00035;
			}
		this.x = Ladrillo.ladrilloColisionado.getX();
		this.y = Ladrillo.ladrilloColisionado.getY();
		if (y < 0 || y > (Stage.HEIGHT - 42)) {
			this.trayectoria.reflejarVerticalmenteRespectoAPunto(coordenadas);
		}
	}

	public float getVy() { return vy; }
	public void setVy(int i) {vy = i;	}

}
