package com.mygdx.Tetris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;


public class Tetromino {
	
	public static int fall_velocity = 1;
	
	public static final Integer I = 1;
	public static final Integer O = 2;
	public static final Integer T = 3;
	public static final Integer L = 4;
	public static final Integer J = 5;
	public static final Integer S = 6;
	public static final Integer Z = 7;

	public int [][] Ishape1 = {
			{0, 0 ,0, 0},
			{1, 1, 1, 1}, 
			{0, 0, 0, 0},
			{0, 0, 0, 0}
	};
	
	public int [][] Ishape2 = {
			{0, 0, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 1, 0}
	};
	
	public int [][] Ishape3 = {
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{1, 1, 1, 1},
			{0, 0, 0, 0}	
	};
	
	public int [][] Ishape4 = {
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 1, 0, 0}
	};
	
	public int [][] Oshape = {
			
		{0, 2, 2, 0},
		{0, 2, 2, 0},
		{0, 0, 0, 0},
		{0, 0, 0, 0}
			
	};
	
	public int[][] Tshape1 = {
				{0, 3, 0, 0},
				{3, 3, 3, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
	};
	
	public int[][] Tshape2 = {
			{0, 3, 0, 0},
			{0, 3, 3, 0},
			{0, 3, 0, 0},
			{0, 0, 0, 0}	
	};
	
	public int[][] Tshape3 = {
			{0, 0, 0, 0},
			{3, 3, 3, 0},
			{0, 3, 0, 0},
			{0, 0, 0, 0}	
	};
	
	public int[][] Tshape4 = {
			{0, 3, 0, 0},
			{3, 3, 0, 0},
			{0, 3, 0, 0},
			{0, 0, 0, 0}
	};
	
	public int[][] Lshape1 = {
				{0, 0, 4, 0},
				{4, 4, 4, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
	};
	
	public int[][] Lshape2 = {
			{0, 4, 0, 0},
			{0, 4, 0, 0},
			{0, 4, 4, 0},
			{0, 0, 0, 0}
	};
	
	public int[][] Lshape3 = {
			{0, 0, 0, 0},
			{4, 4, 4, 0},
			{4, 0, 0, 0},
			{0, 0, 0, 0}
	};
	
	public int[][] Lshape4 = {
			{4, 4, 0, 0},
			{0, 4, 0, 0},
			{0, 4, 0, 0},
			{0, 0, 0, 0}	
	};
	
	public int[][] Jshape1 = {
				{5, 0, 0, 0},
				{5, 5, 5, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
	};
	
	public int[][] Jshape2 = {
			{0, 5, 5, 0},
			{0, 5, 0, 0},
			{0, 5, 0, 0},
			{0, 0, 0, 0}	
	};
	
	public int[][] Jshape3 = {
			{0, 0, 0, 0},
			{5, 5, 5, 0},
			{0, 0, 5, 0},
			{0, 0, 0, 0}	
	};
	
	public int[][] Jshape4 = {
			{0, 5, 0, 0},
			{0, 5, 0, 0},
			{5, 5, 0, 0},
			{0, 0, 0, 0}	
	};
	
	public  int[][] Sshape1 = {
				{0, 6, 6, 0},
				{6, 6, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
	};
	
	public int[][] Sshape2 = {
			{0, 6, 0, 0},
			{0, 6, 6, 0},
			{0, 0, 6, 0},
			{0, 0, 0, 0}
	};
	
	public int[][] Sshape3 = {
			{0, 0, 0, 0},
			{0, 6, 6, 0},
			{6, 6, 0, 0},
			{0, 0, 0, 0}	
	};
	
	public int[][] Sshape4 = {
			{6, 0, 0, 0},
			{6, 6, 0, 0},
			{0, 6, 0, 0},
			{0, 0, 0, 0}
	};
	
	
	public static int[][] Zshape1 = {
				{7, 7, 0, 0},
				{0, 7, 7, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
	};
	
	public int[][] Zshape2 = {
			{0, 0, 7, 0},
			{0, 7, 7, 0},
			{0, 7, 0, 0},
			{0, 0, 0, 0}
	};
	
	public int[][] Zshape3 = {
			{0, 0, 0, 0},
			{7, 7, 0, 0},
			{0, 7, 7, 0},
			{0, 0, 0, 0}	
	};
	
	public int[][] Zshape4 = {
			{0, 7, 0, 0},
			{7, 7, 0, 0},
			{7, 0, 0, 0},
			{0, 0, 0, 0}
	};
	
	private void fillShapes(){
		possibleShapes.add(Ishape1);
		possibleShapes.add(Oshape);
		possibleShapes.add(Tshape1);
		possibleShapes.add(Lshape1);
		possibleShapes.add(Jshape1);
		possibleShapes.add(Sshape1);
		possibleShapes.add(Zshape1);
	}
	
	public static ArrayList<int[][]> Ishapes = new ArrayList<>();
	public static ArrayList<int[][]> Oshapes = new ArrayList<>();
	public static ArrayList<int[][]> Tshapes = new ArrayList<>();
	public static ArrayList<int[][]> Lshapes = new ArrayList<>();
	public static ArrayList<int[][]> Jshapes = new ArrayList<>();
	public static ArrayList<int[][]> Sshapes = new ArrayList<>();
	public static ArrayList<int[][]> Zshapes = new ArrayList<>();
	
	private void populateShapes(){
		Ishapes.add(Ishape1);
		Ishapes.add(Ishape2);
		Ishapes.add(Ishape3);
		Ishapes.add(Ishape4);
		Oshapes.add(Oshape);
		Oshapes.add(Oshape);
		Oshapes.add(Oshape);
		Oshapes.add(Oshape);
		Tshapes.add(Tshape1);
		Tshapes.add(Tshape2);
		Tshapes.add(Tshape3);
		Tshapes.add(Tshape4);
		Lshapes.add(Lshape1);
		Lshapes.add(Lshape2);
		Lshapes.add(Lshape3);
		Lshapes.add(Lshape4);
		Jshapes.add(Jshape1);
		Jshapes.add(Jshape2);
		Jshapes.add(Jshape3);
		Jshapes.add(Jshape4);
		Sshapes.add(Sshape1);
		Sshapes.add(Sshape2);
		Sshapes.add(Sshape3);
		Sshapes.add(Sshape4);
		Zshapes.add(Zshape1);
		Zshapes.add(Zshape2);
		Zshapes.add(Zshape3);
		Zshapes.add(Zshape4);
	}
	
	private void fillArray(){
		listOfShapes[0] = Ishapes;
		listOfShapes[1] = Oshapes;
		listOfShapes[2] = Tshapes;
		listOfShapes[3] = Lshapes;
		listOfShapes[4] = Jshapes;
		listOfShapes[5] = Sshapes;
		listOfShapes[6] = Zshapes;
	}
	
	private ArrayList<int[][]> possibleShapes = new ArrayList<>();
	private ArrayList[] listOfShapes = new ArrayList[7];
	private Random rand = new Random();
	public boolean landed;
	public ArrayList<int[][]> shapes;
	public int[][] shape;
	public int[][] nextRotation;
	public float[] topPosition;
	public float[] potTopPosition;
	int rotation;
	
	
	public Tetromino(int x, int y){
		rotation = 0;
		populateShapes();
		fillArray();
		fillShapes();
		this.topPosition = new float[]{x,y};
		this.potTopPosition = new float[]{x,y};
		pickRandomShape();
		this.landed = false;
	}
	
	private void pickRandomShape(){
		int r = rand.nextInt(7);
		this.shapes = new ArrayList(listOfShapes[r]);
		this.shape = new int[4][4];
		this.nextRotation = new int[4][4];
		this.shape = this.shapes.get(rotation);
		this.nextRotation = this.shapes.get(rotation+1);
	}
	
	public void update(float dt, Game game){
		handleInput(game);
		fall(game);
		
	}
	
	
	// deal with the input of the user as long as there are no collisions
	public void handleInput(Game game){
		if (Gdx.input.isKeyJustPressed(Keys.LEFT) && inBounds()){
			
			this.potTopPosition[1]--;
			
		} else if (Gdx.input.isKeyJustPressed(Keys.RIGHT)){
			
			this.potTopPosition[1]++;
			
		}else if (Gdx.input.isKeyPressed(Keys.DOWN)){
			this.potTopPosition[0]++;
		}else if (Gdx.input.isKeyJustPressed(Keys.UP)){
			
			if (!checkRotationCollision()){
				
				this.shape = this.shapes.get(++rotation);
				
				if (rotation == 3){
					
					this.nextRotation = this.shapes.get(0);
					rotation = -1;
					
				} else {
					
					this.nextRotation = this.shapes.get(rotation+1);
				}
			}
		}
		
		if (!checkCollision(game)){
			this.topPosition[0] = this.potTopPosition[0];
			this.topPosition[1] = this.potTopPosition[1];
		} else {
			this.potTopPosition[0] = this.topPosition[0];
			this.potTopPosition[1] = this.topPosition[1];
		}
	}
	
	public boolean checkCollision(Game game){
		for (int row = 0; row < this.shape.length; row++) {
		    for (int col = 0; col < this.shape[row].length; col++) {  	
		        if (this.shape[row][col] != 0) {
			    	if (col + this.potTopPosition[1] < 0){
			    		return true;
			    	}
			    	if (col + this.potTopPosition[1] > game.grid[row].length-1){
			    		return true;
			    	}  
		            if (game.grid[row + (int)this.potTopPosition[0]][col + (int)this.potTopPosition[1]] != 0) {
		            	this.landed = true;
		                return true;
		            }
		        }
		     }
		}
		return false;
	}
	
	
	
public boolean checkRotationCollision(){
		
		for (int row = 0; row < this.nextRotation.length; row++) {
		    for (int col = 0; col < this.nextRotation[row].length; col++) {  	
		        if (this.nextRotation[row][col] != 0) {
			    	if (col + this.potTopPosition[1] < 0){
			    		return true;
			    	}
			    	if (col + this.potTopPosition[1] > 9){
			    		return true;
			    	}  
		        }
		     }
		}
		return false;
	}
	
	
	
	public boolean inBounds(){
		if (this.potTopPosition[0] < 0 || this.potTopPosition[0] > 15){
			return false;
		} 
		if (this.potTopPosition[1] < 0 || this.potTopPosition[1] > 9){
			return false;
		}
		return true;
	}
	
	public void fall(Game game){
		this.potTopPosition[0] += .05;
		if (!checkCollision(game)){
			this.topPosition[0] = this.potTopPosition[0];
			this.topPosition[1] = this.potTopPosition[1];
		} else {
			this.potTopPosition[0] = this.topPosition[0];
			this.potTopPosition[1] = this.topPosition[1];
		}
	}
	
	public boolean isLanded(){
		return this.landed;
	}
	
}
	
