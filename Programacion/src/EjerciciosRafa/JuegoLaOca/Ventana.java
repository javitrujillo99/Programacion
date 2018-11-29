package EjerciciosRafa.JuegoLaOca;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

// La clase extiende de Canvas, se trata de un lienzo sobre el cual podemos pintar
// libremente.
public class Ventana extends Canvas {

	// Declaración de variables que nos permitirán introducir el ancho y el alto
	// de la ventana
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;

	
	public Ventana () {
		// La clase JFrame nos permite mostrar una ventana en pantalla
		JFrame ventana = new JFrame("El juego de la Oca");
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
		// Establecimiento del color del pincel
		g.setColor(Color.blue);

		// Pintando una línea
		g.drawLine(0, 0, WIDTH, HEIGHT);
		
		// Pintando un cuadrado vacío
		g.setColor(Color.red);
		g.drawRect(120, 20, 100, 50);
		
		// Pintando un cuadrado
		g.setColor(Color.yellow);
		g.fillRect(80, 200, 140, 25);
		
		// Pintando un óvalo
		g.setColor(Color.green);
		g.drawOval(300, 130, 120, 90);
		
		// Pintando un óvalo relleno
		g.setColor(Color.pink);
		g.fillOval(300, 300, 120, 90);
		
	}

}
