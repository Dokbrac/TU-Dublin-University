//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 20/11/2022
//Function: Sixth lab experience

import java.util.Scanner;

class P1LoopEven
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int sum;
		sum = 0;

		for (int number = 2; number <= 40; number += 2)
		{
			System.out.println("Number " +number);
			sum += number;
		}
		System.out.println("The sum of the numbers from 1 to 100 is " +sum);
	}
}