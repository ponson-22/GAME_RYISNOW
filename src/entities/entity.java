package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class entity {
    public int worldx, worldy;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int s_counter = 0;
    public int s_num = 1;

    public Rectangle solidarea;
    public boolean collisionON = false;

}
