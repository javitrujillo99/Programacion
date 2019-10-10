package JuegoArkanoid;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class Pelota extends Objeto {
	protected float vx, vy;
	protected boolean isPulsado = false;
	private boolean left,right;
	private TrayectoriaRecta trayectoria = null;
	private PuntoAltaPrecision coordenadas = null;
	private float pixelsXFrame = 3;
	private long miliSec = System.currentTimeMillis();
	private long lugarInter;
	
	
	public Pelota(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {("Baloncesto.png")});
	}
	
	
	public void act() {
		long miliSecAct = System.currentTimeMillis();
		lugarInter = miliSecAct - miliSec;
		
		if (this.isPulsado || lugarInter > 5000) {
			if (this.trayectoria == null) {
				this.coordenadas = new PuntoAltaPrecision(x, y);
				this.trayectoria = new TrayectoriaRecta(-2.5f, coordenadas, true);
			}
			this.coordenadas = this.trayectoria.getPuntoADistanciaDePunto(this.coordenadas, pixelsXFrame);
			if (pixelsXFrame < 5) {
				pixelsXFrame *= 1.00035;
 			}
			this.x = Math.round(this.coordenadas.x);
			this.y = Math.round(this.coordenadas.y);
			if (x < 0 || x > (Stage.WIDTH - 18)) {
				this.trayectoria.reflejarHorizontalmenteRespectoAPunto(coordenadas);
			}
			if (y < 0 || y > (Stage.HEIGHT - 42)) {
				this.trayectoria.reflejarVerticalmenteRespectoAPunto(coordenadas);
			}
			if (y > (Stage.HEIGHT - 49)) {
				markedForRemoval = true;
			}
		}
	}
	
