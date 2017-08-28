package com.thegame.dd.p4u1.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Paul on 8/28/2017.
 */

public class Office extends Room {
    boolean[][] ground;

    Texture img;
    Sprite bg;

    public Office() {
        super();
        ground = Room.blankGround();
        for (int x = 0 ; x < 10; x++) {
            ground[x][0] = false;
            ground[x][1] = false;
        }

        img = new Texture("places/office_bg.png");
        bg = new Sprite(img);
        bg.setSize(1000, 500);
    }
    @Override
    public boolean[][] getGround() {
        return ground;
    }

    @Override
    public void drawMe(SpriteBatch batch) {
        bg.draw(batch);
    }

    @Override
    public void dispose() {
        img.dispose();
    }
}
