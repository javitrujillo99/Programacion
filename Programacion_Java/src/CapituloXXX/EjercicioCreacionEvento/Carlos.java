package CapituloXXX.EjercicioCreacionEvento;

public class Carlos implements PalabraIntroducidaListener {
	
	public Carlos() {
		Principal.addPalabraIntroducidaListener(this);
	}

	@Override
	public void palabraIntroducida(PalabraIntroducidaEvent e) {
		System.out.println("Has introducido la palabra mágica " + e.getPalabraIndtroducida());
	}

}
