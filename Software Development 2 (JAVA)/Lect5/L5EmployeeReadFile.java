//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 04/03/2023
//Function: Fifth lab experience

import java.io.*;

class L5EmployeeReadFile
{
	DataInputStream input;

	public L5EmployeeReadFile()
	{
		try
		{
		input = new DataInputStream(new FileInputStream("employee.dat"));
		}
		catch (IOException e)
		{
	   	System.err.println("File not opened properly\n " +e.toString());
		System.exit(1);
		}
	readRecord();
	}
	public void readRecord()
	{
		String pps;
		String first;
		String last;
		int weeklyPay;
		int weeklyTax;
		boolean cont = true;
	do {
		try {
			pps=input.readUTF();
			first=input.readUTF();
			last=input.readUTF();
			weeklyPay=input.readInt();
			weeklyTax=input.readInt();

			System.out.println("Employee pps number: "+pps);
			System.out.println("Employee first name: "+first);
			System.out.println("Employee last name: "+last);
			System.out.println("Employee weeklyPay: "+weeklyPay+"Euro");
			System.out.println("Employee weeklyTax: "+weeklyTax+"Euro");
			}
		catch (Exception e)
			{
			      e.getStackTrace();
    		}
		}
		while(cont);
	}
public static void main(String args[])
	{
	new L5EmployeeReadFile();

	}
}