package JuegoArkanoid;

public class Listener implements LadrilloDestruidoListener{

	/**
	 * 
	 */
	public Listener() {
		super();
		Ladrillo.addLadrilloDestruidoListener(this);
	}

	@Override
	public void ladrilloDestruido(LadrilloDestruidoEvent event) {
		System.out.println("Ladrillo destruido");
		
	}

}
