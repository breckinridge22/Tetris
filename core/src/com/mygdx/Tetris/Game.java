package com.mygdx.Tetris;

import java.util.Arrays;

public class Game {
	public int [][] grid;
	private int linesCleared;
	private int score;
	public boolean gameOver;
	
	public Game(){
		grid = new int[17][10];
		
		for (int row = 0; row < grid.length-1; row ++){
			for (int col = 0; col < grid[row].length; col++){
				grid[row][col] = 0;
			}
		}
		
		for (int col = 0; col < grid[16].length; col++){
			grid[16][col] = 1;
		}
		gameOver = false;
		score = 0;
		linesCleared = 0;
	}
	
	public void update(Tetromino tetromino, float dt){

		for (int row = 0; row < tetromino.shape.length; row++) {
		    for (int col = 0; col < tetromino.shape[row].length; col++) {
		        if (tetromino.shape[row][col] != 0) {
		            grid[row + (int)tetromino.topPosition[0]][col + (int)tetromino.topPosition[1]] = tetromino.shape[row][col];
		        }
		     }
		}
		
		clearLines(dt);
		this.gameOver = isGameOver();
		
	}
	
	public int getScore(){
		return this.score;
	}
	
	public int getLinesCleared(){
		return this.linesCleared;
	}
	
	public int[][] getGrid(){
		return this.grid;
	}
	
	public boolean isLineCleared(int row){
		for (int col = 0; col < this.grid[row].length; col++){
			if (this.grid[row][col] == 0){
				return false;
			}
		}
		return true;
	}
	
	public void clearLines(float dt){
		for (int row = 0; row < this.grid.length-1; row++){
			if(isLineCleared(row)){
				
				int[][] top = new int[grid.length-(grid.length-row)][];
				
				for (int i = 0; i < top.length; i++){
					top[i] = this.grid[i].clone();
				}
				
				int k = 0;
				for (int col = 0; col < this.grid[k].length; col++){
					this.grid[k][col] = 0;
				}

				for (int i = 0; i < top.length; i++){
					this.grid[i+1] = top[i].clone();
				}
				
				linesCleared++;
				score += 100;
				
			}
		}
	}
	
	public boolean isGameOver(){
		int row = 0;
		for (int col = 0; col < this.grid[row].length; col++){
			if (this.grid[row][col] != 0){
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
