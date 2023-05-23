package main;

import monster.Monster;
import object.OBJ_Heart;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setObject() {
        gp.obj[0] = new OBJ_Heart();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldX = 7 * gp.tileSize;
    }
    public void setMonster() {
        gp.monster[0] = new Monster(gp);
        gp.monster[0].worldX = gp.tileSize*23;
        gp.monster[0].worldY = gp.tileSize*36;

        gp.monster[1] = new Monster(gp);
        gp.monster[1].worldX = gp.tileSize*23;
        gp.monster[1].worldY = gp.tileSize*36;
    }
}
