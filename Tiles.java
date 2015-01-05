
public class Tiles {
    private int points;
    private boolean doubleWord, tripleWord, doubleLetter, tripleLetter = false;

    public Tiles() {
	points = 0;
    }
    public Tiles(int i) {
	points = 0;
	if(i==0) { doubleLetter = true;	}
	else if(i==1) {tripleLetter = true;}
	if(i==2) { doubleWord = true;}
	else if(i==3) {tripleWord = true;}
	else {
	    doubleWord = false;
	    tripleWord = false;
	}
    }

    public int getPoints() {
	return points;
    }
    
    public void setPoints(int i) {
	points = points + i;
    }

}
