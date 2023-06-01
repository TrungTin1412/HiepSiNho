package entity;

import java.awt.AlphaComposite;
// import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

public class Player extends Entity{
	
    GamePanel gp;
    KeyHandler keyH;
    
    public Player(GamePanel gp, KeyHandler keyH){
    	super(gp);
        this.gp = gp;
        this.keyH = keyH;

        life = 6;
        maxLife = 6;
        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 48;
        solidArea.height = 48;

        setDefaultValues();
        getPlayerImage();
    }
    
    public void pickUpObject(int i) {
		if (i != 999) {
		}
	}
    
    public void setDefaultValues(){
        x = 288;
        y = 690;
        speed = 20;
        direction = "up";

        maxLife = 6;
        life = maxLife;
    }
    public void setDefaultPositions(){
        x = gp.tileSize * 13;
        y = gp.tileSize * 21;
        direction = "up";
    }
    public void restoreLifeAndMan(){
        life = maxLife;
        invincible = false;
    }
    public void getPlayerImage(){
        up1 = setup("HiepSiNhoAttackFinal1");
        up2 = setup("HiepSiNhoAttackFinal1");
        down1 = setup("HiepSiNho3.0");
        down2 = setup("HiepSiNhoAttackFinal1");
        left1 = setup("HiepSiNhoAttackFinal3");
        left2 = setup("HiepSiNhoAttackFinal3");
        right1 = setup("HiepSiNhoAttackFinal2");
        right2 = setup("HiepSiNhoAttackFinal2");
    }

    public BufferedImage setup(String imageName){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/"+ imageName +".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }
    
    public void update(){
        int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
        contactMonster(monsterIndex);
        if(keyH.leftPressed == true) {
            direction = "left";
        } else if(keyH.rightPressed == true) {
            direction = "right";
        }else{
            direction = "up";
        }
        if (keyH.leftPressed == true|| keyH.rightPressed == true){

            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK MONSTER COLLISION


            if (collisionOn == false){
                switch(direction){
                    case "down":
                        y += speed; 
                        break;
                    case "left":
                        x -= speed; 
                        break;
                    case "right":
                        x += speed; 
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 10){
                if (spriteNum == 1){
                    spriteNum = 2;
                }
                else if (spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        if(invincible == true) {
            invincibleCounter++;
            if(invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
        if(life <= 0){
          gp.gameState = gp.gameOverState;  
        }
    }
    public void contactMonster(int i) {
        if(i != 999)  {
            // if(invincible == false) {
            //     life -= 1;
            //     invincible = true;
            // }
            gp.monster[i].dying = true;
        }
    }
    public void damgeMonster(int i) {
        if(i != 999) {
            if(gp.monster[i].invincible == false) {

            // gp.playerSE(5);
                gp.monster[i].life -= 1;
                gp.monster[i].invincible = true;
                gp.monster[i].damageReaction();

                if(gp.monster[i].life <= 0) {
                    gp.monster[i].dying = true;
                }
            }
        }
    }
    public void draw(Graphics2D g2){
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;
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
        if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
            
        }
        g2.drawImage(image, x, y, null);
        //Reset Alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1F));

    }
}
