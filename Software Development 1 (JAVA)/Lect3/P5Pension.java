//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 22/10/2022
//Function: Third lab experience

import java.util.Scanner;

class  P5Pension
{
	public static void main(String[] args)
		{
		Scanner scan = new Scanner(System.in);

		int age;

		System.out.println("Please type your age");
		age = scan.nextInt();

		if (age >= 65)
		{
			System.out.println("Congratulations you are eligible for a pension ");
		}

	}
}