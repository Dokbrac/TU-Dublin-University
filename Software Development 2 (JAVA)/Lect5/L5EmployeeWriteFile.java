//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 04/03/2023
//Function: Fifth lab experience

import java.io.*;
import java.util.*;

class L5EmployeeWriteFile
	{
	DataOutputStream output;
	String pps;
	String first;
	String last;
	int weeklyPay;
	int weeklyTax;

	public L5EmployeeWriteFile()
	{
	try
	{
		output = new DataOutputStream(new FileOutputStream("employee.dat"));
    }
   	catch (IOException e)
   	{
		System.err.println("File not opened properly\n " +e.toString());
		System.exit(1);
   	}
	addRecord();
	}

	public void addRecord()
	{
	Scanner in=new Scanner(System.in);
	System.out.printf("Please enter PPS Number\n");
	pps=in.next();
	System.out.printf("Please enter First Name\n");
	first=in.next();
	System.out.printf("Please enter Last Name\n");
	last=in.next();
	System.out.printf("Please enter the Weekly Pay\n");
	weeklyPay=in.nextInt();
	System.out.println("Please enter the Weekly Tax (20% of Weekly Pay)");
	weeklyTax=in.nextInt();
	try
	{
		output.writeUTF(pps);
		output.writeUTF(first);
		output.writeUTF(last);
		output.writeInt(weeklyPay);
		output.writeInt(weeklyTax);
		output.close();
	}
	catch (Exception e)
	{
	      e.getStackTrace();
    }
	}
	public static void main(String args[])
	{
	new L5EmployeeWriteFile();
	}
}