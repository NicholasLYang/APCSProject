import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private Container pane;
    private JTextField name1,name2,name3,name4;
    private JPanel canvas;
    
    public GUI() {
	setTitle("Scrabble");
	setSize(700,700);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	Board b = new Board();
	pane = getContentPane();
	canvas = new Canvas();
	canvas.setPreferredSize(new Dimension(2250,2250));
	canvas.setBorder(BorderFactory.createLineBorder(Color.darkGray));
	canvas.printBoard(b);
	pane.add(canvas);
	TextField name1, name2, name3, name4 = new TextField();
	
	
    }

    private class Canvas extends JPanel
    {
	public void printBoard(Board b, Graphics g)
	{
	    Tile[][] board = b.getBoard();
	    for (int i = 0; i < board.length; i++)
		{
		    for (int i = 0; i < board[1].length; i++)
			{
			    canvas.paintCompnent(g);
			    g.setColor(Color.gray);
			    g.fillRect(0,0,30,30);
			}
		}
	}
    }
			

    public static void main(String[] args) {
	GUI x = new GUI();
	x.setVisible(true);
	Player One = new Player(name1.getText());
	Player Two = new Player(name2.getText());
	Player Three = new Player(name3.getText());
	Player Four = new Player(name4.getText());
    }

}
