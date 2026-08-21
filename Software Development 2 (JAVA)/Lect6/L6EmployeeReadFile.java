//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 09/04/2023
//Function: Sixth lab experience

import java.io.*;

public class L6EmployeeReadFile
{
	RandomAccessFile input;
	Record data;

	public L6EmployeeReadFile()
	{
		data = new Record();

		try
		{
			input = new RandomAccessFile("credit.dat","rw");
		}
		catch(IOException e)
		{
		System.err.println(e.toString());
		System.exit(1);
		}
		readRecord();
	}
	public void readRecord()
	{
		boolean cont = true;

		do
		{
			try
			{
				data.read(input);

				if(data.getAccount()!=0)
				{
					System.out.printf("Acc No: %d%n", data.getAccount()  );
					System.out.printf("ID: %s%n", data.getIdEmployee() );
					System.out.printf("First: %s%n", data.getFirstName() );
					System.out.printf("Last: %s%n", data.getLastName() );
					System.out.printf("Balance: %.2f %n", data.getBalance() );
					System.out.printf("########################%n" );
			 	}
		 	}
		 	catch(EOFException eof)
		 	{
				closeFile();
			}
			catch(IOException e)
			{
				System.err.println("Error during read from file\n " + e.toString() );
		 		System.exit( 1 );
		 	}
		 }
		 while(cont);
		 closeFile();
	}
	private void closeFile()
	{
		try
		{
			input.close();
			System.exit( 0 );
		}
		catch(IOException e)
		{
			System.err.println( "Error closing file \n" + e.toString());
		}
	}
	public static void main(String [] args)
	{
		new L6EmployeeReadFile();
	}
}