//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 19/02/2023
//Function: Third lab experience

import java.util.Scanner;

class L3LinearSearch
{
	public static void main(String []args)
	{
		Scanner in=new Scanner(System.in);

		int arr[]={10, 12, 16, 18, 21, 98, 13, 76, 77, 55};
		int temp;
		int number;
		int result;

		System.out.println("Enter a number: ");
		System.out.println("");
		number=in.nextInt();
		System.out.println("");

		result = linearSearch(arr, number);
		if(result!=-1)
		{
			System.out.println("Number found in array");
		}
		else
		{
			System.out.println("Number not found in array");
		}
		System.out.println("");
	}
	static int linearSearch(int[] arr,int number)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] == number)
			{
				return i;
	        }
	    }
	    return -1;
    }
}