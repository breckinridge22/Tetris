package com.mygdx.Tetris;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.Tetris.states.GameStateManager;
import com.mygdx.Tetris.states.MenuState;


public class Tetris extends ApplicationAdapter {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Tetris";
	
	
	private GameStateManager gsm;
	private SpriteBatch batch;
	
	@Override
	public void create () {
		
		gsm = new GameStateManager();
		
		batch = new SpriteBatch();
		gsm.push(new MenuState(gsm));
		
	}
	
	@Override
	public void dispose(){
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
		
		batch.begin();
		//batch.draw(tetrominoes, 0, 0);
		batch.end();
	}
}
