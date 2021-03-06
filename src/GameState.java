import java.util.*;


public class GameState {
	private int position[];
	
	private Direction direction;
	
	private int heuristic;
	
	//private int fValue;
	private boolean hasRaft;
	private boolean onWater;
	private int dynamite;
	
	private String movesSoFar;
	private int fMoves;
	
	public GameState(int x, int y, Direction d, boolean raft, boolean water, int dyn){
		position = new int[2];
		position[0] = x; position[1] = y;
		direction = d;
		heuristic = 0;
		
		hasRaft = raft;
		onWater = water;
		dynamite = dyn;
		
		movesSoFar = "";
		fMoves = 0;
	}
	public GameState(int x, int y, Direction d, boolean raft, boolean water, int dyn, String moves, int f){
		position = new int[2];
		position[0] = x; position[1] = y;
		direction = d;
		heuristic = 0;
		
		hasRaft = raft;
		onWater = water;
		dynamite = dyn;
		
		movesSoFar = moves;
		fMoves = f;
	}
	public GameState(int x, int y, Direction d){
		position = new int[2];
		position[0] = x; position[1] = y;
		direction = d;
		heuristic = 0;
		hasRaft = false;
		onWater = false;
		dynamite = 0;
		movesSoFar = "";
		fMoves = 0;
	}
	public GameState(int x, int y, Direction d, String s){
		position = new int[2];
		position[0] = x; position[1] = y;
		direction = d;
		heuristic = 0;
		hasRaft = false;
		onWater = false;
		dynamite = 0;
		movesSoFar = s;
	}
	
	public void calculateHeuristic(int[] goal){
		heuristic = Math.abs(position[0]-goal[0])+Math.abs(position[1]-goal[1]);
	}
	
	public void setHeuristic(int h){
		heuristic = h;
	}
	
	public int getFValue(){
		return heuristic+fMoves;
	}
	
	public int getHValue(){
		return heuristic;
	}
	
	public boolean checkGoal(int[] goal){
		return (position[0] == goal[0] && position[1] == goal[1]);
	}
	public Direction getDirection(){
		return direction;
	}
	public int[] getPosition(){
		return position;
	}
	public String getMoves(){
		return movesSoFar;
	}
	
	public GameState[] generateNeighbours(){
		GameState[] gameStates = new GameState[4];
		
		//forward
		int[] vf = direction.getVector1();
		gameStates[0] = new GameState(position[0]+vf[0], position[1]+vf[1], direction, movesSoFar+"f");
		
		//left
		Direction relativeLeft = direction.copy().turnLeft();
		int[] vl = relativeLeft.getVector1();
		gameStates[1] = new GameState(position[0]+vl[0], position[1]+vl[1], relativeLeft, movesSoFar+"lf");
		
		//right
		Direction relativeRight = direction.copy().turnRight();
		int[] vr = relativeRight.getVector1();
		gameStates[2] = new GameState(position[0]+vr[0], position[1]+vr[1], relativeRight, movesSoFar+"rf");
		
		//backwards
		Direction relativeBack = direction.copy().turnLeft().turnLeft();
		int[] vb = relativeBack.getVector1();
		gameStates[3] = new GameState(position[0]+vb[0], position[1]+vb[1], relativeBack, movesSoFar+"llf");
		
		return gameStates;	
	}
	
	public GameState openDoor(){
		return new GameState(position[0], position[1], direction, movesSoFar+"u");
	}
	
	public boolean hasRaft(){
		return hasRaft;
	}
	
	public boolean onWater(){
		return onWater;
	}
	
	public int numDynamite(){
		return dynamite;
	}
	
	public int getFMoves(){
		return fMoves;
	}

}
