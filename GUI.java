    /*
 *****GUI EXPlAINATION*****
Guis in Java at first can seem intimidating, but make a lot of sense. So first there's the Gui class. The Gui class can have many objects such as JPanels and JTextFields which are put onto the Container. One of these objects is of the class Canvas, which is defined within the Gui class. The class Canvas inherits from JPanel and overrides the paintComponent method. The paintComponent method is called whenever something is needed to be painted on the canvas. It can be activated by the repaint method, also from JPanel. Everything that is painted on the canvas is done using paintComponent, specifically using an object g of class Graphics to call methods. Think of g as the "paintbrush" of paintComponent.
   
**Ex**
g.drawRect(x, y, width, height); <-- draws the outline of a rectangle with coordinates x, y. 
g.setColor(Color.RED); <-- sets the "paintbrush" color to red. Color is a class which can be used to create specific colors by calling instances of it, but also has a few colors built in, such as red. 


     */

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.ArrayList; 

public class GUI extends JFrame {
    private Container pane;
    private JTextField name1,name2,name3,name4;
    public Canvas canvas;
    private int turn; 
    private Tiles[][] board; // the board array needs to be updated whenever something happens. 
    private ArrayList<Player> players;
    private int tileWidth = 30; // tileWidth is created and given a default value
    private int titleSize = 100;
    private int boardX = 100;
    private int boardY = 100;
    public int tileX, tileY;
    private Color background = new Color (128, 128, 128);
    private Font letterFont;
    private Font pointFont;
    private Font titleFont;
    public FontMetrics points;
    public FontMetrics title;
    public FontMetrics authors;
    /*
      Defines the colors for a placed tile (a tile which has been scored/used), 
      a visible tile (one which has been put on the board but not scored/used) 
      and a blank tile (a blank spot on the board
    */
    Color scoredTile = new Color(206, 163, 132);
    Color visibleTile = new Color(239, 194, 155);
    Color blankTile = new Color(84, 84, 84);
    Color selectedTile = new Color(255, 0, 0);
 
    /* Basically if the width of the window is smaller than the height,
       the board is sized according to the width, else it's sized according to the height.
       titleSize does something similar for the size of the title */
    private int selectedTileX, selectedTileY;
	
    public GUI(Tiles[][] b, ArrayList<Player> p) {
	board = b;
	players = p; 
	setTitle("Scrabble");
	setSize(900,900);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	turn = 0;
	// Just sets up some objects and puts it on the pane
	pane = getContentPane();
	mouseEvent mE = new mouseEvent();
	canvas = new Canvas();
	canvas.setPreferredSize(new Dimension(450,450));
	canvas.setBackground(background);
	canvas.addMouseListener(mE);
	pane.add(canvas);
	TextField name1, name2, name3, name4 = new TextField();
	
	
    }
    
    private class mouseEvent implements MouseListener
    {
	
	String temp = new String(); // Temp location of the letter that is selected
	boolean isTileSelected = false; 	// Has there been a tile selected already? 
	int tempX, tempY;
	int rackX = -1;
	public void mouseReleased(MouseEvent e)
	{
 
	}

	public void mouseEntered(MouseEvent e)
	{
       
	}

	public void mouseExited(MouseEvent e)
	{
   
	}
	public void mousePressed(MouseEvent e)
	{
	}
	
	 

	public void mouseClicked(MouseEvent e)
	{
	    /*
	      If you click on a tile, it's highlighted 
	      and the next time you click on a tile it's moved, 
	      unless the spot you click on is another tile
	    */

	  
	    int selectedX = 0;
	    int selectedY = 0;
	    // Is the mouse within the bounds of the board?
	    if (e.getX() > boardX && e.getY() > boardY && e.getY() < boardY + tileWidth * 15 && e.getX() < boardX + tileWidth * 15)
		{
		    
		    selectedX = (e.getX() - boardX)/tileWidth;
		    selectedY = (e.getY() - boardY)/tileWidth;
		    /*
		      Selected tile's coordinates are determined by division.
		      Subtract the board from its coordinate 
		      then divide by tileWidth to get number of tile
		    */
		    if (isTileSelected && board[selectedX][selectedY].getTileMode() == 0)
			{				     		
			    // If you've already selected a tile and the spot you're clicking on is free
			    board[selectedX][selectedY].setLetter(temp);
			    board[selectedX][selectedY].setTileMode(2);
			    try
				{
				    players.get(turn).getRack().get(rackX).setTileMode(0);
				    rackX = -1;
				}
			    catch (IndexOutOfBoundsException f)
				{
				    board[tempX][tempY].setTileMode(0);
				}
			    isTileSelected = false;
			    canvas.update(canvas.getGraphics());
			}
		    else
			{
			    temp = board[selectedX][selectedY].getLetter();
			    tempX = selectedX;
			    tempY = selectedY;
			    board[selectedX][selectedY].setTileMode(1);
			    isTileSelected = true;
			    canvas.update(canvas.getGraphics());
			}
		  
		}
	    if (e.getX() > boardX + tileWidth * 3 && e.getY() > boardY + tileWidth * 16 && e.getX() < boardX + tileWidth * 10 && e.getY() < boardY + tileWidth * 17)
		{
		    selectedX = (e.getX() - (boardX + tileWidth * 3))/tileWidth;
		    if (isTileSelected && players.get(turn).getRack().get(selectedX).getTileMode() == 0)
			{
			    players.get(turn).getRack().get(selectedX).setLetter(temp);
			    try
				{
				    players.get(turn).getRack().get(rackX).setTileMode(0);
				}
			    catch (IndexOutOfBoundsException f)
				{
				    board[tempX][tempY].setTileMode(0);
				}
			    canvas.update(canvas.getGraphics());
			    rackX = -1;

			}
		    else
			{
			    
			    rackX = (e.getX() - (boardX + tileWidth * 3))/tileWidth;
			    players.get(turn).getRack().get(selectedX).setTileMode(1);
			    temp = players.get(turn).getRack().get(selectedX).getLetter();
			    isTileSelected = true;
			    canvas.update(canvas.getGraphics());	
			}
					  
		}

	}


		

		      
	

    }
    
    
    
    
    private class Canvas extends JPanel
    {


