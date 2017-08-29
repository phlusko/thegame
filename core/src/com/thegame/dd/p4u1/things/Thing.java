package com.thegame.dd.p4u1.things;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.thegame.dd.p4u1.rooms.Map;
import com.thegame.dd.p4u1.rooms.Spot;
import com.thegame.dd.p4u1.utils.Duple;

/**
 * Created by Paul on 8/29/2017.
 */

public abstract class Thing {
    public Duple location;
    public int width;
    public int height;
    public Vector2 usingOffset;
    public Duple accessPoint;


    public boolean isDupleInThing(Duple arg0) {
        return (arg0.x < location.x + width
                && arg0.x >= location.x
                && arg0.y < location.y + height
                && arg0.y >= location.y);
    }
    public Spot getAccessSpot(Map map) {
        return map.getSpot(Duple.add(location, accessPoint));
    }

    abstract public void update();
    abstract public void drawMe(SpriteBatch arg0);
}
