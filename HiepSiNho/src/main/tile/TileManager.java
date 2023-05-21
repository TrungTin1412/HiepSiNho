package tile;


import java.io.BufferedReader;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;




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
		
		try {
	
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/grass.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/wall.png"));
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/water.png"));
			tile[2].collision = true;
			
			
		}catch(IOException e) {
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
			
			g2.drawImage(tile[tileNum].image, x, y, gp.tileSize,gp.tileSize, null);
			col++;
			x += gp.tileSize;
			
			if(col == gp.maxScreenCol){
				col = 0;
				x = 0;
				row++;
				y += gp.tileSize;
			}
		}
		
	}
}