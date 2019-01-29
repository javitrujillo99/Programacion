package JuegoArkanoid;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Arkanoid extends Canvas implements Stage {
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
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				nave.keyPressed(e);
			}
			public void keyReleased(KeyEvent e) {
				nave.keyReleased(e);
			}
		});
		this.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved (MouseEvent e) {
				nave.mouseMoved(e);
			}
		});
		
		ventana.setResizable(false);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		requestFocus();
	}
	
	/**
	 * 
	 */
	public void initWorld() {
      Pelota p = new Pelota(this);
      	p.setX(60);
	    p.setVx(2);
	    p.setY(40);
	    p.setVy(2);
	    objetos.add(p);
	    
	   for (int i = 0; i < 6; i++){
		   for (int j = 0; j < 21; j++) {
			   if (i == 0) {
				   ladrilloDeColor("azul", i, j);
			   }
			   if (i == 1) {
				   ladrilloDeColor("verde", i, j);
			   }
			   if (i == 2) {
				   ladrilloDeColor("amarillo", i, j);
			   }
			   if (i == 3) {
				   ladrilloDeColor("rojo", i, j);
			   }
			   if (i == 4) {
				  ladrilloDeColor("rosa", i, j);
			   }
			   if (i == 5) {
				  ladrilloDeColor("azulito", i, j);
			   }
		   }
	   }
	   
	   	nave = new Nave(this);
	    nave.setX(Stage.WIDTH/2);
	    nave.setY(Stage.HEIGHT - 2*nave.getHeight() - 30);
	    objetos.add(nave);
    }
	
	/**
	 * 
	 */
	public void updateWorld() {
		for (int i = 0; i < objetos.size(); i++) {
			Objeto p = (Objeto)objetos.get(i);
			p.act();
		}
		nave.act();
	}
	
	/**
	 * 
	 * @param color
	 * @param i
	 * @param j
	 */
	public void ladrilloDeColor (String color, int i, int j) {
		Ladrillo l = new Ladrillo(this, color);
		l.setX(30 * j);
		l.setY(i * 20 + 30);
		objetos.add(l);
	}
	
	/**
	 * 
	 */
	public void paintWorld() {
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		//g.setColor(Color.black);
		g.drawImage(spriteCache.getSprite("fondo.png"), 0, 0, this);
		for (int i = 0; i < objetos.size(); i++) {
			Objeto p = (Objeto)objetos.get(i);
			if (p.markedForRemoval != true) {
				p.paint(g);
			}		
		}
		
		g.setColor(Color.white);
		if (usedTime > 0)
		  g.drawString(String.valueOf(1000/usedTime)+" fps",0,Stage.HEIGHT-50);
  	else
	  	g.drawString("--- fps",0,Stage.HEIGHT-50);
		strategy.show();
	}
	
	
	/**
	 * 
	 */
	public SpriteCache getSpriteCache() {
		return spriteCache;
	}
	
	/**
	 * 
	 */
	public void checkCollisions() {
		Rectangle naveBounds = nave.getBounds();
		for (int i = 0; i < objetos.size(); i++) {
			Objeto a1 = (Objeto)objetos.get(i);
			Rectangle r1 = a1.getBounds();
			if (r1.intersects(naveBounds)) {
				nave.collision(a1);
				a1.collision(nave);
			}
		  for (int j = i+1; j < objetos.size(); j++) {
		  	Objeto a2 = (Objeto)objetos.get(j);
		  	Rectangle r2 = a2.getBounds();
		  	if (r1.intersects(r2)) {
		  		a1.collision(a2);
		  		a2.collision(a1);
		  	}
		  }
		}
	}
	
	/**
	 * 
	 */
	public void game() {
		usedTime=1000;
		initWorld();
		while (isVisible()) {
			long startTime = System.currentTimeMillis();
			updateWorld();
			checkCollisions();
			paintWorld();
			usedTime = System.currentTimeMillis()-startTime;
			try { 
				 Thread.sleep(SPEED);
			} catch (InterruptedException e) {}
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Arkanoid ark = new Arkanoid();
		ark.game();
	}
}
