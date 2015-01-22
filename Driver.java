public class Driver
{
    

    public static void main(String[] args) {
	Board b = new Board();
	Tiles[][] board = b.getBoard();
	board[5][5].setTileMode(2);
	board[5][5].setLetter("X");
	    
	GUI x = new GUI(b.getBoard());
	x.setVisible(true);
	/*
	Player One = new Player(name1.getText());
	Player Two = new Player(name2.getText());
	Player Three = new Player(name3.getText());
	Player Four = new Player(name4.getText());
	*/
    }

}
