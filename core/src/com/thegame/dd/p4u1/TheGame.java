package com.thegame.dd.p4u1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.thegame.dd.p4u1.rooms.Office;
import com.thegame.dd.p4u1.rooms.Room;
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

	Walker walker;
	OrthographicCamera camera;
	ShapeRenderer shapeRenderer;
	boolean showGrid = false;

	Office thisRoom;
	
	@Override
	public void create () {
	    thisRoom = new Office();
		batch = new SpriteBatch();
		walker = new Walker();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1000, 500);
		shapeRenderer = new ShapeRenderer();
	}

	public void logic() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
            showGrid = !showGrid;
        }
    }

    public void showGrid() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLACK);
        for (int i = 0; i < 1000; i+= 100) {
            shapeRenderer.line(i, 0, i,  500);
        }
        for (int j = 0; j < 500; j+= 100) {
            shapeRenderer.line(0, j, 1000,  j);
        }
        shapeRenderer.end();
    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		shapeRenderer.setProjectionMatrix(camera.combined);
		batch.begin();
		thisRoom.drawMe(batch);
		walker.drawMe(batch, new Vector2(800,100), 0, 0);
		batch.end();
		logic();
		if (showGrid) {
		    showGrid();
        }
	}
	
	@Override
	public void dispose () {
		batch.dispose();
        thisRoom.dispose();
    }
}
