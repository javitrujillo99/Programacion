package JuegoArkanoid;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Arkanoid extends Canvas implements Stage, KeyListener {

	private BufferStrategy strategy;
	private long usedTime;
	
	private SpriteCache spriteCache;
	private List<Objeto> objetos = new ArrayList<Objeto>();
	private Nave nave;
	
	public Arkanoid() {
		spriteCache = new SpriteCache();

		JFrame ventana = new JFrame("Arkanoid");
		JPanel panel = (JPanel)ventana.getContentPane();
		setBounds(0,0,Stage.WIDTH,Stage.HEIGHT);
		panel.setPreferredSize(new Dimension(Stage.WIDTH,Stage.HEIGHT));
		panel.setLayout(null);
		panel.add(this);
		ventana.setBounds(0,0,Stage.WIDTH,Stage.HEIGHT);
		ventana.setVisible(true);
		ventana.addWindowListener( new WindowAdapter() {
			
		
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		ventana.setResizable(false);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		requestFocus();
		addKeyListener(this);
	}
	
	public void initWorld() {
	  
      Pelota p = new Pelota(this);
      	p.setX(60);
	    p.setVx(2);
	    p.setY(40);
	    p.setVy(2);
	    objetos.add(p);
	    
	   for (int i = 0; i < 6; i++){
		   for (int j = 0; j < 21; j++) {
		   Ladrillo l = new Ladrillo(this);
		   l.setColor(Color.RED);
		   l.setX(30 * j);
		   l.setY(i * 20 + 30);
		   objetos.add(l);
		   }
	   }
      	
	   	nave = new Nave(this);
	    nave.setX(Stage.WIDTH/2);
	    nave.setY(Stage.HEIGHT - 2*nave.getHeight() - 30);
	    objetos.add(nave);
    }
	
	public void updateWorld() {
		for (int i = 0; i < objetos.size(); i++) {
			Objeto p = (Objeto)objetos.get(i);
			p.act();
		}
		nave.act();
	}
	
	public void paintWorld() {
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		Dimension tamanioImagen = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("../recursos/fondo.png"));
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanioImagen.width, tamanioImagen.height, null);
		g.fillRect(0,0,getWidth(),getHeight());
		for (int i = 0; i < objetos.size(); i++) {
			Objeto p = (Objeto)objetos.get(i);
			p.paint(g);
		}

		g.setColor(Color.white);
		if (usedTime > 0)
		  g.drawString(String.valueOf(1000/usedTime)+" fps",0,Stage.HEIGHT-50);
  	else
	  	g.drawString("--- fps",0,Stage.HEIGHT-50);
		strategy.show();
	}
	
	public SpriteCache getSpriteCache() {
		return spriteCache;
	}
	
	public void keyPressed(KeyEvent e) {
		nave.keyPressed(e);		
	}

	public void keyReleased(KeyEvent e) {
		nave.keyReleased(e);
	}

	public void keyTyped(KeyEvent e) {}
	
	public void game() {
		usedTime=1000;
		initWorld();
		while (isVisible()) {
			long startTime = System.currentTimeMillis();
			updateWorld();
			paintWorld();
			usedTime = System.currentTimeMillis()-startTime;
			try { 
				 Thread.sleep(SPEED);
			} catch (InterruptedException e) {}
		}
	}
	
	public static void main(String[] args) {
		Arkanoid ark = new Arkanoid();
		ark.game();
	}

	
	
}
