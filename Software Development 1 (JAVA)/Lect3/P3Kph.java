//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 22/10/2022
//Function: Third lab experience

import java.util.Scanner;

class  P3Kph
{
	public static void main(String[] args)
		{
		Scanner scan = new Scanner(System.in);

		double kmph, mph;

		System.out.println("Please enter the speed of the car by kmph");
		kmph = scan.nextDouble();

		double convert = kmph/10*6;
		System.out.println("The speed you entered in mph is " +convert);


	}
}