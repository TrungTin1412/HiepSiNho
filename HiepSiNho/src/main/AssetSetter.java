package main;


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
    //MONSTER FIRST LOCATION
    public void setMonster(){
        gp.monster[0] = new Monster(gp);
        gp.monster[0].x = gp.tileSize*3;
        gp.monster[0].y = gp.tileSize*5;

        gp.monster[1] = new Monster(gp);
        gp.monster[1].x = gp.tileSize*6;
        gp.monster[1].y = gp.tileSize*8;
    }
}