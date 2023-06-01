package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
	
	public GamePanel gp;
	
	public int x, y;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction = "down"; // FIRST DIRECTION
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collision = false;
    public int actionLockCounter;
    public boolean invincible = false;
    public int invincibleCounter = 0;
    public BufferedImage image, image2, image3;
    public boolean collisionOn;
    public int type;// player = 0, monster = 1, boss = 2;
    public boolean alive = true;
    public boolean dying = false;
    int dyingCounter = 0;
    protected boolean hpBarOn = false;
    protected int hpBarCounter = 0;
    
    
    //CHARACTER ATTRIBUTES
    public String name;
    public int speed;
    public int life;
    public int maxLife;
    public Projectile projectile;
    
    
    public Entity(GamePanel gp) {
    	this.gp = gp;

	}

    public void damageReaction() {}
    public void update() {
        collisionOn = false;
        gp.cChecker.checkTile(this);

        if (collisionOn == false){
            y += speed;
        }
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = x - gp.player.x + gp.player.x;
        int screenY = y - gp.player.y + gp.player.y;

        // if(x + gp.tileSize > gp.player.x - gp.player.x &&
        //         x - gp.tileSize < gp.player.x + gp.player.x &&
        //         y + gp.tileSize > gp.player.y - gp.player.y &&
        //         y - gp.tileSize < gp.player.y + gp.player.y) {
            //MONSTER HEALTH BAR
            if (type == 1 && hpBarOn == true) {
                double oneScale = gp.tileSize / maxLife;
                double hpBarValue = oneScale * life;

                g2.setColor(new Color(35, 35, 35));
                g2.fillRect(screenX - 1, screenY - 16, gp.tileSize + 2, 12);

                g2.setColor(new Color(255, 0, 30));
                g2.fillRect(screenX, screenY - 15, (int) hpBarValue, 10);

                hpBarCounter++;

                if(hpBarCounter > 600) {
                    hpBarCounter = 0;
                    hpBarOn = false;
                }
            }
            if(invincible == true) {
                hpBarOn = true;
                hpBarCounter = 0;
                changeAlpha(g2, 0.4F);
            }
            g2.drawImage(image, screenX, screenX, gp.tileSize, gp.tileSize, null);

            changeAlpha(g2, 1F);
        }
    public BufferedImage setup(String imagePath){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }

    public void changeAlpha(Graphics2D g2, float alphaValue){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }
}
