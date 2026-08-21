//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 26/02/2023
//Function: Fourth lab experience

import java.util.Scanner;

class L4PrintChar
{
	public static void main(String [] args)
	{
		enter();
	}
	static void enter()
	{
		int number;
		Scanner in=new Scanner(System.in);
		System.out.printf("Enter a number between 33 and 127: ");
		number=in.nextInt();

		while(number<34 || number>126)
		{
			System.out.printf("Invalid number pls reenter a valid number: ");
			number=in.nextInt();
		}
		if(number>=34 || number<=126)
		{
			System.out.printf("%n");
			System.out.printf("The value you entered corresponds to the ASCII table character is: %c%n",number);
			System.out.printf("%n");
		}
	}
}