package JuegoArkanoid;

import java.awt.event.KeyEvent;

public class Nave extends Objeto {
	protected static final int NAVE_SPEED = 4;
	protected int vx;
	protected int vy;
	private boolean up,down,left,right;
	
	public Nave(Stage stage) {
		super(stage);
		setSpriteName("pastillaBuena1.png");
	}
	
	public void act() {
		super.act();
		x+=vx;
		y+=vy;
		if (x < 0 || x > Stage.WIDTH)
		  vx = -vx;
		if (y < 0 || y > Stage.HEIGHT)
		  vy = -vy;
	}

	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
 	public int getVy() { return vy; }
 	public void setVy(int i) {vy = i;	}
 	
 	protected void updateSpeed() {
 	  	vx=0;vy=0;
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
 	
}
