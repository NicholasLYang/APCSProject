import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private Container pane;
    private JTextField name1,name2,name3,name4;
    public Canvas canvas;
    private Board b = new Board();
    
    public GUI(Board board) {
	b = board;
	setTitle("Scrabble");
	setSize(900,900);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	
	pane = getContentPane();
	canvas = new Canvas();
	canvas.setPreferredSize(new Dimension(450,450));
	canvas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	canvas.setBackground(Color.DARK_GRAY);
	pane.add(canvas);
	TextField name1, name2, name3, name4 = new TextField();
	
	
    }

    private class Canvas extends JPanel
    {
	

	public void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    Color placedTile = new Color(178, 142, 112);
	    Tiles[][] board = b.getBoard();
	    board[1][1].setPlaced(true);
	    for (int i = 0; i < board.length; i++)
		{
		    for (int j = 0; j < board[1].length; j++)
			{
			    g.drawRect(100 + i * 30, 100 + j * 30, 30, 30);
			    if (board[i][j].getPlaced() == true)
				{
				    g.setColor(placedTile);
				    g.fillRect(100 + i * 30, 100 + j * 30, 30, 30);
				    g.setColor(Color.BLACK);
				}
					
			}
		}
	}
				
	
    }
			


}
