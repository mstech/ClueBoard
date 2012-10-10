package ClueGame;

public class RoomCell extends BoardCell {

	enum DoorDirection {
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

	@Override
	public void draw() {
		
	}

}
