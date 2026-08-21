//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 11/12/2022
//Function: Tenth lab experience

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class L10GridLayout extends JFrame
			implements ActionListener
{
	private JButton b[];
	private String names[] = {"One","Two","Three","Four","Five","Six","Seven","Eight"};
	private boolean toggle = true;

	public L10GridLayout()
	{
	setLayout(new GridLayout(2, 3, 5, 5));

	b = new JButton[names.length];

	for(int i = 0; i < names.length; i++)
	{
		b[i] = new JButton(names[i]);
		b[i].addActionListener(this);
		add(b[i]);
	}
	setSize(500, 200);
	setVisible(true);
	}

public void actionPerformed (ActionEvent e)
{
	if(toggle)

	setLayout(new GridLayout(4, 2));
	else
	setLayout(new GridLayout(2, 3, 5, 5));
	toggle = !toggle;

	validate();
	}

public static void main(String args[])
	{
		L10GridLayout app = new L10GridLayout();
		app.addWindowListener(new WindowAdapter()
			   {
				  public void windowClosing(WindowEvent e)
				   {
					   System.exit(0);
				   }
			   }
			   );
	}

}