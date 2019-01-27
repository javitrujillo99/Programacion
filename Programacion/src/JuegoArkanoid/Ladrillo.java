package JuegoArkanoid;

import java.awt.Color;

public class Ladrillo extends Objeto {
	Color color;
	
	public Ladrillo(Stage stage) {
		super(stage);
		setSpriteName("ladrilloBueno.png");
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
