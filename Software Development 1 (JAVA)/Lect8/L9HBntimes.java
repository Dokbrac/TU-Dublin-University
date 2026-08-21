//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 4/12/2022
//Function: Eighth lab experience

import java.util.Scanner;

public class L9HBntimes
{
	public static void main(String[]args)
	{
		int x;
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter a number for \"Happy Birthday\" to draw");

		x = scan.nextInt();

		System.out.println("********************");
		draw(x);
		System.out.println("********************");
	}
	public static void draw(int num)
		{
		for (int j=1; j<=num; j=j+1)
		{
			System.out.println("Happy Birthday");
		}
	}
}