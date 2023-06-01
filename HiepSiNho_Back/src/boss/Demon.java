// package boss;

// import entity.Entity;
// import main.GamePanel;
// public class Demon extends Entity {
// 	GamePanel gp;
// 	public static final String monName="";
// 	public Demon (GamePanel gp) {
// 		super(gp);
// 		this.gp=gp;
		
// 		type = 2;
// 		name = "demon" ;
// 	    speed = 0;
// 		maxLife=50;
// 		life = maxLife;
// 		attack = 1;
// 		defense = 2;
		
// 		int size = gp.tileSize * 5;
// 		solidArea.x=48;
// 		solidArea.y=48;
// 		solidArea.width= size - 48 * 2;
// 		solidArea.height= size - 48;
// 		solidAreaDefaultX=solidArea.x;
// 		solidAreaDefaultY=solidArea.y;
// 		attackArea.width=30;
// 		attackArea.height = 170;
// 		motion1_duration = 25;
// 		motion2_duration = 50;
// 		getImage();
// 		getAttackImage();
// 	}
// 	public void getImage() {
// 		int i=5;
		
// 		left1 = setup("boss/demon_left1",gp.tileSize * i,gp.tileSize * i);
// 		left2 = setup("boss/demon_left2",gp.tileSize * i,gp.tileSize * i);
// 		right1 = setup("boss/demon_right1",gp.tileSize * i,gp.tileSize * i);
// 		right2 = setup("boss/demon_right2",gp.tileSize * i,gp.tileSize * i);
// 		attackLeft1 = setup("boss/demon-leftattack_1",gp.tileSize * i,gp.tileSize * i);
// 		attackLeft2 = setup("boss/demon-leftattack_2",gp.tileSize * i,gp.tileSize * i);
// 		attackRight1 = setup("boss/demon-rightattack_1",gp.tileSize * i,gp.tileSize * i);
// 		attackRight2 = setup("boss/demon-rightattack_1",gp.tileSize * i,gp.tileSize * i);
// 	}
// 	public void setAction() {
// 		if (onPath == true) {
// 			checkStopChasingOrNot(gp.player,15,100);
// 			searchPath(getGoalCol(gp.player),getGoalRow(gp.player));
// 		} else {
// 			checkStartChasingOrNot (gp.player,5,100);
// 		}
// 		if (attacking==false) {
// 			checkAttackOrNot(30,gp.tileSize * 4),gp.tileSize);
// 		}
// 	}
// 	public void damageReaction () {
// 		actionLockCounter=0;
// 	}
// 	public void checkDrop() {
		
// 	}
// }