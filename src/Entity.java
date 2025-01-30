import java.awt.image.BufferedImage;

public class Entity {

  public int x,y;
  public int speed;

  //we use bufferImage to store image data
	public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
	public String direction;

  //walking animation
	public int spriteCounter = 0;
	public int spriteNum = 1;
  
}
