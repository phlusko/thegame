package com.thegame.dd.p4u1.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thegame.dd.p4u1.things.Exit;
import com.thegame.dd.p4u1.utils.Duple;

/**
 * Created by Paul on 8/29/2017.
 */

public class Hallway extends Room {
    Texture img;
    Sprite bg;

    public Hallway() {
        super();
        ground = Room.blankGround();
        for (int x = 0 ; x < 10; x++) {
            ground[x][3] = false;
            ground[x][4] = false;
        }
        for (int x = 0 ; x < 5; x++) {
            ground[0][x] = false;
            ground[8][x] = false;
            ground[9][x] = false;
        }

        for (int x = 0 ; x < 3; x++) {
            ground[5+x][2] = false;
            ground[5+x][3] = false;
        }


        img = new Texture("places/hallway.png");
        bg = new Sprite(img);
        bg.setSize(1000, 500);
        removeThingGround();
        map = new Map(ground);
        map.getSpot(new Duple(3,2)).east = null;
        map.getSpot(new Duple(4,2)).west = null;
        map.origin = map.spots[6][1];
    }

    public void addExits(Exit arg0) {
        arg0.setLocation(new Duple(6,2));
        arg0.newLocation = new Duple(3, 0);
        things.add(arg0);

    }
    @Override
    public boolean[][] getGround() {
        return new boolean[0][];
    }

    @Override
    public Map getMap() {
        return map;
    }

    @Override
    public void drawMe(SpriteBatch batch) {
        bg.draw(batch);
    }

    @Override
    public void dispose() {

    }
}
