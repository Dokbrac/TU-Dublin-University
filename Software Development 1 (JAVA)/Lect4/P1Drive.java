//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 29/10/2022
//Function: Fourth lab experience

import java.util.Scanner;

class P1Drive
{
	public static void main(String[] args)
		{
		char type;
		Scanner scan = new Scanner(System.in);


		System.out.println("If you have a full driver license type A if you have a provisional license type B");
		type = scan.next().toUpperCase().charAt(0);

		if (type == 'A')
		{
			System.out.println("You can drive alone");
		}
		else
		{
			System.out.println("You can not drive alone");
		}

	}
}