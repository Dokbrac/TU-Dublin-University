//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 19/02/2023
//Function: Third lab experience

import java.util.Scanner;

class L3BinarySearch
{
	public static void main(String []args)
	{
		Scanner in=new Scanner(System.in);

		String grocery[]={"yogurt","milk","oranges","lemons","bread","apples","butter","tea","coffee"};
		String temp;
		String word;
		int result;

		for (int j=0; j<grocery.length; j=j+1)
		{
	   	   for (int i=j+1; i<grocery.length; i=i+1)
	   	   {
			   if (grocery[i].compareTo(grocery[j])<0)
			   {
				   temp = grocery[j];
				   grocery[j] = grocery[i];
				   grocery[i] = temp;
			   }
		   }
		}
		System.out.println("Enter a grocery product to search for: ");
		System.out.println("");
		word=in.next();
		System.out.println("");

		result = binarySearch(grocery, word);
		if(result!=-1)
		{
			System.out.println("Product found");
		}
		else
		{
			System.out.println("Product not found");
		}
		System.out.println("");
	}
	static int binarySearch(String tempArray[], String key)
	{
		int first=0;
		int last=tempArray.length;

		while (first<last)
		{
			int mid=first+((last-first)/2);
		    if (key.compareTo(tempArray[mid])<0)
		    {
				last=mid;
		    }
		    else
		    	if (key.compareTo(tempArray[mid])>0)
		    	{
					first = mid+1;
				}
				else
				{
		             return mid;

		        }
		    }
		    return -1;
		}
}