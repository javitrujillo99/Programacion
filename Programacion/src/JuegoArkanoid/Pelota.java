package JuegoArkanoid;


public class Pelota extends Objeto{
protected float vx;
protected float vy;
	
	public Pelota(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {("Baloncesto.png")});
		setFrameSpeed(35);
	}
	
	public void act() {
		super.act();
		x+=vx;
		if (x < 0 || x > (Stage.WIDTH - 18)) {
			
		  vx = -vx;
		}
		y+=vy;
		if (y < 0 || y > (Stage.HEIGHT - 37)) {
		  vy = -vy;
		}
}

	public float getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	
	public float getVy() { return vy; }
	public void setVy(int i) {vy = i;	}
}
