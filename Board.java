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
	sc = new Scanner("words.txt");
    }
    
    // --- returns the Board
    public Tiles[][] getBoard() {
	return board;
    }

    // --- Gives a Tile on the board a letter
    public void assignLetter(char l, int r, int c) {
	board[r][c].setLetter(l);
    }

    // --- Checks if the word made is valid
    public boolean checkWord(String word) {
	while(sc.hasNext()) {
	    if(sc.nextLine().equals(word)) {
		return true;
	    }
	}
	return false;
    }

    // --- Finds which words to calculate points for
    public int getWords() {
	// Lists of all the new tiles + total points
	ArrayList<int> x = new ArrayList<int>();
	ArrayList<int> y = new ArrayList<int>();
	int pointCalc = 0;

	// adds the coordinates of the new Tiles
	for(int i = 0; i<board.length; i++) {
	    for(int j = 0; j<board[i].length; j++) {
		if(board[i][j].getVisible() && board[i][j].getPlaced() == false) {
		    x.add(i);
		    y.add(j);
		}
	    }
	}

	// Checks the possibilities for words
	for(int index = 0;index<x.size(); index++) {

	    // Calculating Horizontal Word
	    int tmpx = x.get(index);
	    int tmpy = y.get(index);
	    String word = "";
	    int Wpoints = 0; // points per word
	    int bonus = 1;
	    
	    while(board[tmpx][tmpy] != null) {
		word = word + board[tmpx][tmpy];
		Wpoints = Wpoints + board[tmpx][tmpy].getPoints();
		bonus = bonus * board[tmpx][tmpy].getWBonus();
		tmpy++;
	    }
	    
	    if(checkWord(word)) {
	        Wpoints = Wpoints * bonus;
		points = points + Wpoints;
	    }

	    //Calculating Vertical Word
	    tmpx = x.get(index);
	    tmpy = y.get(index);
	    word = "";
	    Wpoints = 0; // points per word
	    bonus = 1;
	    
	    while(board[tmpx][tmpy] != null) {
		word = word + board[tmpx][tmpy];
		Wpoints = Wpoints + board[tmpx][tmpy].getPoints();
		bonus = bonus * board[tmpx][tmpy].getWBonus();
		tmpx++;
	    }
	    
	    if(checkWord(word)) {
	        Wpoints = Wpoints * bonus;
		points = points + Wpoints;
	    }
	}
    }

}
