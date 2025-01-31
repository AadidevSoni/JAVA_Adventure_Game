
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class SuperObject {

  public BufferedImage image;
  public String name;
  public boolean collision = false;
  public int worldX,worldY;

  public void draw(Graphics2D g2,GamePanel gp){
    //same as the one in tile manager to draw blocks
    int screenX = worldX - gp.player.worldX + gp.player.screenX;  //where on screen to draw it
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX && 
			   worldX - gp.tileSize< gp.player.worldX + gp.player.screenX && 
			   worldY + gp.tileSize> gp.player.worldY - gp.player.screenY && 
			   worldY - gp.tileSize< gp.player.worldY + gp.player.screenY) {
				g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
			}
  }

  
}
