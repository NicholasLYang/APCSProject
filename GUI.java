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

public class GUI extends JFrame {
    private Container pane;
    private JTextField name1,name2,name3,name4;
    public Canvas canvas;
    private Tiles[][] board; // the board array needs to be updated whenever something happens. 
    private Player p1;
    private int tileWidth = 30; // tileWidth is created and given a default value
    private int titleSize = 100;
    private int boardX = 100;
    private int boardY = 100;
    /* Basically if the width of the window is smaller than the height,
       the board is sized according to the width, else it's sized according to the height.
       titleSize does something similar for the size of the title */
    private int selectedTileX, selectedTileY;
	
    public GUI(Tiles[][] b) {
	board = b;
	setTitle("Scrabble");
	setSize(900,900);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	// Just sets up some objects and puts it on the pane
	pane = getContentPane();
	mouseEvent mE = new mouseEvent();
	canvas = new Canvas();
	canvas.setPreferredSize(new Dimension(450,450));
	canvas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	canvas.setBackground(Color.DARK_GRAY);
	canvas.addMouseListener(mE);
	pane.add(canvas);
	TextField name1, name2, name3, name4 = new TextField();
	
	
    }
    
    private class mouseEvent implements MouseListener
    {
	
	String temp; // Temp location of the letter that is selected
	boolean isTileSelected = false; 	// Has there been a tile selected already? 
	int tempX, tempY;
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

	    // Is the mouse within the bounds of the board?
	    if (e.getX() > boardX && e.getY() > boardY && e.getY() < boardY + tileWidth * 15 && e.getX() < boardX + tileWidth * 15)
		{
		    /*
		      Selected tile's coordinates are determined by division.
		      Subtract the board from its coordinate 
		      then divide by tileWidth to get number of tile
		    */
		    selectedTileX = (e.getX() - boardX) / tileWidth;
		    selectedTileY = (e.getY() - boardY) / tileWidth;
		     // Basically if the tile you selected is movable 
		     if (board[selectedTileX][selectedTileY].getTileMode() == 2)
				 {
				     // Then save it under the variable previouslySelectedTile
				     temp = board[selectedTileX][selectedTileY].getLetter();
				     // With the coords as well
				     // pSX = x coordinate of previously selected tile 
				    
				      tempX = selectedTileX;
				      tempY = selectedTileY;
				     board[selectedTileX][selectedTileY].setTileMode(1);
				     isTileSelected = true;
				     canvas.update(canvas.getGraphics());
				     
				 }
		     // If you've already selected a tile and the spot you're clicking on is free
		    else if (isTileSelected && board[selectedTileX][selectedTileY].getTileMode() == 0)
			{
			    board[selectedTileX][selectedTileY].setLetter(temp);
			    board[tempX][tempY].setTileMode(0);
			    board[selectedTileX][selectedTileY].setTileMode(2);
			    isTileSelected = false;
			    canvas.update(canvas.getGraphics());
			}

		      
		}
	    // Well is the mouse in the tile rack?
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

	    // sets up the two different fonts
	    Font letterFont = new Font ("SansSerif", Font.BOLD, tileWidth / 2);
	    Font pointFont = new Font("SansSerif", Font.BOLD, tileWidth * 2 / 7);
	    Font titleFont = new Font("SansSerif", Font.BOLD, titleSize);
	    FontMetrics authors = g.getFontMetrics(letterFont);
	    FontMetrics title = g.getFontMetrics(titleFont);
	    FontMetrics points = g.getFontMetrics(pointFont);
	    g.setFont(letterFont);

	    

	    /*
	      Defines the colors for a placed tile (a tile which has been scored/used), 
	       a visible tile (one which has been put on the board but not scored/used) 
	       and a blank tile (a blank spot on the board
	    */
	    Color scoredTile = new Color(206, 163, 132);
	    Color visibleTile = new Color(239, 194, 155);
	    Color blankTile = new Color(84, 84, 84);
	    Color selectedTile = new Color(255, 0, 0);
 

	    

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


	    // Draws the tileRack
	    g.drawRect(boardX + tileWidth * 3, boardY + tileWidth * 16, tileWidth * 7, tileWidth);

	    // Usual double for loop for 2d arrays
	    for (int i = 0; i < board.length; i++)
		{
		    
		    for (int j = 0; j < board[1].length; j++)
			{
			    // x and y coords for the tiles. Note that the upper left corner is 0,0
			    board[i][j].setTileCoords(boardX + 2 + i * tileWidth, boardY + 2 + j * tileWidth);
			    int tileX = board[i][j].getTileX();
			    int tileY = board[i][j].getTileY();

			    /*
			      Gets the letter from the tile. Had to make it a string
			      because chars are annoying to draw. Plus it's easier to
			      turn a string into a char than vice versa
			    */
			    String l = board[i][j].getLetter();
			    String p = "" + board[i][j].getPoints();
			    

			    // Draws outline for tile slot
			    g.drawRect(tileX, tileY, tileWidth - 2, tileWidth - 2);
			    // Depending on variables from the tile, it paints with one of the three different colors
			   
			    switch (board[i][j].getTileMode())
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
				   
				    if (board[i][j].getTileMode() != 0)
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

	

			       	

				
    }
}
			



