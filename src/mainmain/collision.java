package mainmain;

import entities.entity;

public class collision {

    private final Panel panel;

    public collision (Panel panel) {
        this.panel = panel;
    }

    public void Checktile (entity entity) {

        int entityleftWorldx = entity.worldx + entity.solidarea.x;
        int entityrightWorldx = entity.worldx + entity.solidarea.x;
        int entitytopWorldy = entity.worldy + entity.solidarea.y;
        int entitybottomtWorldy = entity.worldy + entity.solidarea.y;

        int entityleftcol = entityleftWorldx/panel.tileSize;
        int entityrightcol = entityrightWorldx/panel.tileSize;
        int entitytoprow = entitytopWorldy/panel.tileSize;
        int entitybottomrow = entitybottomtWorldy/panel.tileSize;

        int tilenum1, tilenum2;

        switch(entity.direction) {
            case "up":
                break;
            case "down":
                break;
            case "left":
                break;
            case "right":
                break;
        }


    }
}
