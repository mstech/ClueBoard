package ClueGame;

public class RoomCell extends BoardCell {

	public enum DoorDirection {
		UP, DOWN, LEFT, RIGHT, NONE;
	}
	
	private DoorDirection doorDirection;
	private char roomInitial;
	
	public RoomCell(char roomInitial, DoorDirection doorDirection) {
		this.doorDirection = doorDirection;
		this.roomInitial = roomInitial;
	}
	
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
		if(doorDirection != DoorDirection.NONE) {
			return true;
		}
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
