package EjerciciosRafa.JuegoFormulaUno;


public class Carrera {
	// Singleton
	private static Carrera carrera = null;
	private Vehiculo vehiculos[] = null;
	private int numPista = (int)Math.round(Math.random() * (1 + 5)- 5);

	/**
	 * 
	 */
	
	public Carrera() {
		super();
		vehiculos = new Vehiculo[5];
	}
	
	
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static Carrera getCarrera() {
		if (carrera == null) {
			carrera = new Carrera();
		}
		return carrera;
	}
	
	public void comienzaCarrera() {
		//Creo los vehiculos
		vehiculos[0] = new Coche("Lewis Hamilton", "6A6D76");
		vehiculos[1] = new Moto("Dani Pedrosa", "ffe97c");
		vehiculos[2] = new Coche("Fernando Alonso", "F78A1F");
		vehiculos[3] = new Coche("María de Villota", "8effd9");
		vehiculos[4] = new Moto("Ana Carrasco", "d18eff");
		do {
			for (int i = 0; i < vehiculos.length; i++) {
				if (!vehiculos[i].estaVehiculoTerminado()) {
					System.out.print(vehiculos[i].paint());
					vehiculos[i].avanza();
					System.out.println(" avanza " + vehiculos[i].getMetrosAvanzados() + " metros");
					System.out.println("Metros totales avanzados: " + 
					vehiculos[i].getAcumuladorMetros() + "\n");
				}
			}
		} while (!estaCarreraTerminada());
	}

	public boolean estaCarreraTerminada() {
		for (int i = 0; i < vehiculos.length; i++) {
			if (!vehiculos[i].estaVehiculoTerminado()) {
				return false;
			}
		}
		return true;
	}
	
	public void podium() {
		// Ordenación por el método de la burbuja, para que los jugadores queden
		// ordenados por orden de llegada a la meta
		for (int i = vehiculos.length-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (vehiculos[j].getPodium() > vehiculos[j+1].getPodium()) {
					Vehiculo aux = vehiculos[j];
					vehiculos[j] = vehiculos[j+1];
					vehiculos [j+1] = aux;
				}
			}
		}
	}
	
	public void imprimePodium () {
		// Imprimo array del podium
		System.out.println("\n\nPodium de vehiculos");
		for (int i = 0; i < vehiculos.length; i++) {
			System.out.println(vehiculos[i].toString());
		}
	}
	
	
	public Carrera(Vehiculo[] vehiculos) {
		super();
		this.vehiculos = vehiculos;
	}

	public Vehiculo[] getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Vehiculo[] vehiculos) {
		this.vehiculos = vehiculos;
	}
	

}
