// package main;

// import entity.Entity;

// public class CollisionChecker {
//     GamePanel gp;
//     public CollisionChecker(GamePanel gp){
//         this.gp = gp;
//     }
//     public void checkTile(Entity entity){
//         int entityLeftX = entity.x + entity.solidArea.x;
//         int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
//         int entityTopY = entity.y + entity.solidArea.y;
//         int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;

//         int entityLeftCol = entityLeftX / gp.tileSize;
//         int entityRightColX = entityRightX / gp.tileSize;
//         int entityTopColY = entityTopY / gp.tileSize;
//         int entityBottomColY = entityBottomY / gp.tileSize;
//         int tileNum1, tileNum2;

//         switch (entity.direction){
//         case "up":
//             entityTopRow = (entityTopY - entity.speed)/gp.tileSize;
//             tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
//             tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
//             if (gp.tileM.tile[tileNum1].collision == true||gp.tileM.tile[tileNum2].collision == true){
//                 entity.collisionOn = true;
//             }
//             break;
//         case "down":
//             entityBottomRow = (entityBottomY + entity.speed)/gp.tileSize;
//             tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
//             tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
//             if (gp.tileM.tile[tileNum1].collision == true||gp.tileM.tile[tileNum2].collision == true){
//                 entity.collisionOn = true;
//             }
//             break;
//         case "left":
//             entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
//             tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
//             tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
//             if (gp.tileM.tile[tileNum1].collision == true||gp.tileM.tile[tileNum2].collision == true){
//                 entity.collisionOn = true;
//             }
//             break;
//         case "right":
//             entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
//             tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
//             tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
//             if (gp.tileM.tile[tileNum1].collision == true||gp.tileM.tile[tileNum2].collision == true){
//                 entity.collisionOn = true;
//             }
//             break;
//         }
//     }
// }
