//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 04/03/2023
//Function: Fifth lab experience

import java.io.*;

class L5FileInput
	{
		DataInputStream input;

		public L5FileInput()
		{
		byte byteArray[] = new byte[10];
		try
		{
		input = new DataInputStream(new FileInputStream("file1.dat"));
    	}
		catch (IOException e)
   		{
			System.err.println("File not opened properly\n " +e.toString());
			System.exit(1);
   		}
		try
		{
		input.read(byteArray);
		for(int i = 0; i < byteArray.length; i++)
		System.out.println("Position " +i+ " " +byteArray[i]);
		}
		catch (IOException io)
		{
		System.err.println("Error during read from file\n " +io.toString());
		System.exit(1);
   		}
   		try
   		{
		input.close();
		}
		catch (IOException io)
		{
		System.err.println("File not closed properly\n " +io.toString());
   		}
	}
	public static void main(String args[])
	{
	new L5FileInput ();
	}
}