package JuegoArkanoid;

public class Explosion extends Objeto{

	public Explosion(Stage stage) {
		super(stage);
	
	setSpriteNames(new String[] {"exp1.png" , "exp2.png" ,"exp3.png" ,"exp4.png" ,"exp5.png" ,"exp6.png" ,
			"exp7.png" ,"exp8.png" ,"exp9.png" ,"exp10.png", "exp11.png"});
	setFrameSpeed(3);
	}
	
	public void act() {
		super.act();
		if(currentFrame == getSpriteNames().length - 1) {
			remove();
		}
	}
}
