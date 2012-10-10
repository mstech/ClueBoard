package ClueGame;

public abstract class BoardCell {
	private int row, col;
	
	public abstract boolean isWalkaway();
	public abstract boolean isRoom();
	public abstract boolean isDoorway();
	
	public abstract void draw();
}
