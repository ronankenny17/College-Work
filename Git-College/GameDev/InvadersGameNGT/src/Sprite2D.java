import java.awt.*;

public abstract class Sprite2D {
    int x;
    int y;
   Image image;


   public Sprite2D(int x, int y,Image img) {
       this.x = x;
       this.y = y;
       this.image = img;
   }



    public abstract void moveAlien();

   public abstract void movePlayer(int dx, int dy);




    public void paint(Graphics g) {
        g.clearRect(0, 0, image.getWidth(null), image.getHeight(null) );
        g.drawImage(image,x,y,null);
    }
}
