
public class Tiles {
    private int points; // the amount of points the Tile is worth
    private int wordBonus, letterBonus = 1; // the bonuses that the Tile has
    private char letter; // the letter that is placed on the Tile
    private LetterVal values; // In order to convert the letter to an int value
    private boolean new; // To determine if the letter placed on the board is new

    public Tiles() {
	points = 0;
    }
    public Tiles(int w, int l) {
	points = 0;
        wordBonus = w;
	letterBonus = l;
    }

    //returns the amount of points that the Tile is worth
    public int getPoints() {
	return points;
    }
    
    //sets the Tile to a certain amount of points
    public void setPoints(int i) {
	points = points + i;
    }

    //returns Word Bonus
    public int getWBonus() {
        return wordBonus;
    }

    //returns Letter Bonus
    public int getLBonus() {
	return letterBonus;
    }

    //return letter
    public char getLetter() {
	return letter;
    }
    
    //set letter
    public void setLetter(char l) {
        setPoints(values.getVal(l));
	letter = l;
    }

}
