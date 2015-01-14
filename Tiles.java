
public class Tiles {
    private int points; // the amount of points the Tile is worth
    private int wordBonus, letterBonus = 1; // the bonuses that the Tile has
    private String letter = "A"; // the letter that is placed on the Tile
    private LetterVal values; // In order to convert the letter to an int value
    private boolean placed;
    private boolean visible;
<<<<<<< HEAD
=======
	
>>>>>>> 195701991b9193239f487367d5b086b52f19f850

    public Tiles() {
	points = 0;
	placed = false;
    }
    
    public Tiles(int w, int l, boolean p) {
	points = 0;
        wordBonus = w;
	letterBonus = l;
	placed = p;
    }
    // returns whether the tile's visible. Visible just mean's the tile's on the board. Placed mean's it's been scored
    public boolean getVisible()
    {
	return visible;
    }
    public void setVisible(boolean v)
    {
	visible = v;
    }
	    
    // returns whether the tile's been placed
    public boolean getPlaced()
    {
	return placed;
    }
    public void setPlaced(boolean b)
    {
	placed = b;
    }
    //returns the amount of points that the Tile is worth
    public int getPoints() {
	return points;
    }

    
    //sets the Tile to a certain amount of points
    public void setPoints(int i) {
	int newPoints = new int();
	newPoints = i;
	if(letterBonus) {
	    newPoints = i * letterBonus;
	}
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
	
        setPoints(values.getVal(l.charAt(1)));
	letter = l;
    }

}
