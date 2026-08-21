//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 12/04/2023
//Function: Seventh lab experience

import java.io.Serializable;
import java.util.ArrayList;

public class L7Employee implements Serializable
{
	private static final long serialVersionUID = 1L;

    private String first;
    private String last;
    private double salary;

    public L7Employee(String first, String last, double salary)
    {
		this.first = first;
        this.last  = last;
        this.salary = salary;
    }
    public void setFirstName(String fname){this.first=first;}
    public String getFirstName(){return this.first;}
    public void setLastName(String lname){this.last=last;}
    public String getLastName(){return this.last;}
    public void setSalary(double salary){this.salary=salary;}
    public double getSalary(){return this.salary;}

    public String toString()
    {
		return new StringBuffer("\nFirst Name: ").append(this.first)
		.append("\nLast Name : ").append(this.last)
		.append("\nWeekly Salary : ").append(this.salary).toString();
	}
    public void printDet(ArrayList<L7Employee> Employee)
    {
		for (int i = 0; i < Employee.size(); i++)
		{
			System.out.printf("Employee "+(i+1)+": "+Employee.get(i));
		}

    }

}