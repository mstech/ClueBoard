package ClueGame;

public class RoomCell extends BoardCell {

	public enum DoorDirection {
		UP, DOWN, LEFT, RIGHT;
	}
	
	private DoorDirection doorDirection;
	private char roomInitial;
	
	@Override
	public boolean isWalkaway() {
		return false;
	}

	@Override
	public boolean isRoom() {
		return true;
	}

	@Override
	public boolean isDoorway() {
		return false;
	}

	public DoorDirection getDoorDirection() {
		return doorDirection;
	}
	
	public char getInitial() {
		return roomInitial;
	}
	
	@Override
	public void draw() {
		
	}

}
