package com.thegame.dd.p4u1.things;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thegame.dd.p4u1.rooms.Room;

/**
 * Created by Paul on 8/29/2017.
 */

public class TopDoor extends Exit {
    Texture texture;
    Sprite sprite;
    public TopDoor(Room arg0) {
        super(arg0);
        texture = new Texture("things/top_door.png");
        sprite = new Sprite(texture);
        sprite.setSize(100, 100);
    }

    @Override
    public void drawMe(SpriteBatch arg0) {
        sprite.setPosition(location.x * 100, location.y * 100);
        sprite.draw(arg0);
    }
}
