package MarvelVSStreetFighter;

import javax.swing.JOptionPane;

public class Juego {
	private static IronMan ironMan;
	private static Ryu ryu;
	public static void empiezaJuego() {
		ironMan = new IronMan(0001, "Iron Man", 100);
		ryu = new Ryu(0002, "Ryu", 100);
		System.out.println("Comienza el combate entre " + ironMan.getNombre() + " y " + getRyu().getNombre());
		turnos(ironMan, getRyu());
	}
	
	public static void turnos(IronMan ironMan, Ryu ryu) {
		while (ironMan.getPuntosVida() >= 0 && ryu.getPuntosVida() >= 0) {
			System.out.println("\nTurno de " + ironMan.getNombre());
			ironMan.atacar();
			
			//Condicion de escape para cuando los puntos de vida han bajado de 0 pero el bucle continua hasta que llega al final.
			if (ryu.getPuntosVida() <= 0) {
				System.out.println("\n\nEL GANADOR ES IRON MAN!!!");
				System.exit(0);
			}
			JOptionPane.showMessageDialog(null, "Pulsa Enter para continuar");
			System.out.println("\nTurno de " + ryu.getNombre());
			ryu.atacar();
			if (ironMan.getPuntosVida() <= 0) {
				System.out.println("\n\nEL GANADOR ES RYU!!!!!");
			}
		} 
	}

	public static void main(String[] args) {
		empiezaJuego();
		

	}

	public static Ryu getRyu() {
		return ryu;
	}

	public static void setRyu(Ryu ryu) {
		Juego.ryu = ryu;
	}

	public static IronMan getIronMan() {
		return ironMan;
	}

	public static void setIronMan(IronMan ironMan) {
		Juego.ironMan = ironMan;
	}

}
