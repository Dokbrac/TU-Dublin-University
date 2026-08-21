//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 04/03/2023
//Function: Fifth lab experience

import java.io.*;

class L5FileOutput
{
	DataOutputStream output;

	public L5FileOutput()
	{

		byte byteArray[] = {2,4,6,2,4,5,9,10,12,89};
		try
		{
			output = new DataOutputStream(new FileOutputStream("file1.dat"));
    	}
   		catch (IOException e)
   		{
			System.err.println("File not opened properly\n " +e.toString());
			System.exit(1);
   		}
   		try
   		{
		output.write(byteArray);
		}
		catch (IOException io)
		{
		System.err.println("Error during write to file\n " +io.toString());
		System.exit(1);
   		}
   		try
   		{
		output.close();
		}
		catch (IOException io)
		{
		System.err.println("File not closed properly\n " +io.toString());
   		}
   	}
	public static void main(String args[])
	{
	new L5FileOutput();
	}
}