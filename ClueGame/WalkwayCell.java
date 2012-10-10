package ClueGame;

public class WalkwayCell extends BoardCell {

	@Override
	public boolean isWalkaway() {
		return true;
	}

	@Override
	public boolean isRoom() {
		return false;
	}

	@Override
	public boolean isDoorway() {	
		return false;
	}

	@Override
	public void draw() {
		
	}

}
