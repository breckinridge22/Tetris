package com.mygdx.Tetris.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.Tetris.Tetris;

public class MenuState extends State {
	
	private Texture title;
	private Texture playBtn;

	public MenuState(GameStateManager gsm) {
		super(gsm);
		title = new Texture("Tetris.png");
		playBtn = new Texture("playBtn.png");
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		if (Gdx.input.justTouched()){
			gsm.set(new PlayState(gsm));
			dispose();
		}
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		handleInput();
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.begin();
		batch.draw(title, (Tetris.WIDTH/2 - title.getWidth()/2), Tetris.HEIGHT - 250);
		batch.draw(playBtn,  Tetris.WIDTH/2 - playBtn.getWidth()/2,  Tetris.HEIGHT/2 - 50);
		batch.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		title.dispose();
		playBtn.dispose();
	}

}
