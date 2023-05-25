package monster;

import java.util.Random;


import entity.Entity;
import main.GamePanel;

public class Monster extends Entity {
    public Monster(GamePanel gp) {
        super(gp);

        type = 2;
        name = "Enemy";
        speed = 1;
        maxLife = 4;
        life = maxLife;
        solidArea.x = 3;
        solidArea.y = 1;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();
    }
    public void getImage(){
        up1 = setup("/res/ooze_left1");
        up2 = setup("/res/ooze_left2");
        down1 = setup("/res/ooze_right1");
        down2 = setup("/res/ooze_right2");
        left1 = setup("/res/ooze_left1");
        left2 = setup("/res/ooze_left2");
        right1 = setup("/res/ooze_right1");
        right2 = setup("/res/ooze_right2");
    }
        
    public void setAction() {
        actionLockCounter++;
        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }
            actionLockCounter = 0;
        }
    }

    public void damageReaction() {
        actionLockCounter = 0;
        direction = gp.player.direction;
    }
}
