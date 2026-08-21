//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 12/02/2023
//Function: Second lab experience

import java.util.Scanner;

class L2NumbersArrayMethod
{
	static Scanner scan=new Scanner(System.in);

	public static void main(String[]args)
	{
		int numbers[]=new int[5];
		enternumbers(numbers);
		displaynumbers(numbers);
	}
	static void enternumbers(int numbersIn[])
	{
		for(int i=0; i<numbersIn.length; i=i+1)
		{
			System.out.println("Enter a number: ");
			numbersIn[i]=scan.nextInt();
		}
	}
	static void displaynumbers(int numbersOut[])
		{
			System.out.println("Numbers entered: ");
			for(int i=0; i<numbersOut.length; i=i+1)
				{
					System.out.println("Numbers: "+numbersOut[i]);
				}
		}
}