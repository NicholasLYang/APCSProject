
import java.util.ArrayList;
import java.util.*;


public class Player {
  
    private int score;
    private String name;
    private ArrayList<Tiles> Rack;
    private Random rng;
    private static ArrayList<Tiles> AvailTiles;
    
    public Player(String n) {	
	score = 0;
	name = n;
	Rack = new ArrayList<Tiles>();	
	rng = new Random();
	ArrayList<Tiles> AvailTiles = new ArrayList<Tiles>();
	for(int i=0;i<12; i++) {
	    AvailTiles.add(new Tiles("E"));
	}
	for(int i=0;i<9;i++) {
	    AvailTiles.add(new Tiles("A"));
	    AvailTiles.add(new Tiles("I"));
	}
	for(int i=0;i<8;i++) {
	    AvailTiles.add(new Tiles("O"));
	}
	for(int i=0;i<6;i++) {
	    AvailTiles.add(new Tiles("N"));
	    AvailTiles.add(new Tiles("R"));
	    AvailTiles.add(new Tiles("T"));
	}
	for(int i=0;i<4;i++) {
	    AvailTiles.add(new Tiles("L"));
	    AvailTiles.add(new Tiles("S"));
	    AvailTiles.add(new Tiles("U"));
	    AvailTiles.add(new Tiles("D"));
	}
	for(int i=0;i<3;i++) {
	    AvailTiles.add(new Tiles("G"));
	}
	for(int i=0;i<2;i++) {
	    AvailTiles.add(new Tiles("B"));
	    AvailTiles.add(new Tiles("C"));
	    AvailTiles.add(new Tiles("M"));
	    AvailTiles.add(new Tiles("P"));
	    AvailTiles.add(new Tiles("F"));
	    AvailTiles.add(new Tiles("H"));
	    AvailTiles.add(new Tiles("V"));
	    AvailTiles.add(new Tiles("W"));
	    AvailTiles.add(new Tiles("Y"));
	}
	for(int i=0;i<1;i++) {
	    AvailTiles.add(new Tiles("K"));
	    AvailTiles.add(new Tiles("J"));
	    AvailTiles.add(new Tiles("X"));
	    AvailTiles.add(new Tiles("Q"));
	    AvailTiles.add(new Tiles("Z"));
	}

	for(int i=0;i<7;i++) {
	    Rack.add(AvailTiles.remove(rng.nextInt(AvailTiles.size())));
	}
	
    }
    
    public void rackRefill(ArrayList<Tiles> AvailTiles) {
	for(int i=0;i<7;i++) {
	    Rack.add(AvailTiles.remove(rng.nextInt(AvailTiles.size())));
	}
    }

    public int getScore() {
	return score;
    }
    public String getName()
    {
	return name;
    }

    public void setScore(int points) {
	score = points;
    }

    public void placeLetter(Board b, String l, int r, int c) {
	b.assignLetter(l, r, c);
    }
    public ArrayList<Tiles> getRack()
    {
	return Rack;
    }
    

}
