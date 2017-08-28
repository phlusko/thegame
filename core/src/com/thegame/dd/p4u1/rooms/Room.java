package com.thegame.dd.p4u1.rooms;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Paul on 8/28/2017.
 */

public abstract class Room {
    public Room(){

    }

    public static boolean[][] blankGround() {
        boolean[][] ground = new boolean[10][5];
        for(int x = 0; x < 10; x++) {
            for (int y = 0; y < 5; y++) {
                ground[x][y] = true;
            }
        }
        return ground;
    }
    abstract public boolean[][] getGround();
    abstract public void drawMe(SpriteBatch batch);
    abstract public void dispose();
}
