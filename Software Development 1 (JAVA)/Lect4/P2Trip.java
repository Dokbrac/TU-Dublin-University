//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 29/10/2022
//Function: Fourth lab experience

import java.util.Scanner;

class P2Trip
{
	public static void main(String[] args)
		{
		int students, cars, left;
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter the total number of students");
		students = scan.nextInt();

		left = students%5;
		cars = students/5;

		System.out.println(+cars+ " cars needed for the trip and " +left+ " students cannot go by car.");
	}
}