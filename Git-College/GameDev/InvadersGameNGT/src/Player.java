import java.awt.*;

public class Player extends Sprite2D{

    //private int width = 30;
    //private int height = 30;

    public Player(int x, int y, Image img) {
        super(x,y,img);

    }
    @Override
    public void moveAlien() {
    }

    @Override
    public void movePlayer(int dx, int dy){
        x+= dx;
        y+= dy;
    }
}
