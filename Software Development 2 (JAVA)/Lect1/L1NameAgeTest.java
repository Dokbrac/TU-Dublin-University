//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 05/02/2023
//Function: First lab experience

import java.util.Scanner;

public class L1NameAgeTest
{
	public static void main(String[]args)
	{
		Scanner scan=new Scanner(System.in);

		L1NameAge nameage=new L1NameAge();

		System.out.println("Please enter the name: ");
		String thename=scan.nextLine();

		nameage.setName(thename);

		System.out.println("Please enter age ");
		String theage=scan.nextLine();

		nameage.setAge(theage);

		System.out.println(" ");
		System.out.println("The entered name is: "+nameage.getName());
		System.out.println(" ");
		System.out.println("The entered age is: "+nameage.getAge());
	}
}