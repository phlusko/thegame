package com.thegame.dd.p4u1.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.thegame.dd.p4u1.rooms.Map;
import com.thegame.dd.p4u1.rooms.Room;
import com.thegame.dd.p4u1.rooms.Spot;
import com.thegame.dd.p4u1.things.Thing;
import com.thegame.dd.p4u1.utils.Duple;
import com.thegame.dd.p4u1.utils.PaulGraphics;
import com.thegame.dd.p4u1.utils.Walker;

/**
 * Created by Paul on 8/29/2017.
 */

public class Human extends Character {
    Walker walker;

    Duple destination;
    Map map;

    boolean walking;
    int walkingSpeed = 333;
    long lastStepTime;
    Spot[] path;
    int spotIndex;

    boolean toThing = false;
    boolean interacting;
    Thing target;

    public Human() {
        super();
        interacting = false;
        walker = new Walker();
    }

    @Override
    public void moveTo(Duple moveTo, Room room) {
        destination = moveTo;
        Map arg0 = room.getMap();
        if (moveTo.same(location)) {
            return;
        }
        if (!arg0.getSpot(moveTo).ground) {
            return;
        }

        if (room.isDupleInThing(moveTo)) {
            toThing = true;
            target = room.getThingAtDuple(moveTo);
            destination = target.getAccessSpot(arg0).location;
        } else {
            toThing = false;
            target = null;
            interacting = false;
        }
        walking = true;
        map = arg0;
        path = map.getPath(location, moveTo);
        spotIndex = 0;
        System.out.println(Map.pathToString(path));
        System.out.println(path.length);
        lastStepTime = TimeUtils.millis();
    }

    @Override
    public void update() {
        if (walking && (TimeUtils.millis() - lastStepTime > walkingSpeed)) {
            lastStepTime = TimeUtils.millis();
            spotIndex++;
            location = path[spotIndex].location;
            if (destination.same(location)) {
                walking = false;
                if (toThing) {
                    toThing = false;
                    interacting = true;
                }
            }
        }
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public void drawMe(SpriteBatch batch) {
        Vector2 coord = PaulGraphics.dupleToCoord(location);
        if (interacting) {
            coord.add(target.usingOffset);
        }
        walker.drawMe(batch, PaulGraphics.dupleToCoord(location), 0,0);
    }

    @Override
    public void dispose() {

    }
}
