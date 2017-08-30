package com.thegame.dd.p4u1.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thegame.dd.p4u1.rooms.Map;
import com.thegame.dd.p4u1.rooms.Room;
import com.thegame.dd.p4u1.utils.Duple;
import com.thegame.dd.p4u1.utils.PaulGraphics;

/**
 * Created by Paul on 8/29/2017.
 */

public abstract class Character {
    int life;
    public Duple location;

    public Character() {
        life = 100;
        location = new Duple();
    }

    abstract public void moveTo(Duple moveTo, Room room);
    abstract public void update();
    abstract public boolean isAlive();
    abstract public void drawMe(SpriteBatch batch);
    abstract public void dispose();
}
