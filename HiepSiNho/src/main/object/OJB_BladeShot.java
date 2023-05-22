package object;


//Entity -> Projectile -> BladeShot


import entity.Projectile;
import main.GamePanel;

public class OJB_BladeShot extends Projectile{
	
	GamePanel gp;

	public OJB_BladeShot(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
	    name = "BladeShot";
		speed = 5; 
		maxLife = 80;
		life = maxLife;
		alive = false;
		getImage();	
	}
	
	public void getImage() {
		
	}

}
