package ClueGame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ClueGame.RoomCell.DoorDirection;

public class Board {
		private ArrayList<BoardCell> cells;
		private Map<Character, String> rooms;
		private int numRows;
		private int numColumns;
		
		public Board() {
			cells = new ArrayList<BoardCell>();
			rooms = new HashMap<Character, String>();
			LoadConfigFiles();
		}
		
		public void LoadConfigFiles() {
			loadLegend();
			loadMap();
		}
		
		public void loadLegend() {
			try {
				Scanner in = new Scanner(new FileReader("legend.txt"));
				while(in.hasNext()) {
					String[] input;
					input = in.nextLine().split(",");
					if(input.length != 2) {
						throw new BadConfigFormatException();
					}
					rooms.put(input[0].charAt(0), input[1].trim());
				}
			} catch(FileNotFoundException e) {
				System.out.println("File not Found: legend.txt");
			} catch(BadConfigFormatException e) {
				System.out.println(e.getMessage());
			}
		}
		
		public void loadMap() {
			try {
				Scanner in  = new Scanner(new FileReader("board.csv"));
				int cols = 0;
				int rows = 0;
				while(in.hasNext()) {
					String[] input;
					input = in.nextLine().split(",");
					cols = input.length;
					rows++;
					for(String s : input) {
						if(s.equals("W")) {
							cells.add(new WalkwayCell());
						}
						else if( s.length() == 2) {
							if(s.charAt(1) == 'R' && rooms.containsKey(s.charAt(0))) {
								cells.add(new RoomCell(s.charAt(0), DoorDirection.RIGHT));
							}
							else if(s.charAt(1) == 'L' && rooms.containsKey(s.charAt(0))) {
								cells.add(new RoomCell(s.charAt(0), DoorDirection.LEFT));
							}
							else if(s.charAt(1) == 'U' && rooms.containsKey(s.charAt(0))) {
								cells.add(new RoomCell(s.charAt(0), DoorDirection.UP));
							}
							else if(s.charAt(1) == 'D' && rooms.containsKey(s.charAt(0))) {
								cells.add(new RoomCell(s.charAt(0), DoorDirection.DOWN));
							} else {
								throw new BadConfigFormatException();
							}
						}
						else if(s.length() == 1) {
							if(rooms.containsKey(s.charAt(0))) {
								cells.add(new RoomCell(s.charAt(0), DoorDirection.NONE));
							} else {
								throw new BadConfigFormatException();
							}
						} else {
							throw new BadConfigFormatException();
						}
					}
					
				}
				numRows = rows;
				numColumns = cols;
			} catch(FileNotFoundException e) {
				System.out.println("File not found: board.csv");
			} catch(BadConfigFormatException e) {
				System.out.println(e.getMessage());
			}
		}
		
		public int calcIndex(int row, int col) {
			return (row * numColumns) + col;
		}
		
		public BoardCell getCellAt(int index) {
			return cells.get(index);
		}
		
		public RoomCell getRoomCellAt(int row, int col) {
			BoardCell cell = getCellAt(calcIndex(row, col));
			if (cell.isRoom())
				return ((RoomCell) cell);
			return null;
		}

		public ArrayList<BoardCell> getCells() {
			return cells;
		}

		public Map<Character, String> getRooms() {
			return rooms;
		}

		public int getNumRows() {
			return numRows;
		}

		public int getNumColumns() {
			return numColumns;
		}
}
