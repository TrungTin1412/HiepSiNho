package main;


import entity.Entity;

public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checkTile(Entity entity){
        int entityLeftX = entity.x + entity.solidArea.x;
        int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopY = entity.y + entity.solidArea.y;
        int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftX / gp.tileSize;
        int entityRightCol = entityRightX / gp.tileSize;
        int entityTopRow = entityTopY / gp.tileSize;
        int entityBottomRow = entityBottomY / gp.tileSize;
        int tileNum1, tileNum2;

        switch (entity.direction){

        case "left":
            entityLeftCol = (entityLeftX - entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            if (gp.tileM.tile[tileNum1].collision == true||gp.tileM.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
        case "right":
            entityRightCol = (entityRightX + entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if (gp.tileM.tile[tileNum1].collision == true||gp.tileM.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
        }
    }
    //NPC or monster
    public int checkEntity(Entity entity, Entity[] target){
        int index = 999;
        for(int i = 0; i < target.length; i++){
            if(target[i] != null){
                //Get entity's solid area position
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                //Get the object's solid area position
                target[i].solidArea.x = target[i].x + target[i].solidArea.x;
                target[i].solidArea.y = target[i].y + target[i].solidArea.y;
                switch(entity.direction){
                case "up":
                    entity.solidArea.y -= entity.speed;
                    if(entity.solidArea.intersects(target[i].solidArea)){
                            entity.collisionOn = true;
                            index = i;
                    }
                    break;
                case "down":
                    entity.solidArea.y -= entity.speed;
                    if(entity.solidArea.intersects(target[i].solidArea)){
                            entity.collisionOn = true;
                            index = i;
                    }
                    break;
                case "right":
                    entity.solidArea.y -= entity.speed;
                    if(entity.solidArea.intersects(target[i].solidArea)){
                            entity.collisionOn = true;
                            index = i;
                    }
                    break;
                case "left":
                    entity.solidArea.y -= entity.speed;
                    if(entity.solidArea.intersects(target[i].solidArea)){
                            entity.collisionOn = true;
                            index = i;
                    }
                    break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;    
            }
        }
        return index;
    }
}
