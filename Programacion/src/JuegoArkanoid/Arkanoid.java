package JuegoArkanoid;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	private int puntuacion;
	private SpriteCache spriteCache = new SpriteCache();
	private SoundCache soundCache;
	private List<Objeto> objetos = new ArrayList<Objeto>();
	private Nave nave;
	private Pelota pelota = new Pelota(this);
	private List<Explosion> explosion = new ArrayList<Explosion>();
	private int contadorFases = 0;
	private static int contLadrillos = 0;
	private Ladrillo ladrillo;
	private int contadorVidas = 3;
	private VidaExtra vida;
	private PildoraNave pildoraNave;
	private PildoraVelocidad pildoraVelocidad;
	//Singleton
	private static Arkanoid instancia = null;
	
	/**
	 * Getter Singleton
	 * @return
	 */
	public static Arkanoid getInstancia () {
		if (instancia == null) {
			instancia = new Arkanoid();
		}
		return instancia;
	}
	
	public Arkanoid() {
		spriteCache = new SpriteCache();
		soundCache = new SoundCache();

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
		
		
		ventana.setResizable(false);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		requestFocus();
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				nave.keyPressed(e);
				pelota.keyPressed(e);
			}
			public void keyReleased(KeyEvent e) {
				nave.keyReleased(e);
			}
		});
		this.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved (MouseEvent e) {
				nave.mouseMoved(e);
				pelota.mouseMoved(e);
			}
		});
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked (MouseEvent e) {
				pelota.mouseClicked(e);
			}
		});
	}
	
	

	/**
	 * 
	 */
	public void fasePrueba() {
		int fase[][] = new int[][] {
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},		
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		};
		for (int i = 0; i < fase.length; i++) {
			   for (int j = 0; j < fase[i].length; j++) {
				   if (fase[i][j] == 1) {
					   ladrillo = new Ladrillo(this,i);
					   ladrillo.setX(30 * j);
					   ladrillo.setY(i * 20 + 30);
					   objetos.add(ladrillo);
					   setContLadrillos(getContLadrillos() + 1);
				   }
				   if (fase[i][j] == 2) {
	 				   LadrilloPlateado lp = new LadrilloPlateado(this,i);
					   lp.setX(30 * j);
					   lp.setY(i * 20 + 30);
					   objetos.add(lp);
					   setContLadrillos(getContLadrillos() + 1);
					   }
				   if (fase[i][j] == 3) {
	 				   LadrilloDorado ld = new LadrilloDorado(this,i);
					   ld.setX(30 * j);
					   ld.setY(i * 20 + 30);
					   objetos.add(ld);
					   setContLadrillos(getContLadrillos() + 1);
					   }
			   }
			}
		 }	
	
	/**
	 * 
	 */
	public void fase01() {
		int fase[][] = new int[][] {
				{0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0},		
				{0,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,0,0},
				{0,0,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,0},
				{0,0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,0},
				{0,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0},
				{0,0,0,0,0,0,1,1,1,1,0,0,1,1,1,0,0,0,0,0,0}
		};
		for (int i = 0; i < fase.length; i++) {
			   for (int j = 0; j < fase[i].length; j++) {
				   if (fase[i][j] == 1) {
					   ladrillo = new Ladrillo(this,i);
					   ladrillo.setX(30 * j);
					   ladrillo.setY(i * 20 + 30);
					   objetos.add(ladrillo);
					   setContLadrillos(getContLadrillos() + 1);
				   }
				   if (fase[i][j] == 2) {
	 				   LadrilloPlateado lp = new LadrilloPlateado(this,i);
					   lp.setX(30 * j);
					   lp.setY(i * 20 + 30);
					   objetos.add(lp);
					   setContLadrillos(getContLadrillos() + 1);
					   }
				   if (fase[i][j] == 3) {
	 				   LadrilloDorado ld = new LadrilloDorado(this,i);
					   ld.setX(30 * j);
					   ld.setY(i * 20 + 30);
					   objetos.add(ld);
					   setContLadrillos(getContLadrillos() + 1);
					   }
			   }
		   }
		}
	
	
	public void selectorFases (int num) {
		if (num == 0) {
			fase01();
		}
		if (num == 1) {
			fase02();
		}
	}



	/**
	 * 
	 */
	
	
	public void fase02() {
		int fase[][] = new int[][] {
			{0,0,0,0,0,0,0,0,0,3,3,3,0,0,0,0,0,0,0,0,0},		
			{0,0,0,0,0,0,0,0,3,2,1,2,3,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,3,2,1,1,1,2,3,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,3,2,1,1,1,1,1,2,3,0,0,0,0,0,0},
			{0,0,0,0,0,3,2,1,1,1,1,1,1,1,2,3,0,0,0,0,0},
			{0,0,0,0,3,2,1,1,1,1,1,1,1,1,1,2,3,0,0,0,0},
		};
		for (int i = 0; i < fase.length; i++) {
			   for (int j = 0; j < fase[i].length; j++) {
				   if (fase[i][j] == 1) {
	 				   ladrillo = new Ladrillo(this,i);
					   ladrillo.setX(30 * j);
					   ladrillo.setY(i * 20 + 30);
					   objetos.add(ladrillo);
					   setContLadrillos(getContLadrillos() + 1);
				   }
				   if (fase[i][j] == 2) {
	 				   LadrilloPlateado lp = new LadrilloPlateado(this,i);
					   lp.setX(30 * j);
					   lp.setY(i * 20 + 30);
					   objetos.add(lp);
					   setContLadrillos(getContLadrillos() + 1);
					   }
				   if (fase[i][j] == 3) {
	 				   LadrilloDorado ld = new LadrilloDorado(this,i);
					   ld.setX(30 * j);
					   ld.setY(i * 20 + 30);
					   objetos.add(ld);
					   setContLadrillos(getContLadrillos() + 1);
					   }
			   }
			}
	}
	
	/**
	 * 
	 */
	public void initWorld() {
		soundCache.playSound("Arkanoid-start-of-stage.wav");
	    objetos.add(pelota);
	    selectorFases(contadorFases);
	 	nave = new Nave(this);
	    nave.setX(253);
	    nave.setY(415);
	    objetos.add(nave);
    }
	
	/**
	 * 
	 */
	public void updateWorld() {
		
		if (pelota.getVx() == 0 && pelota.getVy() == 0) {
			pelota.setX(nave.getX() + 26);
			pelota.setY(nave.getY() - 15);
		}
		
		for (int i = 0; i < objetos.size(); i++) {
			Objeto p = (Objeto)objetos.get(i);
			p.act();
		}
		int i = 0;
		int numAzar = (int)Math.round(Math.random() * 3);
		while (i < objetos.size()) {
			Objeto m = (Objeto)objetos.get(i);
			if (m.markedForRemoval) {
				if (!(m instanceof VidaExtra) && !(m instanceof PildoraNave) && !(m instanceof PildoraVelocidad)) {
					Explosion ex = new Explosion(this);
					ex.setX(m.getX());
					ex.setY(m.getY());
					explosion.add(ex);
				}
				if (m instanceof Ladrillo) {
					if (numAzar == 1) { 
						vida = new VidaExtra(this);
						vida.setX(pelota.getX());
						vida.setY(pelota.getY());
						objetos.add(vida);
					}
					if (numAzar == 2) {
						pildoraNave = new PildoraNave(this);
						pildoraNave.setX(pelota.getX());
						pildoraNave.setY(pelota.getY());
						objetos.add(pildoraNave);
					}
					if (numAzar == 3) {
						pildoraVelocidad = new PildoraVelocidad(this);
						pildoraVelocidad.setX(pelota.getX());
						pildoraVelocidad.setY(pelota.getY());
						objetos.add(pildoraVelocidad);
					}
				}
				objetos.remove(i);
				soundCache.playSound("Explosion.wav");
			} else {
				i++;
			}
		}
		for (i = 0; i < objetos.size(); i++) {
			Objeto m = (Objeto)objetos.get(i);
			if (m.markedForRemoval) {
				explosion.remove(i);
			}
			else {
				i++;
			}
		}
		for (i = 0; i < explosion.size(); i++) {
			Objeto m = (Objeto) explosion.get(i);
			m.act();
		}
		nave.act();
		if (pelota.markedForRemoval) {
			pelota = new Pelota(this);
			this.objetos.add(pelota);
			contadorVidas--;
		}
		
		if (contadorVidas == 0) {
			this.objetos.clear();
		}
	}
	
	/**
	 * 
	 * @param color
	 * @param i
	 * @param j
	 */

	
	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public Pelota getPelota() {
		return pelota;
	}

	public void setPelota(Pelota pelota) {
		this.pelota = pelota;
	}

	public int getContadorVidas() {
		return contadorVidas;
	}

	public void setContadorVidas(int contadorVidas) {
		this.contadorVidas = contadorVidas;
	}
	
	

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
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
		
		if (contadorVidas == 7) {
			g.setFont(new Font("Console", Font.BOLD, 18));
			g.setColor(Color.red);
			g.drawString("7♥", 560, 430);
			}
		
		if (contadorVidas == 6) {
			g.setFont(new Font("Console", Font.BOLD, 18));
			g.setColor(Color.red);
			g.drawString("6♥", 560, 430);
			}
		
		if (contadorVidas == 5) {
			g.setFont(new Font("Console", Font.BOLD, 18));
			g.setColor(Color.red);
			g.drawString("5♥", 560, 430);
			}
		
		if (contadorVidas == 4) {
			g.setFont(new Font("Console", Font.BOLD, 18));
			g.setColor(Color.red);
			g.drawString("4♥", 560, 430);
			}
		
		if (contadorVidas == 3) {
			g.setFont(new Font("Console", Font.BOLD, 18));
			g.setColor(Color.red);
			g.drawString("3♥", 560, 430);
			}
		
		if (contadorVidas == 2) {
			g.setFont(new Font("Console", Font.BOLD, 18));
			g.setColor(Color.red);
			g.drawString("2♥", 560, 430);
			}
		
		if (contadorVidas == 1) {
			g.setFont(new Font("Console", Font.BOLD, 18));
			g.setColor(Color.red);
			g.drawString("1♥", 560, 430);
			}
		
		if (contadorVidas == 0) {
			g.drawImage(spriteCache.getSprite("game-over-games_3.png"), 0, 0, this);
			objetos.clear();
		}
		
		g.drawString("Puntuacion: " + puntuacion , 10, 430);
		
		for (Explosion explosion : explosion) {
			if (explosion.markedForRemoval == false) {
				explosion.paint(g);
			}
		}
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
		for (int i = 0; i < objetos.size(); i++) {
			Objeto a1 = (Objeto)objetos.get(i);
			Rectangle r1 = a1.getBounds();

		  for (int j = i+1; j < objetos.size(); j++) {
		  	Objeto a2 = (Objeto)objetos.get(j);
		  	Rectangle r2 = a2.getBounds();
		  	if (r1.intersects(r2)) {
		  		a1.collision(a2);
		  		a2.collision(a1);
		  		if (a1 == pelota && a2 == nave) {
			  		soundCache.playSound("Arkanoid-SFX-04.wav");
			  	}
		  	}
		  }
		}
	}
	
	/**
	 * 
	 */
	public void game() {
		usedTime = 1000;
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
			if (contLadrillos == 0) {
				contadorFases++;
				objetos.clear();
				pelota = new Pelota(this);
				initWorld();			
				}
		}
	}
	
	
	
	
	public static int getContLadrillos() {
		return contLadrillos;
	}

	public static void setContLadrillos(int contLadrillos) {
		Arkanoid.contLadrillos = contLadrillos;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
 		Arkanoid ark = new Arkanoid();
 		Listener listener = new Listener();
		ark.getInstancia().game();
	}


	
}
