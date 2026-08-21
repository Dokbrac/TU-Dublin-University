//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 22/10/2022
//Function: Third lab experience

import java.util.Scanner;

class   P4Cars
{
	public static void main(String[] args)
		{
		Scanner scan = new Scanner(System.in);

		int tyres, cars;

		System.out.println("Please enter the total number of tyres in garage");
		tyres = scan.nextInt();

		int rem = tyres%4;
		cars = tyres/4;

		System.out.println("The garage can fit " +cars+ " cars and " +rem+ " tyres");


	}
}