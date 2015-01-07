import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private Container pane;
    private JTextField name1,name2,name3,name4;

    public GUI() {
	setTitle("Scrabble");
	setSize(700,700);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = getContentPane();
	name1, name2, name3, name4 = new TextField();
	
	
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
