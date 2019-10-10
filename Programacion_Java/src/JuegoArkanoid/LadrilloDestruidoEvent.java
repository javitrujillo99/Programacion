package JuegoArkanoid;

public class LadrilloDestruidoEvent {
	private Ladrillo ladrillo;

	/**
	 * @param ladrillo
	 */
	public LadrilloDestruidoEvent(Ladrillo ladrillo) {
		super();
		this.ladrillo = ladrillo;
	}

	public Ladrillo getLadrillo() {
		return ladrillo;
	}

	public void setLadrillo(Ladrillo ladrillo) {
		this.ladrillo = ladrillo;
	}
	

}
