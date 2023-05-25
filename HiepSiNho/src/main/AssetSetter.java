package main;

import java.io.IOException;

import monster.Monster;
import object.OBJ_Heart;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setObject() {
        gp.obj[0] = new OBJ_Heart(gp);
        gp.obj[0].x = 23 * gp.tileSize;
        gp.obj[0].x = 7 * gp.tileSize;
    }
    public void setMonster() throws IOException {
        gp.monster[0] = new Monster(gp);
        gp.monster[0].x = gp.tileSize*23;
        gp.monster[0].y = gp.tileSize*36;

        gp.monster[1] = new Monster(gp);
        gp.monster[1].x = gp.tileSize*23;
        gp.monster[1].y = gp.tileSize*36;
    }
}