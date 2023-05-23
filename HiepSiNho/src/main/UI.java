package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
	
	
	GamePanel gp;
	Graphics2D g2;
	Font arial_40, 
	arial_80B;
// 	BufferedImage keyImage;
	BufferedImage heart_blank, heart_full, heart_half;
	public int commandNum = 0;
	public int titleScreenState = 0;
	
	
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_80B = new Font("Arial", Font.BOLD, 80);
//   	OJB_Key key = new OJB_Key(gp);
//		keyImage = key.image;
		SuperObject heart = new OBJ_Heart(gp);
		heart_blank = heart.image;
		heart_full = heart.image2;
		heart_half = heart.image3;
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		//TITLE STATE
		
		  if(gp.gameState == gp.titleState) { 
			  drawTitleScreen(); 
		}
		 
		
		//PAUSE STATE
		  if(gp.gameState == gp.playState) {
			  drawPlayerLife();
		  } 
		  if(gp.gameState == gp.pauseState) {
			  drawPlayerLife();
			  drawPauseScreen(); 
		  }
		if(gp.gameState == gp.dialogueState) {
			drawPlayerLife();
			drawDialogueScreen();
		}
		 
	}
	public void drawPlayerLife() {
		gp.player.life = 6;
		int x = gp.tileSize/2;
		int y = gp.tileSize/2;
		int i = 0;
		//DRAW BLANK HEART
		while (i < gp.player.maxLife/2) {
			g2.drawImage(heart_blank, x, y, null);
			i++;
			x += gp.tileSize;
		}
		// RESET
		x = gp.tileSize/2;
		y = gp.tileSize/2;
		i = 0;
		//DRAW CURRENT LIFE
		while (i < gp.player.life) {
			g2.drawImage(heart_half, x, y, null);
			i++;
			if(i < gp.player.life) {
				g2.drawImage(heart_full, x, y, null);
			}
			i++;
			x += gp.tileSize;
		}
	}



	public void drawTitleScreen() {
		  
		  if(titleScreenState == 0) {
			  g2.setColor(new Color(70, 120, 80)); 
			  g2.fillRect(0, 0, gp.screenWidth,
			  gp.screenHeight);
			  
			  //TITLE NAME 
			  g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F)); 
			  String text = "Hiệp Sĩ Nhỏ"; 
			  int x = getXforCenteredText(text); 
			  int y = gp.tileSize * 5;
			  
			  // SHADOW 
			  g2.setColor(Color.black); 
			  g2.drawString(text, x + 5, y + 5);
			  
			  //MAIN COLOR 
			  g2.setColor(Color.white); 
			  g2.drawString(text, x, y);
			  
			  
			  //HIỆP SĨ NHỎ IMAGE 
			  x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2; 
			  y += gp.tileSize * 2; 
			  g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2,gp.tileSize * 2, null);
			  
			  //MENU GAME 
			  g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
			  
			  text = "START GAME"; 
			  x = getXforCenteredText(text); 
			  y += gp.tileSize * 5;
			  g2.drawString(text, x, y); 
			  if(commandNum == 0) { 
				  g2.drawString(">", x -gp.tileSize, y); 
			  }
			  
			  text = "QUIT"; 
			  x = getXforCenteredText(text); 
			  y += gp.tileSize;
			  g2.drawString(text, x, y); 
			  if(commandNum == 1) { 
				  g2.drawString(">", x - gp.tileSize, y); 
			  }
		  }
		  
	  
	  }
	
	
	  public void drawPauseScreen() {
		  g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F)); 
		  String text = "PAUSED";
		  int x = getXforCenteredText(text); 
		  int y = gp.screenHeight / 2;	  
		  g2.drawString(text, x, y); 
	  }
	  
	  public int getXforCenteredText(String text) { 
		  int length =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); 
		  int x =gp.screenWidth / 2 - length / 2; return x; }
	

}
