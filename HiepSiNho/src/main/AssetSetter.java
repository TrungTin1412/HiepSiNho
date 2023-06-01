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
    public void setMonster(){
        for(int i = 0; i < 3; i++) {
            gp.monster[i] = new Monster(gp);
            gp.monster[i].x = 20;
            gp.monster[i].y = 50;
        }


        // gp.monster[1] = new Monster(gp);
        // gp.monster[1].x = gp.tileSize ;
        // gp.monster[1].y = gp.tileSize;
    }
}
