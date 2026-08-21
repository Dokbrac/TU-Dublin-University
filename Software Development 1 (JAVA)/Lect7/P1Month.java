//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 27/11/2022
//Function: Seventh lab experience

import java.awt.*;
import java.awt.event.*;

public class P1Month extends Frame implements ActionListener
{
	Label prompt;
	TextField input;
	int number;

	public P1Month()
	{
		super("Application for month checker");
		setLayout(new FlowLayout());

		prompt = new Label("Enter a month number between 1 and 12");
		add(prompt);

		input = new TextField(3);
		input.addActionListener(this);
		add(input);

		setSize(500, 300);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		if (number <= 12 && number >=1)
		{
		g.drawString("Thats a valid number for a month", 70, 129);
		}
		else
		{
		g.drawString("Thats an invalid number for a month", 70, 130);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		number = Integer.parseInt(input.getText());

		input.setText("\r");
		repaint();
	}
	public static void main(String[]args)
	{
		new P1Month();
	}
}