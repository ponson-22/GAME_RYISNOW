package tile;

import mainmain.Panel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

import static javax.imageio.ImageIO.read;

public class manageme {
    Panel panel;
    tiles[] tile;
    int mapTilenum[][];

    public manageme(Panel panel) {
        this.panel = panel;
        tile = new tiles[10];
        mapTilenum = new int[panel.maxworldcol][panel.maxworldrow];

        gettileimage();
        map();
    }

    public void gettileimage() {
        try {
            tile[0] = new tiles();
            tile[0].image = read(Objects.requireNonNull(getClass().getResource("/entities/tiles/grass.png")));

            tile[1] = new tiles();
            tile[1].image = read(Objects.requireNonNull(getClass().getResource("/entities/tiles/tree.png")));

            tile[2] = new tiles();
            tile[2].image = read(Objects.requireNonNull(getClass().getResource("/entities/tiles/wall.png")));
            tile[2].collision = true;

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void map() {

        try {
            InputStream is = getClass().getResourceAsStream("/entities/map/MAP1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while (col < panel.maxworldcol && row <panel.maxworldrow) {
                String line = br.readLine();

                while (col < panel.maxworldcol) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTilenum[col][row] = num;
                    col++;
                }

                if(col == panel.maxworldcol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int worldcol = 0;
        int worldrow = 0;

        while (worldcol < panel.maxworldcol && worldrow <panel.maxworldrow) {

            int tileNum = mapTilenum[worldcol][worldrow];
            int worldX = worldcol * panel.tileSize;
            int worldY = worldrow * panel.tileSize;
            int screenx = worldX - panel.Player.worldx + panel.Player.screenx;
            int screeny = worldY - panel.Player.worldy + panel.Player.screeny;

            g2.drawImage(tile[tileNum].image, screenx, screeny, panel.tileSize, panel.tileSize, null);

            worldcol++;

            if (worldcol == panel.maxworldcol) {
                worldcol = 0;
                worldrow++;
            }

        }
    }
}