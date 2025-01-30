import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity{

  GamePanel gp;
  KeyHandler keyH;

  public final int screenX;  //these values dont change 
	public final int screenY;

  public Player(GamePanel gp,KeyHandler keyH) {

		this.gp = gp;
		this.keyH = keyH;

    screenX = gp.screenWidth/2 - (gp.tileSize/2);  //the player positions screen position does not change
		screenY = gp.screenHeight/2 - (gp.tileSize/2);

    solidArea = new Rectangle();  //x,y,width,height
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 32;

    setDefaultValues();
    getPlayerImage();
	}

  public void setDefaultValues() {
    //Player's position on the world map
		worldX = gp.tileSize * 23;  //to get centre of world
		worldY = gp.tileSize * 21;
		speed = 7;
    direction = "down";
	}

  public void getPlayerImage() {
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("./boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("./boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("./boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("./boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("./boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("./boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("./boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("./boy_right_2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

  
  public void update() {
		//in JAVA, TOP LEFT IS (0,0) AND X INCREASES TO RIGHT AND Y INCREASES BOTTOM
		//we want the sprites to update only when keys are pressed
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {

			if(keyH.upPressed == true) {
				direction = "up";
				//moved to collision checker
			}
			else if(keyH.downPressed == true) {
				direction = "down";
			}
			else if(keyH.leftPressed == true) {
				direction = "left";
			}
			else if(keyH.rightPressed == true) {
				direction = "right";
			}

      //COLLSION CHECKER
			collisionOn = false;
			gp.cChecker.checkTile(this); //passing player as the entity
			
			if(collisionOn == false) {
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
				}
			}
				
			//SPRITE CHANGER
			//update method is called 60 times per sec
			spriteCounter++;
			if(spriteCounter > 12) {  //image changes every 10 frames
				if(spriteNum == 1) {
					spriteNum = 2;
				}else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
		
	}
  

  public void draw(Graphics2D g2){
    
    //g2.setColor(Color.WHITE);
    //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

    BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);  //null is image of observer

  }
}