package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;




public class TileManager {
		
	GamePanel gp;
	public Tile[] tile; 
	public int mapTileNum[][];
	
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[10];
		mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
		
		getTileImage();
		loadMap("/res/map01.txt");
	}
	
	public void getTileImage() {
		

			setup(0, "grass", false);

			setup(1, "wall", true);

			setup(2, "water", true);


			// tile[3] = new Tile();
			// tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/heart blank.png"));

			// tile[4] = new Tile();
			// tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/heart full.png"));

			// tile[5] = new Tile();
			// tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/heart half.png"));
			
	
	
		}
		public void setup(int index, String imageName, boolean collision){
			UtilityTool uTool = new UtilityTool();
			try{
				tile[index] = new Tile();
				tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/"+imageName+".png"));
				tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
				tile[index].collision = collision;
	
			}catch(IOException e){
				e.printStackTrace();
			}
		}

	public void loadMap(String filePath) {
		
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		int col = 0;
		int row = 0;
			
		while(col< gp.maxScreenCol && row< gp.maxScreenRow) {
			
			String line = br.readLine();
			
			while(col < gp.maxScreenCol) {
				
				String numbers[] = line.split(" ");
				
				int num = Integer.parseInt(numbers[col]);
				
				mapTileNum[col][row] = num;
				col++;
			}
			if(col == gp.maxScreenCol) {
				col = 0;
				row++;
			}
		}
		br.close();
		}catch(Exception e) {
	}
	}
	public void draw(Graphics2D g2) {
		
		int col = 0;
		int row = 0;
		int x = 0; 
		int y = 0;
		
		while(col < gp.maxScreenCol && row< gp.maxScreenRow) {
			
			int tileNum = mapTileNum[col][row];
			
			g2.drawImage(tile[tileNum].image, x, y, null);
			col++;
			x += gp.tileSize;
			
			if(col == gp.maxScreenCol){
				col = 0;
				x = 0;
				row++;
				y += gp.tileSize;
			}
		}
		// g2.drawImage(tile[3].image, 0, 0, gp.tileSize, gp.tileSize, null);
		// g2.drawImage(tile[4].image, 0, 0, gp.tileSize, gp.tileSize, null);
		// g2.drawImage(tile[5].image, 0, 0, gp.tileSize, gp.tileSize, null);
	}
}
