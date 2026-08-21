//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 15/10/2022
//Function: Second lab experience

import java.util.Scanner;

class P4Grosspay
{
	public static void main(String[] args)
		{
		Scanner scan = new Scanner(System.in);

		double rate;

		System.out.println("Please enter the hourly rate");
		rate = scan.nextDouble();

		int hours;

		System.out.println("Please enter the number of hours worked");
		hours = scan.nextInt();

		double total = rate*hours;

		System.out.println("The employees daily gross pay " +total);

	}
}