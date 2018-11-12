package Capitulo4.juegoLaOca;

public class Tablero {

	public static String msjOca = "De oca a oca y tiro porque me toca";
	public static String msjPuente = "De puente a puente y tiro porque me da la corriente";
	public static String msjDado = "De dado a dado y tiro porque me ha tocado";
	Casilla tablero[] = new Casilla[63];
	
	
	
	public Tablero() {
		super();
		inicializaTablero();
	}

	public void imprimeTablero () {
		for (int i = 0; i < tablero.length; i++) {
			System.out.println(tablero[i].getOrden() + " - " + tablero[i].getNombre());
		}
	}
	
	public void inicializaTablero() {
		// Estructa básica del tablero
				tablero[0] = new Casilla(1, "Inicio");
				tablero[1] = new Casilla(2, "Caballo");
				tablero[2] = new Casilla(3, "Pez");
				tablero[3] = new Casilla(4, "Payaso");
				tablero[4] = new Casilla(5, "Oca", null, 1, msjOca);
				tablero[5] = new Casilla(6, "Puente", null, 1, msjPuente);
				tablero[6] = new Casilla(7, "Tortuga");
				tablero[7] = new Casilla(8, "Silla");
				tablero[8] = new Casilla(9, "Oca", null, 1, msjOca);
				tablero[9] = new Casilla(10, "Ratón");
				tablero[10] = new Casilla(11, "Rana");
				tablero[11] = new Casilla(12, "Puente", null, 1, msjPuente);
				tablero[12] = new Casilla(13, "Pollito");
				tablero[13] = new Casilla(14, "Oca", null, 1, msjOca);
				tablero[14] = new Casilla(15, "Helado");
				tablero[15] = new Casilla(16, "Oso");
				tablero[16] = new Casilla(17, "Bebé");
				tablero[17] = new Casilla(18, "Oca", null, 1, msjOca);
				tablero[18] = new Casilla(19, "Túnel");
				tablero[19] = new Casilla(20, "Cohete");
				tablero[20] = new Casilla(21, "Árbol de navidad");
				tablero[21] = new Casilla(22, "Casa");
				tablero[22] = new Casilla(23, "Oca", null, 1, msjOca);
				tablero[23] = new Casilla(24, "Ramo de flores");
				tablero[24] = new Casilla(25, "León");
				tablero[25] = new Casilla(26, "Dados", null, 1, msjDado);
				tablero[26] = new Casilla(27, "Oca", null, 1, msjOca);
				tablero[27] = new Casilla(28, "Bicicleta");
				tablero[28] = new Casilla(29, "Delfín");
				tablero[29] = new Casilla(30, "Dragón");
				tablero[30] = new Casilla(31, "Pozo", null, -3, "");
				tablero[31] = new Casilla(32, "Oca", null, 1, msjOca);
				tablero[32] = new Casilla(33, "Mariposa");
				tablero[33] = new Casilla(34, "Moto");
				tablero[34] = new Casilla(35, "Osito");
				tablero[35] = new Casilla(36, "Oca", null, 1, msjOca);
				tablero[36] = new Casilla(37, "Elefante");
				tablero[37] = new Casilla(38, "Bambi");
				tablero[38] = new Casilla(39, "Conejito");
				tablero[39] = new Casilla(40, "Cesta de fresas");
				tablero[40] = new Casilla(41, "Oca", null, 1, msjOca);
				tablero[41] = new Casilla(42, "Laberinto");
				tablero[42] = new Casilla(43, "Caballo");
				tablero[43] = new Casilla(44, "Paraguas");
				tablero[44] = new Casilla(45, "Oca", null, 1, msjOca);
				tablero[45] = new Casilla(46, "Conejito");
				tablero[46] = new Casilla(47, "Muñeco de nieve");
				tablero[47] = new Casilla(48, "Mariposa");
				tablero[48] = new Casilla(49, "Tren");
				tablero[49] = new Casilla(50, "Oca", null, 1, msjOca);
				tablero[50] = new Casilla(51, "Búho");
				tablero[51] = new Casilla(52, "Cárcel", null, -2, "");
				tablero[52] = new Casilla(53, "Dados", null, 1, msjDado);
				tablero[53] = new Casilla(54, "Oca", null, 1, msjOca);
				tablero[54] = new Casilla(55, "Gorrión");
				tablero[55] = new Casilla(56, "Tiburón");
				tablero[56] = new Casilla(57, "Perro");
				tablero[57] = new Casilla(58, "Muerte", null, 0, "Has muerto");
				tablero[58] = new Casilla(59, "Oca", null, 1, msjOca);
				tablero[59] = new Casilla(60, "Mariposas");
				tablero[60] = new Casilla(61, "Gato");
				tablero[61] = new Casilla(62, "Regadera");
				tablero[62] = new Casilla(63, "Meta");
				
				// Destinos de las casillas especiales
				tablero[4].setDestino(tablero[8]); // Oca
				tablero[5].setDestino(tablero[11]); // Puente
				tablero[11].setDestino(tablero[5]); // Puente
				tablero[8].setDestino(tablero[13]);// Oca
				tablero[13].setDestino(tablero[17]);// Oca
				tablero[17].setDestino(tablero[22]);// Oca
				tablero[22].setDestino(tablero[26]);// Oca
				tablero[25].setDestino(tablero[52]);// Dado
				tablero[52].setDestino(tablero[25]);// Dado
				tablero[26].setDestino(tablero[31]);// Oca
				tablero[31].setDestino(tablero[35]);// Oca 
				tablero[35].setDestino(tablero[40]);// Oca 
				tablero[40].setDestino(tablero[44]);// Oca 
				tablero[41].setDestino(tablero[29]);// Laberinto 
				tablero[44].setDestino(tablero[49]);// Oca 
				tablero[49].setDestino(tablero[53]);// Oca 
				tablero[53].setDestino(tablero[58]);// Oca 
				tablero[57].setDestino(tablero[0]);// Muerte 
				tablero[58].setDestino(tablero[62]);// Oca 
	}

	/**
	 * @return the tablero
	 */
	public Casilla[] getTablero() {
		return tablero;
	}

	/**
	 * @param tablero the tablero to set
	 */
	public void setTablero(Casilla[] tablero) {
		this.tablero = tablero;
	}
	
}
	
