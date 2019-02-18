package JuegoArkanoid;

public class LadrilloPlateado extends Ladrillo{
	private int contadorColisiones = 0;

	public LadrilloPlateado(Stage stage, int i) {
		super(stage, i);
		setSpriteNames( new String[] {("LadrilloArkanoidPlata.png")});	
	}
	
	public void collision(Objeto o) {
		if (o instanceof Pelota) {
			contadorColisiones++;	
		}
		if (contadorColisiones == 2) {
			remove();
		}
	}

}
