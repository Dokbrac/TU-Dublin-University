//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 12/02/2023
//Function: Second lab experience

import java.util.Scanner;

class L2BubbleSort
{
	static Scanner scan=new Scanner(System.in);
	static int numbers[]=new int[5];

	public static void main(String[]args)
	{
		enternumbers(numbers);
		System.out.println("Unsorted array of entered numbers: ");
			for(int i=0; i<numbers.length; i=i+1)
			{
				System.out.println(numbers[i]);
			}

		sort();

		System.out.println("Sorted array of entered numbers: ");
			for(int i=0; i<numbers.length; i=i+1)
			{
				System.out.println(numbers[i]);
			}
	}
	static void enternumbers(int numbersIn[])
	{
		for(int i=0; i<numbersIn.length; i=i+1)
		{
			System.out.println("Enter a number: ");
			numbersIn[i]=scan.nextInt();
		}
	}
	static void sort()
		{
			int hold;
			for(int pass=1; pass<numbers.length; pass=pass+1)
				for(int i=0; i<numbers.length-1; i=i+1)
					if(numbers[i]>numbers[i+1])
					{
						hold=numbers[i];
						numbers[i]=numbers[i+1];
						numbers[i+1]=hold;
					}
		}
}