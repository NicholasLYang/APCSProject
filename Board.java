import java.io.*;
import java.util.*;

public class Board {
    private Tiles[][] board;
    private Scanner sc;

    // --- Constructor
    public Board() {
	board = new Tiles[15][15];
	for(int r=0; r<board.length;r++) {
	    for(int c=0; c<board.length; c++) {
		board[r][c] = new Tiles();
	    }
	}
    }
    
    // --- returns the Board
    public Tiles[][] getBoard() {
	return board;
    }

    // --- Gives a Tile on the board a letter
    public void assignLetter(String l, int r, int c) {
	board[r][c].setLetter(l);
	board[r][c].setTileMode(2);
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

	while(board[x][y].getTileMode() != 0) {
	    word = word + board[x][y].getLetter();
	    WordPoints = WordPoints + board[x][y].getPoints();
	    bonus = bonus * board[x][y].getWBonus();
	    x++;
	}
	WordPoints = WordPoints * bonus;
	
        if(checkWord(word)) {
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

	while(board[x][y].getTileMode() != 0) {
	    word = word + board[x][y].getLetter();
	    WordPoints = WordPoints + board[x][y].getPoints();
	    bonus = bonus * board[x][y].getWBonus();
	    y++;
	}
	WordPoints = WordPoints * bonus;
	
	if(checkWord(word)) {
	    return WordPoints;
	}
	return 0;
    }

    // --- Finds which words to calculate points for
    public int getPoints() {
        int points = 0;
	
	for(int x=0; x<board.length; x++) {
	    for(int y = 0; y<board.length; y++) {
		if(board[x][y].getTileMode()==2) {
		    points = points + getPointsH(x, y);
		    points = points + getPointsV(x, y);
		    board[x][y].setTileMode(3);
		}
	    }
	}
	return points;
    }

    // For testing purposes
    public static void main(String[] args) {
	Board board = new Board();
	board.assignLetter("H",1,2);
	board.assignLetter("E",1,3);
	board.assignLetter("L",1,4);
	board.assignLetter("L",1,5);
	board.assignLetter("O",1,6);
	System.out.println(board.getPoints());
    }

}
