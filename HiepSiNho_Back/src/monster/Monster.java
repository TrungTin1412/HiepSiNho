package monster;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.GamePanel;

public class Monster extends Entity {
    GamePanel gp;
    boolean getOver = false;
    public Monster(GamePanel gp){
        super(gp);
        this.gp = gp;
        type = 1;
        name = "Enemy";
        speed = 1;
        solidArea.x = 3;
        solidArea.y = 1;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        up1 = setup("/res/ooze left1");
        up2 = setup("/res/ooze left2");
        down1 = setup("/res/ooze right1");
        down2 = setup("/res/ooze right2");
        left1 = setup("/res/ooze left1");
        left2 = setup("/res/ooze left2");
        right1 = setup("/res/ooze right1");
        right2 = setup("/res/ooze right2");
        getImage();
    }
    public void getImage(){
        up1 = setup("/res/ooze left1");
        up2 = setup("/res/ooze left2");
        down1 = setup("/res/ooze right1");
        down2 = setup("/res/ooze right2");
        left1 = setup("/res/ooze left1");
        left2 = setup("/res/ooze left2");
        right1 = setup("/res/ooze right1");
        right2 = setup("/res/ooze right2");
    }
    public void damageReaction() {
        actionLockCounter = 0;
        direction = gp.player.direction;
    }
    
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = x;
        int screenY = y;

        switch (direction){
            case "up":
                if (spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                break;
            }
        
        if(!dying) {
            if (y > gp.player.y + gp.player.solidArea.y) {
                if (!getOver) {
                    gp.player.life -= 1;
                    gp.player.invincible = true;
                    getOver = true;
                }
                
            }
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        } else {
            // dyingAnimation(g2);
        }
    }

}