	public void paintComponent(Graphics g)
	{
	    
	    super.paintComponent(g); // just adds the stuff from JPanel's version of paintComponent



	    if (getWidth() < getHeight())
		{
		     tileWidth = getWidth() / 25;
		     titleSize = getWidth() / 12;
		     boardX = getWidth() / 5;
		     boardY = (getHeight() - tileWidth * 15) / 2;
		}
	    else
		{
		     tileWidth = getHeight() / 21;
		     titleSize = getHeight() / 12;
		     boardX = getHeight() / 3;
		     boardY = (getHeight() - tileWidth * 15) / 2;
		     
		}



	    g.setFont(letterFont);

	    letterFont = new Font ("SansSerif", Font.BOLD, tileWidth / 2);
	    pointFont = new Font("SansSerif", Font.BOLD, tileWidth * 2 / 7);
	    titleFont = new Font("SansSerif", Font.BOLD, titleSize);
	    authors = g.getFontMetrics(letterFont);
	    title = g.getFontMetrics(titleFont);
	    points = g.getFontMetrics(pointFont); 

	    

	    // Just examples of a visible tile and a placed tile
	 
	    // Draws the title and author names. Letter font is used for authors names because it's the right size
	   
	    int titleWidth = title.stringWidth("Scrabble");
	    int titleHeight = title.getAscent();
	    int authorWidth = authors.stringWidth("by Sarah Chen and Nicholas Yang");
	    int authorHeight = authors.getAscent();
		
	    g.setFont(titleFont);
	    g.drawString("Scrabble" , (getWidth() - titleWidth) / 2, titleHeight + 2) ;
	    g.setFont(letterFont);
	    g.drawString("by Sarah Chen and Nicholas Yang", (getWidth() - authorWidth) / 2, authorHeight + titleHeight + 4);
	    
	    // Drawing the overall red board before putting in the rectangles for the tile slots. 
	    g.drawRect(boardX, boardY, tileWidth * 15, tileWidth * 15);
	    g.setColor(Color.RED);
	    g.fillRect(boardX, boardY, tileWidth * 15 + 2, tileWidth * 15 + 2);

	    // Remember, always set the color back to black after done painting
	    g.setColor(Color.BLACK);



	    // Usual double for loop for 2d arrays
	    for (int i = 0; i < board.length; i++)
		{
		    
		    for (int j = 0; j < board[1].length; j++)
			{
			    // x and y coords for the tiles. Note that the upper left corner is 0,0
			    board[i][j].setTileCoords(boardX + 2 + i * tileWidth, boardY + 2 + j * tileWidth);
			     tileX = boardX + tileWidth * i + 2;
			     tileY = boardY + tileWidth * j + 2;
			    this.paintTiles(g, tileX, tileY, board[i][j]); 
					
			}
		}
	    // Draws the tileRack
	    g.drawRect(boardX + tileWidth * 3, boardY + tileWidth * 16, tileWidth * 7, tileWidth);
	    g.setColor(Color.RED);
	    g.fillRect(boardX + tileWidth * 3, boardY + tileWidth * 16, tileWidth * 7, tileWidth);
	    g.setColor(Color.BLACK);
	    g.setFont(letterFont);
	    g.drawString(players.get(turn).getName(), boardX + tileWidth * 4, boardY + tileWidth * 18);
	    
	    for (int i = 0; i < players.get(turn).getRack().size() ; i++)
		{
		    tileX = boardX + tileWidth * (3 + i) + 1;
		    tileY = boardY + tileWidth * 16 + 1;
		    ArrayList<Tiles> rack = players.get(turn).getRack();
		    this.paintTiles(g, tileX, tileY, rack.get(i));
	    
		}
	    
	}
	public void paintTiles (Graphics g, int tileX, int tileY, Tiles t)
	{
	    /*
	      Gets the letter from the tile. Had to make it a string
	      because chars are annoying to draw. Plus it's easier to
	      turn a string into a char than vice versa
	    */
			    
	    String l = t.getLetter();
	    String p = "" + t.getPoints();
	    // Draws outline for tile slot
	    g.drawRect(tileX, tileY, tileWidth - 2, tileWidth - 2);
	    // Depending on variables from the tile, it paints with one of the three different colors
			   
	    switch (t.getTileMode())
		{
		case 0:
		    g.setColor(blankTile);
		    break;
		case 1: 
		    g.setColor(selectedTile);
		    break;
				
		case 2: 
		    g.setColor(visibleTile);
		    break;
		case 3:
		    g.setColor(scoredTile);
		    break;
		default:
		    break;
				    
		}
	    g.fillRect(tileX, tileY, tileWidth - 2, tileWidth - 2);
	    g.setColor(Color.BLACK);
				   
	    if (t.getTileMode() != 0)
		{
		    // Draws the letter on the tile
		    g.setFont(letterFont);
		    g.drawString(l, tileX + (tileWidth / 8), tileY + (tileWidth / 2));
					

		    // Draws the point value on the tile
		    g.setFont(pointFont);
		    g.drawString(p, tileX + (tileWidth * 7 / 8) - points.stringWidth(p)  , tileY + (tileWidth * 3 / 4));
		}
	}
	

			       	

				
    }
}
			



