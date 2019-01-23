package EjerciciosRafa.JuegoElAhorcado;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

	public class Ventana extends Canvas {

	// Declaración de variables que nos permitirán introducir el ancho y el alto
	// de la ventana
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static Ventana ventana;
	private int fallos = 0;
	
	public Ventana () {
		// La clase JFrame nos permite mostrar una ventana en pantalla
		JFrame ventana = new JFrame("Ahorcado");
		// Establecemos las dimensiones que queremos que tenga
		ventana.setBounds(0,0,WIDTH,HEIGHT);
		
		// Obtengo una referencia al panel principal de la ventana.
		// Todas las ventanas tienen un panel principal	
		JPanel panel = (JPanel)ventana.getContentPane();

		// Al panel principal de la ventana le añadimos el objeto this, un Canvas
		panel.add(this);

		// Establezco el tamaño del canvas (this) para que ocupe todo el tamaño de la ventana
		this.setBounds(0,0,WIDTH,HEIGHT);
		
		// Provocamos que el programa se acabe cuando cerramos la ventana 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Hacemos visible la ventana.
		ventana.setVisible(true);
		// Evitamos que la ventana pueda redimensionarse.
		ventana.setResizable(false);
	}
	
	
	
	/**
	 * Sobrescribimos el método "paint" que tienen todos los componentes gráficos en AWT-SWING
	 */
	@Override
	public void paint(Graphics g) {
		// Pintamos la imagen del tablero sobre la pantalla
		g.drawImage(getImagen("lamasbuena.png"), 0, 0, this);
		
		// Pintando un óvalo relleno
		g.setColor(Color.orange);
		g.fillOval(322, 165, 60, 60);
		
		g.setColor(Color.orange);
		g.fillRect(332, 228, 40, 100);
		
		g.setColor(Color.orange);
		g.fillRect(374, 228, 10, 70);
		
		g.setColor(Color.orange);
		g.fillRect(320, 228, 10, 70);
		
		g.setColor(Color.orange);
		g.fillRect(333, 331, 15, 75);
		
		g.setColor(Color.orange);
		g.fillRect(355, 331, 15, 75);
		
		g.setColor(Color.black);
		g.fillRect(342, 224, 20, 4);
		
		for (int i = 0; i < Juego.getJuego().getPalabraGenerada().length(); i++) {
			Juego.getJuego().getLetras();
		}
		String palabra = "";
		for (int i = 0; i < Juego.getJuego().getPalabraGenerada().length(); i++) {
			palabra += Juego.getJuego().getLetras()[i] + " ";
		}
		g.setFont(new Font("Arial", Font.BOLD, 14));
		g.drawString("Palabra: " + palabra, 35, 95);
		
		String letrasUsadas = "";
		for (int i = 0; i < Juego.getJuego().getAux().length; i++) {
			letrasUsadas += Juego.getJuego().getAux()[i] + " ";
		}
		g.setFont(new Font("Arial", Font.BOLD, 14));
		g.drawString("Fallos: " + letrasUsadas, 35, 130);
		
		fallos = Juego.getJuego().getFallos();
		if (fallos > 0) {
			g.setColor(Color.red);
			g.fillRect(333, 331, 15, 75);
		}
		
		if (fallos > 1) {
			g.setColor(Color.red);
			g.fillRect(355, 331, 15, 75);
		}
		
		if (fallos > 2) {
			g.setColor(Color.red);
			g.fillRect(320, 228, 10, 70);
		}
		
		if (fallos > 3) {
			g.setColor(Color.red);
			g.fillRect(374, 228, 10, 70);
		}
		
		if (fallos > 4 ) {
			g.setColor(Color.red);
			g.fillRect(332, 228, 40, 100);
		}
		
		if (fallos > 5) {
			g.setFont(new Font("Arial", Font.BOLD, 16));
			g.setColor(Color.red);
			g.fillOval(322, 165, 60, 60);
			g.drawString("\nHAS PERDIDO" , 35, 155);
			
		}
		
		if (Juego.victoria()) {
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.setColor(Color.blue);
			g.drawString("\nHAS GANADO, ENHORABUENA!!!" , 35, 155);
		}
		
	}



	public static Ventana getVentana() {
		if (ventana == null) {
			ventana = new Ventana();
		}
		return ventana;
	}



	public static void setVentana(Ventana ventana) {
		Ventana.ventana = ventana;
	}
	
	public BufferedImage getImagen(String nombre) {
		URL url=null;
		try {
			url = getClass().getResource("/EjerciciosRafa/JuegoElAhorcado/Recursos/" + nombre);
			return ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}
	
}
