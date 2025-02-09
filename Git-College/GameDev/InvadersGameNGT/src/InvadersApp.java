import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InvadersApp extends JFrame implements Runnable , KeyListener {
    // setting initial limits for the JFrame
    private static int screenWidth = 800;
    private static int screenHeight = 400;
    private static final Dimension WindowSize = new Dimension(screenWidth,screenHeight);

    private static final int NUMALIENS = 15;
    private Sprite2D[] aliensArray = new Sprite2D[NUMALIENS];  // creating the array of aliens
    Sprite2D player1;
    private Image playerImage;
    private Image alienImage;

    private boolean moveUp = false;
    private boolean moveDown = false;
    private boolean moveLeft = false;
    private boolean moveRight = false;


    // constructor
    public InvadersApp() {

        // getting player  and alien image
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/player_ship.png"));

        if (icon1.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.out.println("Error loading image: player_ship.png");
        } else {
            System.out.println("Image loaded successfully");
        }
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/alien_ship_1.png"));
        playerImage = icon1.getImage();
        alienImage = icon2.getImage();


        // instantiate player object
        player1 = new Player((int)(Math.random()*600),600,playerImage);


        //Create and set up the window.
        this.setTitle("Threads and Animation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window, centred on the screen
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screensize.width/2 - WindowSize.width/2,
                screensize.height/2 - WindowSize.height/2,
                WindowSize.width, WindowSize.height);
        setBackground(Color.BLACK);
        setVisible(true);

        // initialize aliens array
        for(int i=0;i<NUMALIENS;i++){
            // randomly places the aliens on the screen
            Sprite2D alien = new Aliens((int)(Math.random()*600),(int)(Math.random()*400),alienImage);
            aliensArray[i]= alien;
        }

        // starting the thread
        Thread t = new Thread(this);
        t.start();
        addKeyListener(this);


    }

    public static void main(String[] args) {
        new InvadersApp();
    }

    public void run(){

        // to run as long as needed
        while(true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // moves every box
            for (int i = 0; i < NUMALIENS; i++) {
                aliensArray[i].moveAlien();
            }
            int speed = 20;
            if (moveLeft) {
                player1.movePlayer(-speed, 0);  // Move left
            } else if (moveRight) {
                player1.movePlayer(speed, 0);   // Move right
            } else if (moveDown) {
                player1.movePlayer(0, speed);  // Move up
            } else if (moveUp) {
                player1.movePlayer(0, -speed);   // Move down
            }
            repaint();
        }

    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            moveLeft=true;   // Move left
        } else if (key == KeyEvent.VK_RIGHT) {
            moveRight=true;   // Move right
        } else if (key == KeyEvent.VK_UP) {
            moveUp=true; // Move up
        } else if (key == KeyEvent.VK_DOWN) {
            moveDown=true;    // Move down
        }

    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            moveLeft=false;   // Move left
        } else if (key == KeyEvent.VK_RIGHT) {
            moveRight=false;   // Move right
        } else if (key == KeyEvent.VK_UP) {
            moveUp=false; // Move up
        } else if (key == KeyEvent.VK_DOWN) {
            moveDown=false;    // Move down
        }

    }
    public void keyTyped(KeyEvent e) {

    }


    public void paint(Graphics g) {
        // have to clear the screen after repainting each time 
        g.clearRect(0, 0,getWidth(),getHeight());
        for(int i=0;i<NUMALIENS;i++) {
            aliensArray[i].paint(g);
        }
        player1.paint(g);

    }

}
