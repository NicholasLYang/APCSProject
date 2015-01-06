
public class Tiles {
    private int points;
    private int wordBonus, letterBonus = 1;
    private char letter;
    private LetterVal values;

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
