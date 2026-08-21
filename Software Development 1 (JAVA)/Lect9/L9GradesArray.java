//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 10/12/2022
//Function: Ninth lab experience

import java.awt.*;

public class L9GradesArray extends Frame
{
	double grades[]={35,56,45,78,56,87,98,76,87,67};

	public L9GradesArray()
	{
		super("Application to display grades");
		setSize(250,400);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		int yposition = 80;
		g.drawString("Grades",25,yposition);

		for(int i=0; i<grades.length; i++)
		{
			yposition+=15;
			//g.drawString(String.valueOf(i), 45, yposition);
			g.drawString(String.valueOf(grades[i]),25,yposition);

		}
	}
	public static void main(String[]args)
		{
			new L9GradesArray();
		}
}
