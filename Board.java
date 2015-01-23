import java.io.*;
import java.util.*;

public class Board {
    private Tiles[][] board;
    private Scanner sc;

    // --- Constructor
    public Board() {
	board = new Tiles[15][15];
	for(int x=0; x<board.length;x++) {
	    for(int y=0; y<board.length; y++) {
		board[x][y] = new Tiles();
	    }
	}
    }
    
    // --- returns the Board
    public Tiles[][] getBoard() {
	return board;
    }

    // --- Gives a Tile on the board a letter
    public void assignLetter(String l, int x, int y) {
	board[x][y].setLetter(l);
	board[x][y].setTileMode(2);
    }

    // --- Checks if the word made is valid
    public boolean checkWord(String word) {
	File file = new File("words.txt");
        try {
	    sc = new Scanner(file);
	    while(sc.hasNextLine()) {
		if(sc.nextLine().equals(word)) {
		    return true;
		}
	    }
	}
	catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	return false;
    }

    public int getPointsH(int xcoor, int ycoor) {
	String word = "";
	int x = xcoor;
	int y = ycoor;
	int WordPoints = 0;
	int bonus = 1;
        int TileMode = 0;

	while(board[x][y].getTileMode() != 0) {
	    if(board[x][y].getTileMode() == 2) { TileMode++; }
	    word = word + board[x][y].getLetter();
	    WordPoints = WordPoints + board[x][y].getPoints();
	    bonus = bonus * board[x][y].getWBonus();
	    x++;
	}
	WordPoints = WordPoints * bonus;
	
        if(checkWord(word) && TileMode > 0) {
	    if( TileMode == 7) {
		return Wordpoints + 50;
	    }
	    return WordPoints;
	}
	return 0;
    }

    public int getPointsV(int xcoor, int ycoor) {
	String word = "";
	int x = xcoor;
	int y = ycoor;
	int WordPoints = 0;
	int bonus = 1;
        int TileMode = 0;

	while(board[x][y].getTileMode() != 0) {
	    if(board[x][y].getTileMode() == 2) { TileMode++; }
	    word = word + board[x][y].getLetter();
	    WordPoints = WordPoints + board[x][y].getPoints();
	    bonus = bonus * board[x][y].getWBonus();
	    y++;
	}
	WordPoints = WordPoints * bonus;
	
	if(checkWord(word) && TileMode > 0) {
	    if( TileMode == 7) {
		return WordPoints + 50;
	    }
	    return WordPoints;
	}
	return 0;
    }
    // --- Finds which words to calculate points for
    public int getPoints() {
        int points = 0;
	boolean empty = true;
	
	for(int x = 0; x < board.length; x++) {
	    for(int y  = 0; y < board[x].length; y++) {
		if(empty && board[x][y].getTileMode() != 0) {
		    points = points + getPointsV(x, y);
		    empty = false;
		} else if(board[x][y].getTileMode() == 0) {
		    empty = true;
		}
	    }
	}
	
	empty = true;
	for(int y = 0; y < board.length; y++) {
	    for(int x = 0; x < board[y].length; x++) {
		if(empty && board[x][y].getTileMode() != 0) {
		    points = points + getPointsH(x, y);
		    empty = false;
		} else if(board[x][y].getTileMode() == 0) {
		    empty = true;
		}
	    }
	}
	
	return points;
    }

    /*
    // --- FOR TESTING PURPOSES

    public String getLetter(int x, int y) {
	return board[x][y].getLetter();
    }

    public Tiles getTile(int x, int y) {
	return board[x][y];
    }

    public static void main(String[] args) {
	Board board = new Board();
	board.assignLetter("H",1,1);
	board.assignLetter("E",2,1);
	board.assignLetter("L",3,1);
	board.assignLetter("L",4,1);
	board.assignLetter("O",5,1);	
	System.out.println(board.getPoints());
    }
    */
    

}
