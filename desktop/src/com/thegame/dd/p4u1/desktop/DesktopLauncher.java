package com.thegame.dd.p4u1.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.thegame.dd.p4u1.TheGame;
import com.thegame.dd.p4u1.utils.PaulGraphics;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "The Game";
		config.resizable = false;
		config.height = (int)PaulGraphics.GAME_HEIGHT;
		config.width = (int)PaulGraphics.GAME_WIDTH;
		new LwjglApplication(new TheGame(), config);
	}
}
