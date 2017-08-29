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
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.thegame.dd.p4u1.characters.Character;
import com.thegame.dd.p4u1.characters.Paul;
import com.thegame.dd.p4u1.rooms.Office;
import com.thegame.dd.p4u1.rooms.Room;
import com.thegame.dd.p4u1.utils.Duple;
import com.thegame.dd.p4u1.utils.PaulGraphics;
import com.thegame.dd.p4u1.utils.Walker;

import java.util.ArrayList;
import java.util.Iterator;

/*

TODO:
make editor that uses a grid format
save the editor data to files
make walker move to locations
use path finding to get from point to point
get to another room

 */

public class TheGame extends ApplicationAdapter implements GestureDetector.GestureListener{
	SpriteBatch batch;

	OrthographicCamera camera;
	ShapeRenderer shapeRenderer;
	boolean showGrid = false;
	ArrayList<Character> characters;

	Office thisRoom;
	Paul paul;

	boolean tapping = false;
	Vector2 tap;

	ArrayList<Vector2> clicks;
	
	@Override
	public void create () {
        Gdx.input.setInputProcessor(new GestureDetector(this));
	    clicks = new ArrayList<Vector2>();
	    thisRoom = new Office();
	    paul = new Paul(thisRoom.getMap().origin.location);
	    characters = new ArrayList<Character>();
	    characters.add(paul);

		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, PaulGraphics.GAME_WIDTH, PaulGraphics.GAME_HEIGHT);
		shapeRenderer = new ShapeRenderer();
	}

	public void logic() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
            showGrid = !showGrid;
        }

		for(Iterator<Character> iter = characters.iterator(); iter.hasNext(); ) {
			Character curr = iter.next();
			curr.update();
		}

		if (tapping) {
            clicks.add(tap.cpy());
            paul.moveTo(PaulGraphics.pixelToDuple(tap.cpy()), thisRoom);
        	tapping = false;
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
        shapeRenderer.setColor(Color.RED);
        for (Iterator<Vector2> iter = clicks.iterator(); iter.hasNext();) {
            Vector2 coord = PaulGraphics.pixelToCoord(iter.next());
            shapeRenderer.circle(coord.x, coord.y, 3);
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
		for(Iterator<Character> iter = characters.iterator(); iter.hasNext(); ) {
			Character curr = iter.next();
			curr.drawMe(batch);
		}
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

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}


	@Override
	public boolean tap(float x, float y, int count, int button) {
		tapping = true;
		tap = new Vector2(x, y);
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}

	@Override
	public void pinchStop() {

	}
}
