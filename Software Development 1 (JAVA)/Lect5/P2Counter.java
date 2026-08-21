//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 05/11/2022
//Function: Fifth lab experience

import java.util.Scanner;

class P2Counter
{
	public static void main(String[] args)
		{
		Scanner scan = new Scanner(System.in);
		int gradeCounter, grade;

		double total, average;
		total = 0;
		gradeCounter = 0;

		while (gradeCounter < 10)
		{System.out.println("Enter Integer grade");
		grade = scan.nextInt();
		total = total + grade;

		gradeCounter++;
		}
		average = total/gradeCounter;

		System.out.println("The average of exam grades is: " +average);
		}
}
