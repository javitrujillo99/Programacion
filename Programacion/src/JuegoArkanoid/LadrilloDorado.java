package JuegoArkanoid;

public class LadrilloDorado extends Ladrillo{
	private int contadorColisiones = 0;

	public LadrilloDorado(Stage stage, int i) {
		super(stage, i);
		setSpriteNames( new String[] {("LadrilloArkanoidOro.png")});
	}

	public void collision(Objeto o) {
		if (o instanceof Pelota) {
			contadorColisiones++;	
		}
		if (contadorColisiones == -1) {
			remove();
		}
	}
	
}
