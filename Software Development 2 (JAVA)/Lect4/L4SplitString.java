//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 26/02/2023
//Function: Fourth lab experience

import java.util.Scanner;

class L4SplitString
{
	public static void main(String [] args)
	{
		enter();
	}
	static void enter()
	{
		Scanner in=new Scanner(System.in);
		String str;
		String regExL[];
		System.out.printf("Please enter a sentence to split: ");
		str=in.nextLine();
		char charAr[]=str.toCharArray();

		System.out.println(" ");
		System.out.println("Length of string: "+charAr.length);
		System.out.printf("%n");
		System.out.printf(str);
		System.out.printf("%n");

		regExL=str.split(" ",999);
		for(int i=0;i<regExL.length;i++)
		{
			System.out.printf("[%s]%n",regExL[i]);
		}
	System.out.printf("%n");
	}
}