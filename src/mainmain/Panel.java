package mainmain;

import entities.player;
import tile.manageme;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics2D;


public class Panel extends JPanel implements Runnable{

    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;

    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //world settings

    public final int maxworldcol = 50;
    public final int maxworldrow = 50;
    public final int worldwidth = tileSize * maxworldcol;
    public final int worldheight = tileSize * maxworldrow;

    int FPS = 60;

    manageme tilem = new manageme(this);
    keyb keyH = new keyb();
    Thread GameThread;
    public collision checker = new collision(this);
    public player Player = new player(this, keyH);


    public Panel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        GameThread = new Thread(this);
        GameThread.start();
    }

    public void run() {

        double drawInterval = 1000/FPS;
        double nextDrawTime = System.currentTimeMillis() + drawInterval;

        while(GameThread != null) {
            update();

            repaint();

            try {
                double remainingTime = nextDrawTime - System.currentTimeMillis();
                if (remainingTime > 0 ) {
                    Thread.sleep((long) remainingTime);
                }

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        Player.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        tilem.draw(g2);
        Player.draw(g2);
        g2.dispose();

    }
}


