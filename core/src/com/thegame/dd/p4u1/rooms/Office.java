package com.thegame.dd.p4u1.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thegame.dd.p4u1.things.Desk;
import com.thegame.dd.p4u1.things.Drums;
import com.thegame.dd.p4u1.things.Thing;
import com.thegame.dd.p4u1.utils.Duple;

import java.util.Iterator;

/**
 * Created by Paul on 8/28/2017.
 */

public class Office extends Room {
    Texture img;
    Sprite bg;
    Map map;

    Desk desk;
    Drums drums;

    public Office() {
        super();
        desk = new Desk();
        desk.setLocation(new Duple(1,2));
        drums = new Drums();
        drums.setLocation(new Duple(6,2));
        things.add(desk);
        things.add(drums);

        ground = Room.blankGround();
        for (int x = 0 ; x < 10; x++) {
            ground[x][3] = false;
            ground[x][4] = false;
        }

        img = new Texture("places/office_bg.png");
        bg = new Sprite(img);
        bg.setSize(1000, 500);
        removeThingGround();
        map = new Map(ground);
        map.origin = map.spots[1][0];
    }
    @Override
    public boolean[][] getGround() {
        return ground;
    }

    @Override
    public Map getMap() {
        return map;
    }

    @Override
    public void drawMe(SpriteBatch batch) {
        bg.draw(batch);
        for (Iterator<Thing> iter = things.iterator(); iter.hasNext();) {
            iter.next().drawMe(batch);
        }
    }

    @Override
    public void dispose() {
        img.dispose();
    }
}
