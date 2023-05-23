package Entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class  Player extends Entity {
    public Player(GamePanel gp) {
        super(gp);
    }
    public void setDefaultValues() {
        maxLife = 6;
        life = maxLife;
    }
    public void update() {
        if(invincible == true) {
            invincibleCounter++;
            if(invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }
        }

        int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
        contactMonster(monsterIndex);
    }
    public void contactMonster(int i) {
        if(i != 999)  {
            if(invincible == false) {
                life -= 1;
                invincible = true;
            }
        }
    }
    public void draw(Graphics2D g2) {

    }
}
