//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 19/11/2022
//Function: Cinema Ticketing System

import java.util.Scanner;//import Scanner

class Ass1B00148978
{
	public static void main(String[] args)
		{
		Scanner scan = new Scanner(System.in);

		String showmovie;//variable for name of the Show
		System.out.println("Please enter the name of the Show");
		showmovie = scan.next();


		String surname;//variable for name of the Patron
		System.out.println("Please enter the Surname of the Patron");
		surname = scan.next();


		int number;//variables to calculate the tickets and the prices
		double cost;
		char response;
		System.out.println("Please enter the number of people for this Show");
		number = scan.nextInt();

		if (number <= 5)//Y or N statement and ticket price calculation
		{
			cost = number*11;

			System.out.println("*************************************************************");
			System.out.println("Movie: " +showmovie);
			System.out.println("Surname: " +surname);
			System.out.println("No in Party : " +number);
			System.out.println("Cost: " +cost+ " Euro");
			System.out.println("");
			System.out.println("Process Another Ticket Y / N");
			System.out.println("*************************************************************");

			response = scan.next().toUpperCase().charAt(0);

			if (response == 'Y')
			{
				System.out.println("*************************************************************");
				System.out.println("Movie: " +showmovie);
				System.out.println("Surname: " +surname);
				System.out.println("No in Party : " +number);
				System.out.println("Cost: " +cost+ " Euro");
				System.out.println("");
				System.out.println("*************************************************************");
			}
			if (response == 'N')
			{
				System.out.println("*************************************************************");
				System.out.println("");
				System.out.println("Total number of tickets: " +number);
				System.out.println("");
				System.out.println("*************************************************************");
			}

		}
		else
		{
			cost = number*(11*0.9);


			System.out.println("*************************************************************");
			System.out.println("Movie: " +showmovie);
			System.out.println("Surname: " +surname);
			System.out.println("No in Party : " +number);
			System.out.println("Cost: " +cost+ " Euro");
			System.out.println("");
			System.out.println("Process Another Ticket Y / N");
			System.out.println("*************************************************************");

			response = scan.next().toUpperCase().charAt(0);

			if (response == 'Y')
			{
				System.out.println("*************************************************************");
				System.out.println("Movie: " +showmovie);
				System.out.println("Surname: " +surname);
				System.out.println("No in Party : " +number);
				System.out.println("Cost: " +cost+ " Euro");
				System.out.println("");
				System.out.println("*************************************************************");
			}
			if (response == 'N')
			{
				System.out.println("*************************************************************");
				System.out.println("");
				System.out.println("Total number of tickets: " +number);
				System.out.println("");
				System.out.println("*************************************************************");
			}
		}




		}
}
