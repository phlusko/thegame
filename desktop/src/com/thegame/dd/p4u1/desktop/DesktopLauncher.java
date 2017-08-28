package com.thegame.dd.p4u1.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.thegame.dd.p4u1.TheGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "The Game";
		config.resizable = false;
		config.height = 800;
		config.width = 1600;
		new LwjglApplication(new TheGame(), config);
	}
}
