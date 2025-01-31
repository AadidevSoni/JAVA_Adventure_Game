public class AssetSetter {

  GamePanel gp;

  public AssetSetter(GamePanel gp){
    this.gp = gp;
  }

  public void setObject(){
    gp.obj[0] = new OBJ_Key();
    gp.obj[0].worldX = 24 * gp.tileSize;
    gp.obj[0].worldY = 14 * gp.tileSize;

    gp.obj[1] = new OBJ_Key();
    gp.obj[1].worldX = 24 * gp.tileSize;
    gp.obj[1].worldY = 39 * gp.tileSize;

    gp.obj[2] = new OBJ_Door();
    gp.obj[2].worldX = 24 * gp.tileSize;
    gp.obj[2].worldY = 41 * gp.tileSize;

    gp.obj[3] = new OBJ_Chest();
    gp.obj[3].worldX = 23 * gp.tileSize;
    gp.obj[3].worldY = 41 * gp.tileSize;
  }
  
}
