//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 09/04/2023
//Function: Sixth lab experience

import java.io.*;
import javax.swing.*;
import java.util.*;

class Record
{
	private int account;
	private String idEmployee;
	private String firstName;
	private String lastName;
	private double balance, overdraft;

	public void read(RandomAccessFile file)throws IOException
	{
		account=file.readInt();

		char id[]=new char[15];

		for(int i=0; i<id.length; i++)
		{
			id[i]=file.readChar();
		}

		idEmployee=new String(id);

		char first[]=new char[15];

		for(int i=0; i<first.length; i++)
		{
			first[i]=file.readChar();
		}

		firstName=new String(first);

		char last[]=new char[15];

		for(int i=0; i<last.length; i++)
		{
			last[i]=file.readChar();
		}

		lastName=new String(last);

		balance=file.readDouble();
	}
	public void write(RandomAccessFile file)throws IOException
	{
		StringBuffer buf;

		file.writeInt(account);

		if(idEmployee != null)
		{
			buf=new StringBuffer(idEmployee);
		}
		else
		{
			buf=new StringBuffer(15);
		}

		buf.setLength(15);

		file.writeChars(buf.toString());

		if(firstName != null)
		{
			buf=new StringBuffer(firstName);
		}
		else
		{
			buf=new StringBuffer(15);
		}

		buf.setLength(15);

		file.writeChars(buf.toString());

		if(lastName != null)
		{
			buf=new StringBuffer(lastName);
		}
		else
		{
			buf=new StringBuffer(15);
		}

		buf.setLength(15);

		file.writeChars(buf.toString());

		file.writeDouble(balance);
	}
	public void setAccount(int a) {account=a;}
	public int getAccount() {return account;}
	public void setIdEmployee(String i) {idEmployee=i;}
	public String getIdEmployee() {return idEmployee;}
	public void setFirstName(String f) {firstName=f;}
	public String getFirstName() {return firstName;}
	public void setLastName (String l) {lastName=l;}
	public String getLastName() {return lastName;}
	public void setBalance(double b) {balance=b;}
	public double getBalance() {return balance;}
	public static int size() {return 102;}
}
class CreateRandomFile
{
	private Record blank;
  	private RandomAccessFile file;

  	public CreateRandomFile()
  	{
		blank=new Record();

		try
		{
			file=new RandomAccessFile("credit.dat","rw");

			for(int i=0; i<100; i++)
			{
				blank.write(file);
			}
		}
		catch(IOException e)
		{
			System.err.println("File not opened properly\n" + e.toString() );
			System.exit(1);
		}
	}
}
class L6EmployeeWriteFile
{
	int accountNumber=0;
	String id;
	String first;
	String last;
	double balance;
	int count=0;

	private RandomAccessFile output, input;
	private Record data;
	Scanner scan=new Scanner(System.in);

	public L6EmployeeWriteFile()
	{
		data=new Record();

		try
		{
			output=new RandomAccessFile("credit.dat","rw");
			System.out.println("In first try block");
		}
		catch(IOException e)
		{
			System.err.println(e.toString());
			System.exit(1);
		}
		addRecord();
	}
	public void addRecord()
	{
		System.out.println("How many accs do your wish to process?");
		count=scan.nextInt();
		do
		{
			try
			{
				System.out.println("Please enter Account number  between 1 & 100");
				accountNumber=scan.nextInt();
				System.out.println("Please enter Employee ID");
				id=scan.next();
				System.out.println("Please enter first name");
				first=scan.next();
				System.out.println("Please enter last name");
				last=scan.next();
				System.out.println("Please enter your weekly pay");
				balance=scan.nextDouble();
				System.out.println("In second try block");

				if(accountNumber<1 || accountNumber>100)
				{
					System.out.println("Account number must be between 1 & 100, please try again");
				}
				if(accountNumber>0 && accountNumber<= 100)
				{
					output.seek((long) (accountNumber - 1) * Record.size());
	   				data.read(output);

	   				if(data.getAccount()==accountNumber)
	   				{
						System.out.println("Account already exists! Please try a different account number");

						count++;
					}
					else
					{
						data.setAccount(accountNumber);
						data.setIdEmployee(id);
						data.setFirstName(first);
						data.setLastName(last);
						data.setBalance( balance);
						output.seek( (long) ( accountNumber-1 ) * Record.size() );
						data.write( output );
						System.out.println("Account written successfully");
					}
				}
			}
			catch(NumberFormatException nfe)
			{
				System.err.println("You must enter an integer account number");
			}
			catch (IOException io)
			{
				System.err.println("error during write to file\n" + io.toString() );
			}
			count--;
		}
		while(count>0);

		closeFile();
	}
	public void closeFile()
	{
		try
		{
			output.close();
		}
		catch(IOException io)
		{
			System.err.println( "File not closed properly\n" + io.toString() );
		}
	}
	public static void main(String []args)
    {
		CreateRandomFile accounts = new CreateRandomFile();
     	new L6EmployeeWriteFile();
    }
}