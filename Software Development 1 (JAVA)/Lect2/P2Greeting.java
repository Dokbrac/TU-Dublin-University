//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 15/10/2022
//Function: Second lab experience

import java.util.Scanner;

class P2Greeting
{
	public static void main(String[] args)
		{
		Scanner scan = new Scanner(System.in);

		String username;

		System.out.println("Please enter your name");
		username = scan.next();

		System.out.println("Hello " +username+ ", nice to meet you!" );
	}
}