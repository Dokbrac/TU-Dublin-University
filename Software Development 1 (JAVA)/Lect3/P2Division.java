//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 22/10/2022
//Function: Third lab experience

import java.util.Scanner;

class P2Division
{
	public static void main(String[] args)
		{
		Scanner scan = new Scanner(System.in);

		int num1, num2;

		System.out.println("Please enter a number");
		num1 = scan.nextInt();

		System.out.println("Please enter a second number");
		num2 = scan.nextInt();

		int result = num1-num2;
		int rem = num1%num2;
		System.out.println(num1+ " divided by " +num2 +" equals " +result + " remainder " +rem);

	}
}