//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 12/02/2023
//Function: Second lab experience

import java.util.Scanner;

class L2ArrayMethodElement
{
	static Scanner scan=new Scanner(System.in);

	public static void main(String[]args)
	{
		int numbers[]=new int[10];
		enternumbers(numbers);
		displaynumbers(numbers[1]);
	}
	static void enternumbers(int numbersIn[])
	{
		for(int i=0; i<numbersIn.length; i=i+1)
		{
			System.out.println("Enter a number: ");
			numbersIn[i]=scan.nextInt();
		}
	}
	private static void displaynumbers(int secondnumber)
		{
			System.out.println("Number at second place: ");
				{
					System.out.println("Number: "+secondnumber);
				}
		}
}