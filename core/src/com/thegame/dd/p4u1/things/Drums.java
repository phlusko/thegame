package com.thegame.dd.p4u1.things;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.thegame.dd.p4u1.utils.Duple;

/**
 * Created by Paul on 8/29/2017.
 */

public class Drums extends Thing{

    Texture texture;
    Sprite sprite;

    public Drums() {
        width = 2;
        height = 2;
        accessPoint = new Duple(1,-1);
        usingOffset = new Vector2(-50, 50);
        texture = new Texture("things/drums.png");
        sprite = new Sprite(texture);
        sprite.setSize(200, 200);
    }

    @Override
    public void update() {

    }

    @Override
    public void drawMe(SpriteBatch arg0) {
        sprite.setPosition(location.x *100, location.y * 100);
        sprite.draw(arg0);
    }
}
