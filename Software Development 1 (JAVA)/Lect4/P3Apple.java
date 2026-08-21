//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 29/10/2022
//Function: Fourth lab experience

import java.util.Scanner;

class P3Apple
{
	public static void main(String[] args)
		{
		int apples;
		double total;
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter the total number of apples you selected");
		apples = scan.nextInt();

		if (apples < 6)
		{
			total = apples*.80;
			System.out.println("The price for the " +apples+ " apples you selected " +total+ " Eur");
		}
		else
		if (apples < 12)
		{
			total = apples*.70;
			System.out.println("The price for the " +apples+ " apples you selected " +total+ " Eur");
		}
		else
		if (apples < 20)
		{
			total = apples*.60;
			System.out.println("The price for the " +apples+ " apples you selected " +total+ " Eur");
		}
		else
		{
			total = apples*.50;
			System.out.println("The price for the " +apples+ " apples you selected " +total+ " Eur");
		}


	}
}