package com.thegame.dd.p4u1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.thegame.dd.p4u1.utils.Walker;

/*

TODO:
make editor that uses a grid format
save the editor data to files
make walker move to locations
use path finding to get from point to point
get to another room

 */

public class TheGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Walker walker;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("places/office_bg.png");
		walker = new Walker();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		walker.drawMe(batch, new Vector2(800,100), 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
