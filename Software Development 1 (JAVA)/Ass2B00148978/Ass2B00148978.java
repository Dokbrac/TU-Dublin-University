//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 11/12/2022
//Function: Vending Machine

import java.awt.*;//import GUI
import java.awt.event.*;//import ActionListener

public class Ass2B00148978 extends Frame implements ActionListener
{
	int select;//create variables
	double total;
	int coffeec, teac, soupc, waterc;
	TextField input;
	Label prompt;

	public Ass2B00148978()//create constructor
	{
		super("Vending Machine");//headline of the Frame
		setLayout(new FlowLayout());

		prompt = new Label("Select:");//adding the label and prompt
		add(prompt);
		input = new TextField(2);
		add(input);
		input.addActionListener(this);

		setSize(300,400);//size of the frame
		setVisible(true);

		coffeec=0;//setting products value to 0
		teac=0;
		soupc=0;
		waterc=0;
	}
  	public void actionPerformed(ActionEvent e)//calling the ActionListener
	{
		select = Integer.parseInt(input.getText());
		input.setText("\r");
		repaint();
	}
	public void paint(Graphics g)//information in the Frame
	{
		g.drawString("1. Coffee €2.00", 50,90);//information of the vending machine
		g.drawString("2. Tea €2.00", 50,110);
		g.drawString("3. Soup €2.00", 50,130);
		g.drawString("4. Water €1.50 ", 50,150);
		g.drawString("5. Finish and pay", 50,170);

		if (select<=0 || select>=6)//repetitive selection of the vending machine products + paying option
			{
				g.drawString("Invalid choice, options 1-5 only!", 50,250);
			}
		if (select==1)
			{
				g.drawString("You have chosen Coffee", 50,250);
				coffeec++;
			}
		if (select==2)
			{
				g.drawString("You have chosen Tea", 50,250);
				teac++;
			}
		if (select==3)
			{
				g.drawString("You have chosen Soup", 50,250);
				soupc++;
			}
		if (select==4)
			{
				g.drawString("You have chosen Water", 50,250);
				waterc++;
			}
		if (select==5)
			{
				total=(coffeec*2)+(teac*2)+(soupc*2)+(waterc*1.5);
				g.drawString("Coffee: " +coffeec+" selected", 50,270);
				g.drawString("Tea: " +teac+" selected", 50,290);
				g.drawString("Soup: " +soupc+" selected", 50,310);
				g.drawString("Water: " +waterc+" selected", 50,330);
				g.drawString("Total money due is: € " +total, 50,350);
			}
	}
	public static void main(String[]args)
	{
		new Ass2B00148978();
	}
}