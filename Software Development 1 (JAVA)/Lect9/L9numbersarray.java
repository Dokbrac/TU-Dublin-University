//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 10/12/2022
//Function: Ninth lab experience

import java.util.Scanner;

public class L9numbersarray
{
	public static void main(String[]args)
	{

		Scanner scan = new Scanner(System.in);

		double numbers[]=new double[5];

		System.out.println("Enter the first number");
		numbers[0]=scan.nextDouble();
		System.out.println("Enter the second number");
		numbers[1]=scan.nextDouble();
		System.out.println("Enter the third number");
		numbers[2]=scan.nextDouble();
		System.out.println("Enter the fourth number");
		numbers[3]=scan.nextDouble();
		System.out.println("Enter the fifth number");
		numbers[4]=scan.nextDouble();

		System.out.println("The numbers are");

		for(int i=0; i<5; i++)
		{
			System.out.println("Number in position "+i+" = "+numbers[i]);
		}
	}
}