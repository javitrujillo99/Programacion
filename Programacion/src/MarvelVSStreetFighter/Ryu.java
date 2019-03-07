package MarvelVSStreetFighter;

import java.util.ArrayList;
import java.util.List;

public class Ryu extends Personaje {
	private List<Ataque> ataque = new ArrayList<Ataque>();
	
	/**
	 * 
	 */
	public Ryu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nombre
	 * @param puntosVida
	 */
	public Ryu(int id, String nombre, int puntosVida) {
		super(id, nombre, puntosVida);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void atacar() {
		int numAzar1 = (int) Math.round(Math.random() * (3 - 1) + 1);
		System.out.println("Puntos de vida: " + this.getPuntosVida());
		
		for (int i = 0; i < numAzar1; i++) {
			Ataque golpe = null;
			int numAzar2 = (int) Math.round(Math.random() * (3 - 1) + 1);
			if (numAzar2 == 1) {
				golpe = new Punietazo();
				System.out.println("Lanza un puñetazo");
				int numAzar3 = (int)Math.round(Math.random() * 3);
				if (numAzar3 != 3) {
					System.out.println("Puntos de vida quitados: " + golpe.getDanio());
					Juego.getIronMan().setPuntosVida(Juego.getIronMan().getPuntosVida() - golpe.getDanio());
				}
				else {
					System.out.println("¡Puñetazo esquivado!");
				}
			}
			if (numAzar2 == 2) {
				golpe = new Patada();
				System.out.println("Lanza una patada");
				int numAzar3 = (int)Math.round(Math.random() * 3);
				if (numAzar3 != 3) {
					System.out.println("Puntos de vida quitados: " + golpe.getDanio());
					Juego.getIronMan().setPuntosVida(Juego.getIronMan().getPuntosVida() - golpe.getDanio());
				}
				else {
					System.out.println("¡Patada esquivada!");
				}
			}
			if (numAzar2 == 3) {
				golpe = new MovimientoEspecial();
				System.out.println("Lanza un movimiento especial");
				int numAzar3 = (int)Math.round(Math.random() * 3);
				if (numAzar3 != 3) {
					System.out.println("Puntos de vida quitados: " + golpe.getDanio());
					Juego.getIronMan().setPuntosVida(Juego.getIronMan().getPuntosVida() - golpe.getDanio());
				}
				
			}
			ataque.add(golpe);
			System.out.println("Puntos de vida restantes de " + Juego.getIronMan().getNombre() + ": " + Juego.getIronMan().getPuntosVida());
		}
		
	}

}
