package com.mygdx.Tetris.states;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.Tetris.Game;
import com.mygdx.Tetris.Tetris;
import com.mygdx.Tetris.Tetromino;

public class PlayState extends State {
	private Texture title;
	private Game game;
	private Tetromino tetromino;
	private Tetromino nextTet;
	private BitmapFont font;
	private ArrayList<Texture> blocks;
	
	private ShapeRenderer shapeRenderer;

	public PlayState(GameStateManager gsm) {
		super(gsm);
		game = new Game();
		tetromino = new Tetromino(0, 4);
		nextTet = new Tetromino(0,4);
		blocks = new ArrayList<>();
		fillBlocks();
		shapeRenderer = new ShapeRenderer();
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		title = new Texture("tetris.png");
	
		// TODO Auto-generated constructor stub
	}
	
	public void fillBlocks(){
		blocks.add(new Texture("block1.png"));
		blocks.add(new Texture("block2.png"));
		blocks.add(new Texture("block3.png"));
		blocks.add(new Texture("block4.jpeg"));
		blocks.add(new Texture("block5.jpeg"));
		blocks.add(new Texture("block6.png"));
		blocks.add(new Texture("block7.jpg"));
	}

	@Override
	protected void handleInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		handleInput();
		// change potential position
		tetromino.update(dt, game);
		// then check for collision
		
		
	
		
		
		if (tetromino.isLanded()){
			game.update(tetromino, dt);
			tetromino = nextTet;
			nextTet = new Tetromino(0,4);
			
		}
		
		if (game.gameOver){
			gsm.set(new EndState(gsm, game.getScore()));
			dispose();
		}

	}
	
	public boolean checkCollision(){
		for (int row = 0; row < tetromino.shape.length; row++) {
		    for (int col = 0; col < tetromino.shape[row].length; col++) {  	
		        if (tetromino.shape[row][col] != 0) {
			    	if (col + tetromino.potTopPosition[1] < 0){
			    		return true;
			    	}
			    	if (col + tetromino.potTopPosition[1] > game.grid[row].length){
			    		return true;
			    	}  
		            if (game.grid[row + (int)tetromino.potTopPosition[0]][col + (int)tetromino.potTopPosition[1]] != 0) {
		            	tetromino.landed = true;
		                return true;
		            }
		        }
		     }
		}
		return false;
	}
	

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.begin();
		batch.draw(title, (Tetris.WIDTH/2 - title.getWidth()/2), Tetris.HEIGHT - 250);
		font.draw(batch, "SCORE:", 400, 350);
		font.draw(batch, Integer.toString(game.getScore()), 500, 350);
		font.draw(batch, "LINES:", 402, 250);
		font.draw(batch, Integer.toString(game.getLinesCleared()), 500, 250);
	
		for (int row = 0; row < tetromino.shape.length; row++) {
		    for (int col = 0; col < tetromino.shape[row].length; col++) {
		        if (tetromino.shape[row][col] != 0) {
		            //draw block at position corresponding to 
		            //row + topLeft.row, and 
		            //col + topLeft.col
		        	batch.draw(blocks.get(tetromino.shape[row][col]-1), 330-(((game.grid[row].length-(col+tetromino.topPosition[1]))*30)), (480 - ((row + (int)tetromino.topPosition[0])*30)));
		        }
		     }
		}
		
		font.draw(batch, "Next Piece:", 420, 500);
		
		for (int row = 0; row < nextTet.shape.length; row++) {
		    for (int col = 0; col < nextTet.shape[row].length; col++) {
		        if (nextTet.shape[row][col] != 0) {
		        	batch.draw(blocks.get(nextTet.shape[row][col]-1), (600-(col+(int)nextTet.topPosition[1])*30), (430 - (row + (int)nextTet.topPosition[0])*30));
		        }
		    }
		}
		
		for (int row = 1; row < game.grid.length-1; row++) {
		    for (int col = 0; col < game.grid[row].length; col++) {
		        if (game.grid[row][col] != 0) {
		            batch.draw(blocks.get(game.grid[row][col]-1), (330-((game.grid[row].length-col)*30)), 480-((row*30)));
		        }
		     }
		}
		
		
		
		
		//batch.draw(tetromino.getTexture(), tetromino.getPosition().x, tetromino.getPosition().y);
		
		
		
		batch.end();

		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(1, 1, 1, 0);
		shapeRenderer.rect(30, 30, 300, 480);
		shapeRenderer.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		title.dispose();
		font.dispose();
	}

}
