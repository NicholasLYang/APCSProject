
public class Board {
    private Tiles[][] board;

    public Board() {
	board = new Tiles[15][15];
	for(int r=0; r<board.length;r++) {
	    for(int c=0; c<board.length; c++) {
	    //set something
	    }
	}
    }

    public void assignLetter(char l, int r, int c) {
	board[r][c].setLetter(l);
    }
}
