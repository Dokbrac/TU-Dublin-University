//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 05/11/2022
//Function: Fifth lab experience

import java.util.Scanner;

class P3Sentinel
{
	public static void main(String[] args)
		{
		Scanner scan = new Scanner(System.in);

		int gradeCounter;
		int total;
		int gradeValue;
		double average;

		total = 0;
		gradeCounter = 0;

		System.out.println("Enter Integer grade - -1 to quit");
		gradeValue = scan.nextInt();

		while (gradeValue != -1)
		{
			total = total + gradeValue;

			gradeCounter++;

			System.out.println("Enter Integer grade - -1 to quit");
			gradeValue = scan.nextInt();
		}
		if (gradeCounter != 0)
		{
			average = (double)total/gradeCounter;

			System.out.println("The average of exam grades is " +average);
		}
		else
		System.out.println("No grades were entered");
	}
}