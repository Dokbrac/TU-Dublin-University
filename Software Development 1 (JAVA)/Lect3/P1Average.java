//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 22/10/2022
//Function: Third lab experience

import java.util.Scanner;

class P1Average
{
	public static void main(String[] args)
		{
		Scanner scan = new Scanner(System.in);

		double Monday, Tuesday, Wednesday, Thursday, Friday;

		System.out.println("Please enter total sales for Monday");
		Monday = scan.nextDouble();

		System.out.println("Please enter total sales for Tuesday");
		Tuesday = scan.nextDouble();

		System.out.println("Please enter total sales for Wednesday");
		Wednesday = scan.nextDouble();

		System.out.println("Please enter total sales for Thursday");
		Thursday = scan.nextDouble();

		System.out.println("Please enter total sales for Friday");
		Friday = scan.nextDouble();

		double total, average;
		total = Monday+Tuesday+Wednesday+Thursday+Friday;
		average = total/5;

		System.out.println("The total sales for the week was " +total+ " Euro and the weekly average per day was " +average+ " Euro");


	}
}