
import java.util.ArrayList;
import java.util.*;


public class Player {
  
    private int score;
    private String name;
    private ArrayList<Tiles> Rack;
    private Random rng;
    private static ArrayList<String> AvailTiles = new ArrayList<String>();



    public Player(String n) {	
	score = 0;
	name = n;
	Rack = new ArrayList<Tiles>(7);
	for (int i = 0; i < 7; i++)
	    {
		Rack.add(new Tiles());
	    }
	rng = new Random();
	

	
    }
    public void addNewBag()
    {
	for(int i=0;i<12; i++) {
	    AvailTiles.add("E");
	}
	for(int i=0;i<9;i++) {
	    AvailTiles.add("A");
	    AvailTiles.add("I");
	}
	for(int i=0;i<8;i++) {
	    AvailTiles.add("O");
	}
	for(int i=0;i<6;i++) {
	    AvailTiles.add("N");
	    AvailTiles.add("R");
	    AvailTiles.add("T");
	}
	for(int i=0;i<4;i++) {
	    AvailTiles.add("L");
	    AvailTiles.add("S");
	    AvailTiles.add("U");
	    AvailTiles.add("D");
	}
	for(int i=0;i<3;i++) {
	    AvailTiles.add("G");
	}
	for(int i=0;i<2;i++) {
	    AvailTiles.add("B");
	    AvailTiles.add("C");
	    AvailTiles.add("M");
	    AvailTiles.add("P");
	    AvailTiles.add("F");
	    AvailTiles.add("H");
	    AvailTiles.add("V");
	    AvailTiles.add("W");
	    AvailTiles.add("Y");
	}
	for(int i=0;i<1;i++) {
	    AvailTiles.add("K");
	    AvailTiles.add("J");
	    AvailTiles.add("X");
	    AvailTiles.add("Q");
	    AvailTiles.add("Z");
	}
    }
    public void rackRefill() {
	for(int i=0;i<7;i++) {
	    Tiles t = Rack.remove(0);
	    t.setLetter(AvailTiles.remove(rng.nextInt(AvailTiles.size())));
	    t.setTileMode(2);
	    Rack.add(t);
		
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
    public void setRack(ArrayList<Tiles> r)
    {
	Rack = r;
    }
    

}
