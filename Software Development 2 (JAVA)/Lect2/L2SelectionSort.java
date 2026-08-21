//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 12/02/2023
//Function: Second lab experience

import java.util.Scanner;

class L2SelectionSort
{
	static Scanner scan=new Scanner(System.in);

	static void sort(int tempArr[])
	{
		for (int i = 0; i < tempArr.length-1; i++)
		{
			int min_val = i;
			for (int j = i+1; j < tempArr.length; j++)
				if (tempArr[j] < tempArr[min_val])
					min_val = j;

			int temp = tempArr[min_val];
			tempArr[min_val] = tempArr[i];
			tempArr[i] = temp;
		}
	}
	static void printArray(int tempArr[])
	{
		for (int i=0; i<tempArr.length; i++)
			System.out.println(tempArr[i]);
	}
	static void enternumbers(int numbersIn[])
	{
		for(int i=0; i<numbersIn.length; i=i+1)
			{
				System.out.println("Enter a number: ");
				numbersIn[i]=scan.nextInt();
			}
	}
	public static void main(String args[])
	{
		int arr[];
		System.out.print("How many elements to store?: ");
		int size = scan.nextInt();
		arr = new int [size];
		enternumbers(arr);
		System.out.println("Unsorted array");
		printArray(arr);
		sort(arr);
		System.out.println("Sorted array");
		printArray(arr);
	}
}