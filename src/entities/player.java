package entities;

import mainmain.Panel;
import mainmain.keyb;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static javax.imageio.ImageIO.read;

public class player extends entity {

    Panel Panel;
    keyb keyH;

    public final int screenx;
    public final int screeny;

    public player(Panel Panel, keyb keyH) {
        this.Panel = Panel;
        this.keyH = keyH;
        screenx = Panel.screenWidth/2 - (Panel.tileSize/2);
        screeny = Panel.screenHeight/2- (Panel.tileSize /2);

        setDefaultValues();
        Playerimage();

        solidarea = new Rectangle(0, 0, Panel.tileSize, Panel.tileSize);
    }

    public void setDefaultValues() {
        worldx = Panel.tileSize * 23;
        worldy =  Panel.tileSize * 21;
        speed = 4;
        direction = "right";
    }

    public void Playerimage() {
        try {
            up1 = read(getClass().getResource("/entities/player/boy_up_1.png"));
            up2 = read(getClass().getResource("/entities/player/boy_up_2.png"));
            down1 = read(getClass().getResource("/entities/player/boy_down_1.png"));
            down2 = read(getClass().getResource("/entities/player/boy_down_2.png"));
            left1 = read(getClass().getResource("/entities/player/boy_left_1.png"));
            left2 = read(getClass().getResource("/entities/player/boy_left_2.png"));
            right1 = read(getClass().getResource("/entities/player/boy_right_1.png"));
            right2 = read(getClass().getResource("/entities/player/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if(keyH.downPressed || keyH.leftPressed || keyH.upPressed || keyH.rightPressed) {

            if (keyH.upPressed) {
                direction = "up";
                worldy -= speed;
            } else if (keyH.downPressed) {
                direction = "down";
                worldy += speed;
            } else if (keyH.leftPressed) {
                direction = "left";
                worldx -= speed;
            } else {
                direction = "right";
                worldx += speed;
            }

            collisionON = false;
            Panel.checker.Checktile(this);

            s_counter++;
            if (s_counter > 14) {
                if (s_num == 1) {
                    s_num = 2;
                } else if (s_num == 2) {
                    s_num =1;
                }
                s_counter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch(direction) {
            case "up":
                if (s_num == 1) {
                    image = up1;
                }
                if (s_num == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (s_num == 1) {
                    image = down1;
                }
                if (s_num == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (s_num == 1) {
                    image =  left1;
                }
                if (s_num == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (s_num == 1) {
                    image = right1;
                }
                if (s_num == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenx, screeny, Panel.tileSize, Panel.tileSize, null);
    }
}
