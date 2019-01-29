package JuegoArkanoid;

import java.awt.Color;


public class Ladrillo extends Objeto {
	Color color;
	
	public Ladrillo(Stage stage, String color) {
		super(stage);
		if (color == "azul") {
			setSpriteNames(new String[] {("ladrilloBueno.png")});
		}
		if (color == "rojo") {
			setSpriteNames(new String[] {("ladrilloRojo.png")});
		}
		if (color == "verde") {
			setSpriteNames(new String[] {("ladrilloVerde.png")});
		}
		if (color == "rosa") {
			setSpriteNames(new String[] {("ladrilloRosa.png")});
		}
		if (color == "amarillo") {
			setSpriteNames(new String[] {("ladrilloAmarillo.png")});
		}
		if (color == "azulito") {
			setSpriteNames(new String[] {("ladrilloAzulito.png")});
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void collision(Objeto o) {
		if (o instanceof Pelota) {
			remove();
			setFrameSpeed(35);
		}
	}
	
}
