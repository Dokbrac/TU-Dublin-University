//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 4/12/2022
//Function: Eighth lab experience

import java.awt.*;
import java.awt.event.*;

public class L9addnum extends Frame implements ActionListener
{
	Label prompt1, prompt2, prompt3;
	TextField input1, input2, input3;
	int number1, number2, number3, sum;

	public L9addnum()
	{
		super("Application to sum numbers");
		setLayout(new FlowLayout());

		prompt1 = new Label("Enter an integer number");
		input1 = new TextField(5);

		prompt2 = new Label("Enter an integer number");
		input2 = new TextField(5);

		prompt3 = new Label("Enter an integer number and press enter");
		input3 = new TextField(5);


		add(prompt1);
		add(input1);

		add(prompt2);
		add(input2);

		add(prompt3);
		add(input3);
		input3.addActionListener(this);

		setSize(1000,700);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		number1 = Integer.parseInt(input1.getText());
		number2 = Integer.parseInt(input2.getText());
		number3 = Integer.parseInt(input3.getText());

		repaint();
		sum=number1+number2+number3;
	}
	public void paint(Graphics g)
	{
		g.drawString("The sum of the entered numbers are: " +sum, 200,300);
	}

	public static void main(String[]args)
	{
		new L9addnum();
	}
}