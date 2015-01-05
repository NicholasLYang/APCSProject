
public class Tiles {
    private int points;
    private int wordBonus, letterBonus = 1;
    private letter;

    public Tiles() {
	points = 0;
    }
    public Tiles(int w, int l) {
	points = 0;
        wordBonus = w;
	letterBonus = l;
    }

    public int getPoints() {
	return points;
    }
    
    public void setPoints(int i) {
	points = points + i;
    }

    public int getWBonus() {
        return wordBonus;
    }

    public int getLBonus() {
	return letterBonus;
    }

}
