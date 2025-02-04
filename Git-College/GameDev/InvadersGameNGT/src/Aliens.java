import java.awt.*;

public class Aliens extends Sprite2D{
    private int width = 30;
    private int height = 30;


    public Aliens(int x, int y, Image img) {
        super(x,y,img);
    }
    @Override
    public void moveAlien() {
        x += (int) (15*(Math.random()-Math.random()));
        y += (int)(15*(Math.random()-Math.random()));
    }

    @Override
    public void movePlayer(int dx, int dy) {}
}
