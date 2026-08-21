//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 11/12/2022
//Function: Tenth lab experience

import java.awt.*;
import java.awt.event.*;

public class L10CircleArea extends Frame implements ActionListener
{

	Label label1;
	TextField number1;
	int num1;

	public L10CircleArea()
		{
		super("Application for PI");

		setLayout(new FlowLayout());

		label1 = new Label("Enter an integer:");
		number1 = new TextField(0);

		number1.addActionListener(this);

		add(label1);
		add(number1);


		setSize(1000, 700);
		setVisible(true);
		}

	public double CircleArea(double r)
	{
		return Math.PI*r*r;
	}
	public void actionPerformed(ActionEvent e)
	{
		num1 = Integer.parseInt(number1.getText());

		repaint();
	}
	public void paint(Graphics g)
		{
			double result;
			result=CircleArea(num1);
			g.drawString(String.valueOf(result),400,200);
		}
	public static void main (String args [])
		{
		new L10CircleArea();
		}
}