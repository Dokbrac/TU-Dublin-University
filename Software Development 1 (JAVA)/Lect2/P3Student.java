//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 15/10/2022
//Function: Second lab experience

import java.util.Scanner;

class P3Student
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int groupA, groupB;

		System.out.println("Please enter the number of students A group");
		groupA = scan.nextInt();

		System.out.println("Please enter the number of students B group");
		groupB = scan.nextInt();

		System.out.println("Number of total students = " +(groupA + groupB));
	}
}