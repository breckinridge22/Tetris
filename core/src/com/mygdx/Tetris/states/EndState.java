package com.mygdx.Tetris.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.Tetris.Tetris;

public class EndState extends State {
	
	private Texture gameOver;
	private int score;
	private BitmapFont font;

	public EndState(GameStateManager gsm, int score) {
		super(gsm);
		// TODO Auto-generated constructor stub
		gameOver = new Texture("GameOver.png");
		this.score = score;
		font = new BitmapFont();
	}

	@Override
	protected void handleInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
		batch.begin();
		batch.draw(gameOver, (Tetris.WIDTH/2 - gameOver.getWidth()/2), Tetris.HEIGHT - 350);
		font.draw(batch, "SCORE:", Tetris.WIDTH/2 -25, 400);
		font.draw(batch, Integer.toString(this.score), Tetris.WIDTH/2 - 8, 380);
		batch.end();
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		gameOver.dispose();
		font.dispose();
	}

}
