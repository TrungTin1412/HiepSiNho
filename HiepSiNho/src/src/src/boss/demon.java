package boss;
import java.util.Random;

import entity.Entity;
import main.GamePanel;
public class demon extends Entity {
	public demon (GamePanel gp) {
		super(gp);
		name ="demon"
		speed=1;
		maxLife=20;
		life = maxLife;
		
		solidArea.x=
		solidArea.y=
		solidArea.width=
		solidArea.height=
		solidAreaDefaultX=solidArea.x;
		solidAreaDefailtY=solidArea.y;
		
		getImage();
	}
	public void getImage() {
		up1 = setup("boss/demon_down1");
		up1 = setup("boss/demon_down2");
		down1 = setup("boss/demon_down1");
		down1 = setup("boss/demon_down2");
		left1 = setup("boss/demon_down1");
		left1 = setup("boss/demon_down2");
		right1 = setup("boss/demon_down1");
		right1 = setup("boss/demon_down2");
	}
	public void setAction() {
		actionLockCounter ++;
		if (actionLockCounter ==120 ) {
			Random random = new Random ();
			int i = random.nextInt(100) +1;
			if (i<=25) {
				direction ="up";
			} if (i> 25 && i<=50) {
				direction ="down";
			} if (i> 50 && i<=75) {
				direction ="left";
			} if (i> 75 && i<=100) {
				direction ="right";
			}
			actionLockCounter =0;
		}
	}
}