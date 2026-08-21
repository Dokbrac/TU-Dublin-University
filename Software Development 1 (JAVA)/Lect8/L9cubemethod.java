//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 4/12/2022
//Function: Eighth lab experience

import java.awt.*;
import java.awt.event.*;

public class L9cubemethod extends Frame implements ActionListener
{
	Label lblnumber;
	TextField tfnumber;
	int number;

	public L9cubemethod()
	{
		super("Application to calculate a cube of a number");
		setLayout(new FlowLayout());

		lblnumber = new Label("Enter a number");
		add(lblnumber);

		tfnumber = new TextField(5);
		add(tfnumber);
		tfnumber.addActionListener(this);

		setSize(1000,700);
		setVisible(true);
	}
	public int cube(int y)
	{
		return y*y*y;
	}
	public void actionPerformed(ActionEvent e)
	{
		number=Integer.parseInt(tfnumber.getText());
		repaint();

	}
	public void paint(Graphics g)
	{
		int result;
		result=cube(number);
		g.drawString(String.valueOf("The cube of the number: "+result),400,200);
	}
	public static void main(String[]args)
	{
		new L9cubemethod();
	}
}