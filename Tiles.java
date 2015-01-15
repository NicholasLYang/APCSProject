
public class Tiles {
    private int points;
    private int wordBonus, letterBonus = 1;
    private String letter = "A";
    private LetterVal values;
    private boolean placed;
    private boolean visible;


      

    public Tiles() {
	points = 0;
	placed = false;
	visible = false;
	values = new LetterVal();
    }
    
    public Tiles(int w, int l, boolean p) {
	points = 0;
        wordBonus = w;
	letterBonus = l;
	visible = false;
	placed = p;
    }
    // Visible just mean's the tile's on the board. Placed mean's it's been scored
    public boolean getVisible() {
	return visible;
    }
    public void setVisible(boolean v) {
	visible = v;
    }
	    
    // returns whether the tile's been placed
    public boolean getPlaced() {
	return placed;
    }
    public void setPlaced(boolean b) {
	placed = b;
    }
    
    //returns the amount of points that the Tile is worth
    public int getPoints() {
	return points;
    }

    
    //sets the Tile to a certain amount of points
    public void setPoints(int i) {
	int newPoints = 0;
	newPoints = i;
	newPoints = i * letterBonus;
	points = points + newPoints;
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
    public String getLetter() {
	return letter;
    }
    
    //set letter
    public void setLetter(String l) {
	setPoints(values.getVal(l.charAt(0)));
	letter = l;
	visible = true;
    }

}
