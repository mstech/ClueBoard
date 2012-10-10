package ClueGame;

public class BadConfigFormatException extends Exception {
	@Override
	public String toString() {
		return "Error reading config file.";
	}
}
