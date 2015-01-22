
public class Tiles {
    private int points;
    private int wordBonus, letterBonus = 1;
    private String letter = "A";
    private LetterVal values;
    private int tileMode;
    private int tileX;
    private int tileY;
	
    // --- CONSTRUCTORS --- //
    public Tiles() {
	points = 0;
	tileMode = 0;
	values = new LetterVal();
	wordBonus = 1;
	letterBonus = 1;
    }
    public Tiles(int w, int l, int t) {
	points = 0;
        wordBonus = w;
	letterBonus = l;
	tileMode = t;
    }


    public Tiles(String l) {
	points = 0;
	tileMode = 0;
	values = new LetterVal();
	wordBonus = 1;
	letterBonus = 1;
        setLetter(l);
    }

    // --- resets Tile
    public void clear()
    {
	points = 0;
	letter = new String();
    }

    // --- COORDINATES --- //
    public void setTileCoords (int x, int y) {

	tileX = x;
	tileY = y;
    }
    public int getTileX() {
	return tileX;
    }
    public int getTileY() {
	return tileY;
    }


    // --- TILE MODE --- //
    /* 
       tileMode determines whether a tile is selected (to be moved),
       visible (on the board but not scored) or 
       scored (not movable and already played) 
       Invisible = 0
       Selected = 1
       Visible = 2
       Scored = 3
    */
    public int getTileMode()
    {
	return tileMode;
    }
    public void setTileMode(int t)
    {
	tileMode = t;
    }
	
    // --- POINTS AND SCORING --- //
    //returns the amount of points that the Tile is worth
    public int getPoints() {
	return points;
    }

    //sets the Tile to a certain amount of points
    public void addPoints(int i) {
	int newPoints = 0;
	newPoints = i;
	newPoints = i * letterBonus;
	points = points + newPoints;
    }
    public void setPoints(int p)
    {
	points = p;
    }
	    
    // --- BONUSES --- //
    //returns Word Bonus
    public int getWBonus() {
        return wordBonus;
    }

    //returns Letter Bonus
    public int getLBonus() {
	return letterBonus;
    }

    // --- SETTING LETTERS --- //
    //return letter
    public String getLetter() {
	return letter;
    }
    
    //set letter
    public void setLetter(String l) {
	setPoints(values.getVal(l.charAt(0)));
	letter = l;
	
    }
}
