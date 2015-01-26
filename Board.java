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
		int distanceFromCenterX = Math.abs(x - 7);
		int distanceFromCenterY = Math.abs(y - 7);
		// Some pretty inventive ways of quickly adding tile modifiers to the board, if I do say so myself. 
		if (x % 7 == 0 && y % 7 == 0)
		    {
			board[x][y].setWBonus(3);
		    }
		if (distanceFromCenterX == 7 && distanceFromCenterY == 4 || distanceFromCenterX == 4 && distanceFromCenterY == 7)
		    {
			board[x][y].setLBonus(2);
		    }
		if (distanceFromCenterX == distanceFromCenterY && distanceFromCenterX > 2 && distanceFromCenterY < 7)
		    {
			board[x][y].setWBonus(2);
		    }
		if ( (x - 1) % 4 == 0 && distanceFromCenterY == 2 || (y - 1) % 4 == 0 && distanceFromCenterX == 2)
		    {
			board[x][y].setLBonus(3);
		    }
		if ( Math.abs(distanceFromCenterX - distanceFromCenterY) % 4 == 0 && (distanceFromCenterY < 2 || distanceFromCenterX < 2))
		    {
			board[x][y].setLBonus(2);
		    }
		if (x == 7 && y == 7)
		    {
			board[x][y].setCenter(true);
		    }
	    }
	}
    }
    
    // --- returns the Board
    public Tiles[][] getBoard() {
	return board;
    }
    public void setBoard(Tiles[][] b)
    {
	board = b;
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
	
	if (TileMode > 0 && word.length() > 1)
	    {
		if(checkWord(word))
		   {
		       if (TileMode == 7)
			   {
			       return WordPoints + 50;
			   }
		       else
			   {
			       return WordPoints;
			   }
		   }
		else
		    {
			// tells the rest of the components that the word isn't valid
			System.out.println(word);
			return -1;
		    }
			
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
	
	if (TileMode > 0 && word.length() > 1)
	    {
		if(checkWord(word))
		   {
		       if (TileMode == 7)
			   {
			       return WordPoints + 50;
			   }
		       else
			   {
			       return WordPoints;
			   }
		   }
		else
		    {
			// tells the rest of the components that the word isn't valid
			System.out.println(word);
			return -1;
		    }
			
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
		    if (getPointsV(x, y) == -1)
			{
			    System.out.println("Sorry, one of your words is not in the dictionary");
			    return -1;
			}
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
		    if (getPointsH(x, y) == -1)
			{
			    System.out.println("Sorry, one of your words is not in the dictionary");
			    return -1;
			}
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
