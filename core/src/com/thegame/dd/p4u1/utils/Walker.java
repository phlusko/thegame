package com.thegame.dd.p4u1.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Paul on 5/4/2017.
 */

public class Walker {
    Sprite[][] sprites = new Sprite[4][4];
    Texture sprite_texture;
    TextureRegion sprite_region;
    HashMap<String, Sprite[][]> spriteHasher = new HashMap<String, Sprite[][]>();
    HashMap<String, Texture> textureHasher = new HashMap<String, Texture>();
    HashMap<String, TextureRegion> spriteRegionHasher = new HashMap<String, TextureRegion>();
    HashMap<String, Color> colorHasher = new HashMap<String, Color>();
    String[] body_pieces = {
            "belt",
            "buckle_bottom",
            "buckle_highlight_top",
            "buckle_mid",
            "buckle_mid_highlight",
            "buckle_top",
            "cleavage",
            "hands",
            "necklace",
            "outline",
            "pants",
            "shirt_highlight",
            "shirt_main",
            "shoes"
    };

    public Walker() {
        this.sprite_texture = new Texture(Gdx.files.internal("characters/head/paul.png"));
        int quarter_width = this.sprite_texture.getWidth() / 4;
         for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.sprite_region = new TextureRegion(this.sprite_texture, 0 + (j * quarter_width), 0 + (i * quarter_width), quarter_width, quarter_width);
                this.sprites[j][i] = new Sprite(sprite_region);
            }
        }
        for (int index = 0; index < body_pieces.length; index++) {
            String curr = body_pieces[index];
            textureHasher.put(curr, new Texture("characters/body_walking/" + curr + ".png"));
            quarter_width = textureHasher.get(curr).getWidth() / 4;
            spriteHasher.put(curr, new Sprite[4][4]);
            for(int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    spriteRegionHasher.put(curr, new TextureRegion(textureHasher.get(curr), 0 + (j * quarter_width), 0 + (i * quarter_width), quarter_width, quarter_width));
                    spriteHasher.get(curr)[j][i] = new Sprite(spriteRegionHasher.get(curr));
                }
            }
        }
        setPaulColors();
    }

    public Walker(int type) {
        this();
        switch (type) {
            case 1:
                this.sprite_texture = new Texture(Gdx.files.internal("characters/head/krystal.png"));
                int quarter_width = this.sprite_texture.getWidth() / 4;
                for(int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        this.sprite_region = new TextureRegion(this.sprite_texture, 0 + (j * quarter_width), 0 + (i * quarter_width), quarter_width, quarter_width);
                        this.sprites[j][i] = new Sprite(sprite_region);
                    }
                }
                setKrystalColors();
                break;
            default:
                setPaulColors();
        }
    }

    public void setPaulColors() {
        colorHasher.put("belt", new Color(0x2f2417ff));
        colorHasher.put("buckle_bottom", new Color (0x798813ff));
        colorHasher.put("buckle_highlight_top", new Color (0xb6cb29ff));
        colorHasher.put("buckle_mid", new Color (0x798813ff));
        colorHasher.put("buckle_mid_highlight", new Color (0xb6cb29ff));
        colorHasher.put("buckle_top", new Color(0x798813ff));
        colorHasher.put("cleavage", new Color(0xa3d39cff));
        colorHasher.put("hands", new Color(0xffcb8cff));
        colorHasher.put("necklace", new Color(0x10100fff));
        colorHasher.put("outline", new Color(0x10100fff));
        colorHasher.put("pants", new Color(0x8b7046ff));
        colorHasher.put("shirt_highlight", new Color(0x83ac7dff));
        colorHasher.put("shirt_main", new Color(0xa3d39cff));
        colorHasher.put("shoes", new Color(0x001efdff));
    }

    public void setKrystalColors() {
        colorHasher.put("belt", new Color(0x071ed0ff));
        colorHasher.put("buckle_bottom", new Color (0x12f7ffff));
        colorHasher.put("buckle_highlight_top", new Color (0x071ed0ff));
        colorHasher.put("buckle_mid", new Color (0x071ed0ff));
        colorHasher.put("buckle_mid_highlight", new Color (0x071ed0ff));
        colorHasher.put("buckle_top", new Color(0x071ed0ff));
        colorHasher.put("cleavage", new Color(0xf5dcd3ff));
        colorHasher.put("hands", new Color(0xf5dcd3ff));
        colorHasher.put("necklace", new Color(0xf5dcd3ff));
        colorHasher.put("outline", new Color(0x10100fff));
        colorHasher.put("pants", new Color(0x12f7ffff));
        colorHasher.put("shirt_highlight", new Color(0x0c1b90ff));
        colorHasher.put("shirt_main", new Color(0x071ed0ff));
        colorHasher.put("shoes", new Color(0xff1111ff));

    }

    public void drawMe (SpriteBatch batch, Vector2 loc, int frame, int direction) {
        for (int index = 0; index < body_pieces.length; index++) {
            String curr = body_pieces[index];
            spriteHasher.get(curr)[frame][direction].setSize(128, 128);
            spriteHasher.get(curr)[frame][direction].setPosition(loc.x - 64, loc.y);
            spriteHasher.get(curr)[frame][direction].setColor(colorHasher.get(curr));
            spriteHasher.get(curr)[frame][direction].draw(batch);
        }
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
