package JuegoArkanoid;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class Nave extends Objeto {
	protected static final float NAVE_SPEED = (float) 3.5;
	protected float vx;
	private boolean left,right;
	
	public Nave(Stage stage) {
		super(stage);
		setSpriteNames(new String[] {("nave.png")});
	}
	
	public void act() {
		super.act();
		x+=vx;
		if (x < 0 ) {
			x = 0;
		}
		if (x > Stage.WIDTH - getWidth()) {
			x = Stage.WIDTH - getWidth();
		}
	}

	public float getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	
 	protected void updateSpeed() {
 	  	vx=0;
 	  	if (left) vx = -NAVE_SPEED;
 	  	if (right) vx = NAVE_SPEED;
 	  }
 	  
 	  public void keyReleased(KeyEvent e) {
 	   	switch (e.getKeyCode()) {
 			  case KeyEvent.VK_LEFT : left = false; break; 
 			  case KeyEvent.VK_RIGHT : right = false;break;
 	   	}
 	   	updateSpeed();
 	  }
 	  
 	  public void keyPressed(KeyEvent e) {
 	  	switch (e.getKeyCode()) {
 			  case KeyEvent.VK_LEFT : left = true; break;
 			  case KeyEvent.VK_RIGHT : right = true; break;
 	  	}
 	  	updateSpeed();
 	  }
 	  
 	public void mouseMoved(MouseEvent e) {
 		this.x = e.getX() - (this.width / 2);
 	}
 	

}
