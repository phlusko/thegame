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
    int animSpeed = 150;
    int direction = 0;
    int frame = 0;
    long lastAnim;
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
            interacting = false;
            return;
        }

        if (room.isDupleInThing(moveTo)) {
            toThing = true;
            if (target != null && !target.equals(room.getThingAtDuple(moveTo))) {
                interacting = false;
            }
            target = room.getThingAtDuple(moveTo);
            destination = target.getAccessSpot(arg0).location;
        } else {
            if (!arg0.getSpot(moveTo).ground) {
                return;
            }
            toThing = false;
            target = null;
            interacting = false;
        }
        if (destination.same(location)) {
            interacting = true;
            return;
        }
        walking = true;
        map = arg0;
        path = map.getPath(location, destination);
        if (path == null) {
            walking = false;
            return;
        }
        spotIndex = 0;
        //System.out.println(Map.pathToString(path));
        //System.out.println(path.length);
        lastStepTime = TimeUtils.millis();
        lastAnim = TimeUtils.millis();
    }

    public void updateDirection(Duple a, Duple b) {
        Duple diff = Duple.subtract(b, a);
        if (diff.x > 0){
            direction = 2;
        } else if (diff.x < 0){
            direction = 3;
        } else if (diff.y > 0) {
            direction = 1;
        }else {
            direction = 0;
        }
    }

    @Override
    public void update() {
        if (walking && (TimeUtils.millis() - lastStepTime > walkingSpeed)) {
            lastStepTime = TimeUtils.millis();
            spotIndex++;
            updateDirection(location, path[spotIndex].location);
            location = path[spotIndex].location;
            if (destination.same(location)) {
                walking = false;
                frame = 0;
                if (toThing) {
                    toThing = false;
                    interacting = true;
                }
            }
        }
        if (walking && (TimeUtils.millis() - lastAnim > animSpeed)) {
            frame++;
            if (frame == 4) {
                frame = 0;
            }
            lastAnim = TimeUtils.millis();
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
        walker.drawMe(batch, coord, frame,direction);
    }

    @Override
    public void dispose() {

    }
}
