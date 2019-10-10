package MarvelVSStreetFighter;

import javax.swing.JOptionPane;

public class Juego {
	private static IronMan ironMan;
	private static Ryu ryu;
	public static void empiezaJuego() {
		ironMan = new IronMan(0001, "Iron Man", 100);
		ryu = new Ryu(0002, "Ryu", 100);
		System.out.println("Comienza el combate entre " + ironMan.getNombre() + " y " + getRyu().getNombre());
		turnos(ironMan, ryu);
	}
	
	public static void turnos(Personaje personaje1, Personaje personaje2) {
		while (personaje1.getPuntosVida() >= 0 && personaje2.getPuntosVida() >= 0) {
			System.out.println("\nTurno de " + personaje1.getNombre());
			personaje1.atacar();
			
			//Condicion de escape para cuando los puntos de vida han bajado de 0 pero el bucle continua hasta que llega al final.
			if (personaje2.getPuntosVida() <= 0) {
				System.out.println("\n\nEl ganador es " + personaje1.getNombre() +"!!!");
				System.exit(0);
			}
			JOptionPane.showMessageDialog(null, "Pulsa Enter para continuar");
			System.out.println("\nTurno de " + personaje2.getNombre());
			personaje2.atacar();
			if (personaje1.getPuntosVida() <= 0) {
				System.out.println("\n\nEl ganador es " + personaje2
						.getNombre() +"!!!");
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
