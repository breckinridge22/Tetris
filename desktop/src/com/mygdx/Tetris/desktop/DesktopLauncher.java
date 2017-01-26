package com.mygdx.Tetris.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.Tetris.Tetris;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.height = Tetris.HEIGHT;
		config.width = Tetris.WIDTH;
		config.title = Tetris.TITLE;
		
		new LwjglApplication(new Tetris(), config);
		
	}
}
