package com.thegame.dd.p4u1.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Paul on 5/4/2017.
 */

public class Walker {
    Sprite[][] sprites = new Sprite[4][3];
    Texture sprite_texture;
    TextureRegion sprite_region;

    //Sprite[][] sprites2 = new Sprite[4][3];
   // Texture sprite_texture2;
    //TextureRegion sprite_region2;

    public Walker() {
        // this.sprite_texture = new Texture(Gdx.files.internal("pol_sprite.png"));
        this.sprite_texture = new Texture(Gdx.files.internal("characters/paul.png"));
       // this.sprite_texture2 = new Texture(Gdx.files.internal("penguin.png"));

        int i = 0;
        int di = 0;
        for(int j = 0; j < 4; j++) {
            this.sprite_region = new TextureRegion(this.sprite_texture, 0 + (j * 256), 0 + (di * 256), 256, 256);
           // this.sprite_region2 = new TextureRegion(this.sprite_texture2, 0 + (j * 256), 0 + (di * 256), 256, 256);
            this.sprites[j][i] = new Sprite(sprite_region);
           // this.sprites2[j][i] = new Sprite(sprite_region2);
        }
    }

    public void drawMe (SpriteBatch batch, Vector2 loc, int frame, int direction) {
        this.sprites[frame][direction].setSize(128, 128);
        this.sprites[frame][direction].setPosition(loc.x - 64, loc.y);
        this.sprites[frame][direction].draw(batch);
    }

    public void drawMe (SpriteBatch batch, Vector2 loc, int frame, int direction, boolean arg0) {
       // this.sprites2[frame][direction].setSize(256, 256);
       // this.sprites2[frame][direction].setPosition(loc.x - 128, loc.y);
      //  this.sprites2[frame][direction].draw(batch);
    }

}
