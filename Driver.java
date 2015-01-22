import java.util.ArrayList;
import java.util.Scanner;
   
public class Driver
{
    

    public static void main(String[] args) {
	Board b = new Board();
	Tiles[][] board = b.getBoard();
	ArrayList<Player> players = new ArrayList<Player>(); 
	Scanner sc = new Scanner(System.in);
	System.out.println("Player 1 Name?");
	Player p1 = new Player(sc.nextLine());
	players.add(p1);
	System.out.println("Player 2 Name?");
	Player p2 = new Player(sc.nextLine());
	players.add(p2);
	    
	GUI x = new GUI(b.getBoard(), players);
	x.setVisible(true);
	/*
	Player One = new Player(name1.getText());
	Player Two = new Player(name2.getText());
	Player Three = new Player(name3.getText());
	Player Four = new Player(name4.getText());
	*/
    }

}
