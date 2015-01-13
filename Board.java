import java.io.*;

public class Board {
    private Tiles[][] board;

    public Board() {
	board = new Tiles[15][15];
	for(int r=0; r<board.length;r++) {
	    for(int c=0; c<board.length; c++) {
		board[r][c] = new Tiles();
	    }
	}
    }
    
    public Tiles[][] getBoard() {
	return board;
    }

    public void assignLetter(char l, int r, int c) {
	board[r][c].setLetter(l);
    }

   /*
    public int getWords() {
	
    }

    */
}
