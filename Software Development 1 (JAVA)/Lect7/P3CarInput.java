//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 27/11/2022
//Function: Seventh lab experience

import java.awt.*;
import java.awt.event.*;

public class P3CarInput extends Frame implements ActionListener
{
	Label make, model, year, engine, value;
	TextField input1, input2, input3, input4, input5;
	int number;


	public P3CarInput()
	{
		super ("Application for insurance firm");
		setLayout(new FlowLayout());
		make = new Label("Enter car make");
		model = new Label("Enter car model");
		year = new Label("Enter the year of the car");
		engine = new Label("Enter the engine capacity of the car");
		value = new Label("Enter the approximate value of the car");

		input1 = new TextField(10);
		input2 = new TextField(10);
		input3 = new TextField(10);
		input4 = new TextField(10);
		input5 = new TextField(10);

		add(make);
		add(input1);

		add(model);
		add(input2);

		add(year);
		add(input3);

		add(engine);
		add(input4);

		add(value);
		add(input5);
		input5.addActionListener(this);

		setSize(1200,700);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
			{
				number=Integer.parseInt(input3.getText());
				//input3.setText("\r");
				repaint();
			}
	public void paint(Graphics g)
		{
			g.drawString("The car year is " +number, 200,300);
		}

	public static void main(String[]args)
	{
		new P3CarInput();
	}
}