import java.util.Random;

public class Computer {

	private String playerNumber;
	private String difficulty;
	private int compNum;
	private int rowSize = 3;
	private int colSize = 3;
	private Random rn = new Random();
	private int[][] modBoard = new int[rowSize][colSize]; //Modified tic tac toe board

	Computer(String playerNumber, String difficulty) {
		this.playerNumber = playerNumber;
		this.difficulty = difficulty;
		if (playerNumber.equals("Player 1")) {
			compNum = 0;
		} else {
			compNum = 1;
		}
	}

	public int[][] calcMove(int[][] boardArray) {

		Move move = checkThree(boardArray);
		if (move.getCheckThree()) {
			boardArray = move.getBoardArray();
		} else {
			boolean interfere = true;
			while (interfere) {
				int r = rn.nextInt(rowSize);
				int c = rn.nextInt(colSize);
				if ((boardArray[r][c] == -1)) {
					modBoard[r][c] = compNum;
					interfere = false;
					String[][] symbolModBoard = convSymbol(boardArray);
					System.out.println(symbolModBoard[0][0] + "|" + symbolModBoard[0][1] + "|" + symbolModBoard[0][2]);
					System.out.println(symbolModBoard[1][0] + "|" + symbolModBoard[1][1] + "|" + symbolModBoard[1][2]);
					System.out.println(symbolModBoard[2][0] + "|" + symbolModBoard[2][1] + "|" + symbolModBoard[2][2]);
					System.out.println();
				}
			}
		}
		return modBoard;
	}

	public Move checkThree(int[][] boardArray) {
		String[][] boardSymbols = convSymbol(boardArray);
		int[][] copyBoard = boardArray;

		String row1 = boardSymbols[0][0] + boardSymbols[0][1] + boardSymbols[0][2];
		String row2 = boardSymbols[1][0] + boardSymbols[1][1] + boardSymbols[1][2];
		String row3 = boardSymbols[2][0] + boardSymbols[2][1] + boardSymbols[2][2];
		String col1 = boardSymbols[0][0] + boardSymbols[1][0] + boardSymbols[2][0];
		String col2 = boardSymbols[0][1] + boardSymbols[1][1] + boardSymbols[2][1];
		String col3 = boardSymbols[0][2] + boardSymbols[1][2] + boardSymbols[2][2];
		String dgl1 = boardSymbols[0][0] + boardSymbols[1][1] + boardSymbols[2][2];
		String dgl2 = boardSymbols[0][2] + boardSymbols[1][1] + boardSymbols[2][0];

		boolean isThree = false;
		int[] coords = new int[2];
		coords[0] = -1; //Initialize the value to a non-altered default
			//Determine combinations of Three
				//Row 1
				if (row1.equals(" OO") || row1.equals(" XX")) {
					coords[0] = 0;
					coords[1] = 0;
				} else if (row1.equals("O O") || row1.equals("X X")) {
					coords[0] = 0;
					coords[1] = 1;
				} else if (row1.equals("OO ") || row1.equals("XX ")) {
					coords[0] = 0;
					coords[1] = 2;
				//Row 2
				} else if (row2.equals(" OO") || row2.equals(" XX")) {
					coords[0] = 1;
					coords[1] = 0;
				} else if (row2.equals("O O") || row2.equals("X X")) {
					coords[0] = 1;
					coords[1] = 1;
				} else if (row2.equals("OO ") || row2.equals("XX ")) {
					coords[0] = 1;
					coords[1] = 2;
				//Row 3
				} else if (row3.equals(" OO") || row3.equals(" XX")) {
					coords[0] = 1;
					coords[1] = 0;
				} else if (row3.equals("O O") || row3.equals("X X")) {
					coords[0] = 1;
					coords[1] = 1;
				} else if (row3.equals("OO ") || row3.equals("XX ")) {
					coords[0] = 1;
					coords[1] = 2;
				//Column 1
				} else if (col1.equals("OO ") || col1.equals("XX ")) {
					coords[0] = 2;
					coords[1] = 0;
				} else if (col1.equals("O O") || col1.equals("X X")) {
					coords[0] = 1;
					coords[1] = 0;
				} else if (col1.equals(" OO") || col1.equals(" XX")) {
					coords[0] = 0;
					coords[1] = 0;
				//Column 2
				} else if (col2.equals("OO ") || col2.equals("XX ")) {
					coords[0] = 2;
					coords[1] = 1;
				} else if (col2.equals("O O") || col2.equals("X X")) {
					coords[0] = 1;
					coords[1] = 1;
				} else if (col2.equals(" OO") || col2.equals(" XX")) {
					coords[0] = 0;
					coords[1] = 1;
				//Column 3
				} else if (col3.equals("OO ") || col3.equals("XX ")) {
					coords[0] = 2;
					coords[1] = 2;
				} else if (col3.equals("O O") || col3.equals("X X")) {
					coords[0] = 1;
					coords[1] = 2;
				} else if (col3.equals(" OO") || col3.equals(" XX")) {
					coords[0] = 0;
					coords[1] = 2;
				//Diagonal 1
				} else if (dgl1.equals("OO ") || dgl1.equals("XX ")) {
					coords[0] = 2;
					coords[1] = 2;
				} else if (dgl1.equals("O O") || dgl1.equals("X X")) {
					coords[0] = 1;
					coords[1] = 1;
				} else if (dgl1.equals(" OO") || dgl1.equals(" XX")) {
					coords[0] = 0;
					coords[1] = 0;
				//Diagonal 2
				} else if (dgl1.equals("OO ") || dgl1.equals("XX ")) {
					coords[0] = 2;
					coords[1] = 0;
				} else if (dgl1.equals("O O") || dgl1.equals("X X")) {
					coords[0] = 1;
					coords[1] = 1;
				} else if (dgl1.equals(" OO") || dgl1.equals(" XX")) {
					coords[0] = 0;
					coords[1] = 2;
				}

		Move move; //Initialize the move variable
		if (!(coords[0] == -1)) {
			isThree = true;

			if (compNum == 0) {
				copyBoard[coords[0]][coords[1]] = 0;
			} else {
				copyBoard[coords[0]][coords[1]] = 1;
			}

			move = new Move(isThree, copyBoard);
		} else {
			move = new Move(isThree);
		}

		return move;
	}

	public String[][] convSymbol(int[][] boardArray) {
		String[][] boardSymbols = new String[rowSize][colSize];
		for (int r = 0; r < rowSize; r++) {
			for (int c = 0; c < colSize; c++) {
				if ((boardArray[r][c]) == 0) {
					boardSymbols[r][c] = "O";
				} else if ((boardArray[r][c]) == 1) {
					boardSymbols[r][c] = "X";
				} else {
					boardSymbols[r][c] = " ";
				}
			}
		}
		return boardSymbols;
	}

	public int getCompNum() {
		return compNum;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public String getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(String newPlayerNum) {
		playerNumber = newPlayerNum;
		if (playerNumber.equals("Player 1")) {
			compNum = 1;
		} else {
			compNum = 0;
		}
	}

	public void setDifficulty(String newDifficulty) {
		difficulty = newDifficulty;
	}
}

class Move {

	private boolean checkThree;
	private int[][] boardArray;

	public Move(boolean checkThree, int[][] boardArray) {
		checkThree = this.checkThree;
		boardArray = this.boardArray;
	}

	public Move(boolean checkThree) {
		checkThree = this.checkThree;
	}

	public boolean getCheckThree() {
		return checkThree;
	}

	public int[][] getBoardArray() {
		return boardArray;
	}
}