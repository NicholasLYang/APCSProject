
public class Player {
    private int score;
    private String name;

    public Player(String n) {
	score = 0;
	name = n;
    }

    public int getScore() {
	return score;
    }

    public void placeLetter(Tiles[][] b, char l, int r, int c) {
	b.assignLetter(l, r, c);
    }

}
