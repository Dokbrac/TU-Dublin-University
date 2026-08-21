//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 10/12/2022
//Function: Ninth lab experience

import java.util.Scanner;

class L9TemperatureReadings
{
	public static void main(String[]args)
	{
		Scanner scan = new Scanner(System.in);

		double temperature[]=new double[7];

		for(int i=0; i<temperature.length; i++)
			{
				System.out.println("max temperature for day " + (i+1));
				temperature[i]=scan.nextDouble();

			}
			System.out.println();
			System.out.println("***TEMPERATURES ENTERED***");

		for(int i=0; i<temperature.length; i++)
			{
				if(temperature[i]>18)
				{
					System.out.println("day "+(i+1)+"   "+temperature[i]);
				}
			}
	}
}