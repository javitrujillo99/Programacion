package JuegoArkanoid;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Objeto {
	protected int x;
	protected int y;
	protected int width, height;
	protected String[] spriteNames;
	protected int t;
	protected int frameSpeed;
	protected int currentFrame;
	protected Stage stage;
	protected SpriteCache spriteCache;
	protected boolean markedForRemoval = false;
	protected String spriteActual;
	
	public Objeto(Stage stage) {
		this.stage = stage;
		spriteCache = stage.getSpriteCache();
		currentFrame = 0;
		frameSpeed = 1;
		t=0;
	}
	public void remove() {
		markedForRemoval = true;
	}
	
	public boolean isMarkedForRemoval() {
		return markedForRemoval;
	}
	
	
	
	public void paint(Graphics2D g){
		g.drawImage( spriteCache.getSprite(spriteNames[currentFrame]), x,y, stage );
	}
	
	public int getX()  { return x; }
	public void setX(int i) {	x = i; }

	public int getY() {	return y; }
	public void setY(int i) { y = i; }
	
	public String[] getSpriteNames() {	return spriteNames; }
	public void setSpriteNames(String[] names) { 
		spriteNames = names;
		for (int i = 0; i < names.length; i++ ) {
	  		BufferedImage image = spriteCache.getSprite(spriteNames[i]);
		  	height = Math.max(height,image.getHeight());
			width = Math.max(width,image.getWidth());
		}
	}
	
	public void setFrameSpeed(int i) {frameSpeed = i;	}
	
	public int getHeight() { return height; }
	public int getWidth() {	return width;	}
	public void setHeight(int i) {height = i;	}
	public void setWidth(int i) {	width = i;	}

	public void act() {
		t++;
		if (t % frameSpeed == 0) {
			t=0;
			currentFrame = (currentFrame + 1) % spriteNames.length;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}
	
	public void collision(Objeto o){

	}
}
