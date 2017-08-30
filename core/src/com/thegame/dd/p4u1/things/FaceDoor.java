package com.thegame.dd.p4u1.things;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thegame.dd.p4u1.rooms.Room;
import com.thegame.dd.p4u1.utils.Duple;

/**
 * Created by Paul on 8/29/2017.
 */

public class FaceDoor extends Exit {

    public FaceDoor(Room arg0) {
        super(arg0);
        width = 1;
        height = 2;
        accessPoint = new Duple(0, -1);
    }

}
