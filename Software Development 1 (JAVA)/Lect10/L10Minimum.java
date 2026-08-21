//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 11/12/2022
//Function: Tenth lab experience

import java.awt.*;
import java.awt.event.*;

public class L10Minimum extends Frame implements ActionListener
{

	Label label1, label2;
	TextField number1, number2;
	int num1,num2;

	public L10Minimum()
		{
		super("Application for smaller number");

		setLayout(new FlowLayout());

		label1 = new Label("Enter first integer:");
		number1 = new TextField(0);

		label2 = new Label("Enter second integer:");
		number2 = new TextField(0);

		number2.addActionListener(this);

		add(label1);
		add(number1);

		add(label2);
		add(number2);


		setSize(1000, 700);
		setVisible(true);
		}

	public int Minimum(int x, int y)
	{
		return Math.min(x,y);
	}
	public void actionPerformed(ActionEvent e)
	{
		num1 = Integer.parseInt(number1.getText());

		num2 = Integer.parseInt(number2.getText());

		repaint();
	}
	public void paint(Graphics g)
		{
			int result;
			result=Minimum(num1,num2);
			g.drawString(String.valueOf("The smaller number is: "+result),400,200);
		}
	public static void main (String args [])
		{
		new L10Minimum();
	}
}