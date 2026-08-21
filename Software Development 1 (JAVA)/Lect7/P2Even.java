//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 27/11/2022
//Function: Seventh lab experience

import java.awt.*;
import java.awt.event.*;

public class P2Even extends Frame implements ActionListener
{
	Label prompt;
	TextField input;

	int number;

	public P2Even()
	{
		super("Application for even numbers");
		setLayout(new FlowLayout());
		prompt = new Label("Enter an integer number");
		add(prompt);

		input = new TextField(5);
		add(input);

		input.addActionListener(this);
		setSize(300, 400);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		if (number%2==0)

			g.drawString("Number is even", 60,90);

		else

			g.drawString("Number is not even", 60,110);
	}
	public void actionPerformed(ActionEvent e)
		{
			number = Integer.parseInt(input.getText());

			input.setText("\r");
			repaint();

		}
	public static void main(String[]args)
	{
		new P2Even();
	}
}