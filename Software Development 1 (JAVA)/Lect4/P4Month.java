//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 29/10/2022
//Function: Fourth lab experience

import java.util.Scanner;

class P4Month
{
	public static void main(String[] args)
		{
		int month;

		Scanner scan = new Scanner(System.in);

		System.out.println("PLease enter a number between 1 and 12");
		month = scan.nextInt();

		switch (month)
		{
		case 1: System.out.println("January");
		break;
		case 2: System.out.println("February");
		break;
		case 3: System.out.println("March");
		break;
		case 4: System.out.println("April");
		break;
		case 5: System.out.println("May");
		break;
		case 6: System.out.println("June");
		break;
		case 7: System.out.println("July");
		break;
		case 8: System.out.println("August");
		break;
		case 9: System.out.println("September");
		break;
		case 10: System.out.println("October");
		break;
		case 11: System.out.println("November");
		break;
		case 12: System.out.println("December");
		break;
		default: System.out.println("Not valid number");
		}


	}
}