//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 20/11/2022
//Function: Sixth lab experience

import java.util.Scanner;

class P3LoopRange
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int initial, finish;

		System.out.println("Please enter a number");
		initial = scan.nextInt();

		System.out.println("PLease enter a second number, larger than the previous one");
		finish = scan.nextInt();

		if (initial % 2 == 0)
		{
			for (int number=initial; number<=finish; number+=2)
			{
				System.out.println(number);
			}
		}
		else
		for (int number=initial+1; number<=finish; number+=2)
		{
			System.out.println(number);
		}
	}
}
