package MLM;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


/* UI for a Query */
@SuppressWarnings("serial")
public class GUI extends JFrame
{
	JTextField gender, parent, urban, business, success;
	JButton submit;

	public GUI(String title)
	{
		super(title);
		setLayout(new FlowLayout());
		setSize(400, 250);
		
		setVisible(true);
	}
}