/*	public void resetearPelota() {
		this.pixelsXFrame = 3;
		this.isPulsado = false;
		this.lugarInter = 0;
		this.trayectoria = null;
		this.coordenadas = new PuntoAltaPrecision(x, y);
	}
	*/
	public void collision(Objeto o) {
		if (o instanceof Ladrillo) {
			colisionConLadrillo((Ladrillo) o);
			Arkanoid.getInstancia().setPuntuacion(Arkanoid.getInstancia().getPuntuacion() + 10);
		}
		
		if (o instanceof Nave) {
			colisionConNave((Nave) o);
		}
	}
	
	public void colisionConLadrillo(Ladrillo o) {
		int margenLateral = 4;
		// Creo pequeños rectángulos que coincidirán con los bordes del ladrillo
		Rectangle rectangleArriba = new Rectangle(o.getX(), o.getY(), o.getHeight(), 1);
		Rectangle rectangleAbajo = new Rectangle(o.getX(), o.getY() + o.getHeight()-1, o.getWidth(), 1);
		Rectangle rectangleIzquierda = new Rectangle(o.getX(), o.getY() + margenLateral, 1, o.getHeight() - 2 * margenLateral);
		Rectangle rectangleDerecha = new Rectangle(o.getX() + o.getWidth()-1, o.getY() + margenLateral, 1, o.getHeight() - 2 * margenLateral);
		boolean arriba = false, abajo = false, izquierda = false, derecha = false, arribaIzquierda = false,
				arribaDerecha = false, abajoIzquierda = false, abajoDerecha = false;
		if (o.getBounds().intersects(rectangleDerecha)) {
			derecha = true;
		}
		if (o.getBounds().intersects(rectangleIzquierda)) {
			izquierda = true;
		}
		if (o.getBounds().intersects(rectangleArriba)) {
			arriba = true;
		}
		if (o.getBounds().intersects(rectangleAbajo)) {
			abajo = true;
		}
		if (arriba && derecha) {
			arribaDerecha = true;
		}
		if (arriba && izquierda) {
			arribaIzquierda = true;
		}
		if (abajo && derecha) {
			abajoDerecha = true;
		}
		if (abajo && izquierda) {
			abajoIzquierda = true;
		}
		if (derecha) {
			this.trayectoria.reflejarHaciaDerecha(this.coordenadas);
		}
		if (izquierda) {
			this.trayectoria.reflejarHaciaIzquierda(this.coordenadas);
		}
		if (arriba) {
			this.trayectoria.reflejarHaciaArriba(this.coordenadas);
		}
		if (abajo) {
			this.trayectoria.reflejarHaciaAbajo(this.coordenadas);
		}
		if (arribaDerecha) {
			this.trayectoria.setPendiente(-this.trayectoria.getPendiente());
		}
		if (arribaIzquierda) {
			this.trayectoria.setPendiente(-this.trayectoria.getPendiente());
		}
		if (abajoDerecha) {
			this.trayectoria.setPendiente(-this.trayectoria.getPendiente());
		}
		if (abajoIzquierda) {
			this.trayectoria.setPendiente(-this.trayectoria.getPendiente());
		}
	}
	
	private void colisionConNave (Nave nave) {
		// Creo rectángulos para determinar la zona de la nave con la que choca la bola
		int anchoZonaEspecial = 7; // píxeles que delimitan la zona de rebote especial de la nave
		Rectangle rectIzqNave = new Rectangle(nave.getX(), nave.getY(), anchoZonaEspecial, nave.height);
		Rectangle rectDerNave = new Rectangle(nave.getX() + nave.width - anchoZonaEspecial, nave.getY(), anchoZonaEspecial, nave.height);
		Rectangle rectBola = this.getRectanguloParaColisiones();
		
		// Colisión con el lado derecho de la nave
		if (rectBola.intersects(rectDerNave)) {
			this.y = nave.getY() - nave.getHeight();
			this.coordenadas.y = this.y;
			if (Math.abs(this.trayectoria.getPendiente()) > 1 ) { // La bola viene on una pendiente mayor a 1
				this.trayectoria.setPendiente(-(float) (Math.random() * (0.8 - 0.3) + 0.3), this.coordenadas, true);
			}
			else { // La bola viene con una pendiente suave ( > 0 y < 1 )
				this.trayectoria.setPendiente(-(float) (Math.random() * (10 - 2) + 2), this.coordenadas, true);
			}
			return;
		}
		// Colisión con el lado izquierdo de la nave
		if (rectBola.intersects(rectIzqNave)) {
			this.y = nave.getY() - nave.getHeight();
			this.coordenadas.y = this.y;
			if (Math.abs(this.trayectoria.getPendiente()) > 1 ) { // La bola viene con una pendiente mayor a 1
				this.trayectoria.setPendiente((float) (Math.random() * (0.8 - 0.3) + 0.3), this.coordenadas, false);
			}
			else { // La bola viene con una pendiente suave ( > 0 y < 1 )
				this.trayectoria.setPendiente((float) (Math.random() * (10 - 2) + 2), this.coordenadas, false);
			}
			return;
		}
		else { // La bola intersecta la parte central de la nave
			this.trayectoria.reflejarHaciaArriba(this.coordenadas);
			return;
		}			
	}
	
	public Rectangle getRectanguloParaColisiones () {
		return new Rectangle(this.x + this.width / 2 - 4, this.y + this.height / 2 - 4, 8, 8);
	}
	
	public void keyPressed (KeyEvent e) {
		if (isPulsado == false && lugarInter < 5000) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_SPACE : isPulsado = true;
				vy = 3;
				vx = 3;
				break;
			}
		}
  }
	
	  public void mouseMoved(MouseEvent e) {
		  if (isPulsado == false && lugarInter < 5000)
			  this.x = (e.getX() - this.width/2);
	  	}
	  
	  public void mouseClicked(MouseEvent e) {
		  switch (e.getButton()) {
		  	case MouseEvent.BUTTON1 : isPulsado = true;
		  	vy = 3;
			vx = 3;
			break;
		  }
	  }
	  
	  
	  public float getPixelsXFrame() {
		return pixelsXFrame;
	}


	public void setPixelsXFrame(float pixelsXFrame) {
		this.pixelsXFrame = pixelsXFrame;
	}


	protected void updateSpeed() {
		  	if (left) vx = -Nave.NAVE_SPEED;
		  	if (right) vx = Nave.NAVE_SPEED;
		  }
	
	public float getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	public float getVy() { return vy; }
	public void setVy(int i) {vy = i;	}

}
