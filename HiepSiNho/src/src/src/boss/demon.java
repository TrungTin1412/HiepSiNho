package boss;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
public class demon extends Entity {
	Gamepanel gp;
	public static final String monName=""
	public demon (GamePanel gp) {
		super(gp);
		this.gp=gp;
		
		type=type_monster;
		name ="demon" 
		defaultSpeed=1;
		speed=defaultSpeed;
		maxLife=50;
		life = maxLife;
		attack =1;
		defense =2;
		
		int size =gp.titleSize*5;
		solidArea.x=48;
		solidArea.y=48;
		solidArea.width= size - 48*2;
		solidArea.height= size - 48
		solidAreaDefaultX=solidArea.x;
		solidAreaDefailtY=solidArea.y;
		attackArea.width=30;
		attackArea.height=170;
		motion1_duration=25;
		motion2_duration=50;
		getImage();
		getAttackImage();
	}
	public void getImage() {
		int i=5;
		
		left1 = setup("boss/demon_left1",gp.titleSize*i,gp.titleSize*i);
		left2 = setup("boss/demon_left2",gp.titleSize*i,gp.titleSize*i);
		right1 = setup("boss/demon_right1",gp.titleSize*i,gp.titleSize*i);
		right2 = setup("boss/demon_right2",gp.titleSize*i,gp.titleSize*i);
		attackleft1 = setup("boss/demon-leftattack_1",gp.titleSize*i,gp.titleSize*i);
		attackleft2 = setup("boss/demon-leftattack_2",gp.titleSize*i,gp.titleSize*i);
		attackright1 = setup("boss/demon-rightattack_1",gp.titleSize*i,gp.titleSize*i);
		attackright2 = setup("boss/demon-rightattack_1",gp.titleSize*i,gp.titleSize*i);
	}
	public void setAction() {
		if (onPath ==true) {
			checkStopChasingOrNot(gp.player,15,100);
			searchPath(getGoalCol(gp.player),getGoalRow(gp.player));
		} else {
			checkStartChasingOrNot (gp.player,5,100);
		}
		if (attacking==false) {
			checkAttackOrNot(30,gp.titleSize*4),gp.titleSize);
		}
	}
	public void damageReaction () {
		actionLockCounter=0;
	}
	public void checkDrop() {
		
	}
}
