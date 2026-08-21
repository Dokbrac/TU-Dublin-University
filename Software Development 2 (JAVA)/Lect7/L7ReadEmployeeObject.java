//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 12/04/2023
//Function: Seventh lab experience

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class L7ReadEmployeeObject
{
	public static void main(String args[])
	{
		ArrayList <L7Employee> employee = new ArrayList<>();

		ReadObjectFromFile(employee);

    }
    public static void ReadObjectFromFile(ArrayList<L7Employee> employee)
    {
		try
		{
			FileInputStream fileIn=new FileInputStream("employee.ser");
			ObjectInputStream objectIn=new ObjectInputStream(fileIn);

			employee=(ArrayList<L7Employee>)objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            System.out.println("ArrayList size = " +employee.size());
            printDet(employee);
        }
        catch(Exception ex)
        {
			ex.printStackTrace();
		}
	}
	public static void printDet(ArrayList<L7Employee> employee)
	{
		for (int i = 0; i < employee.size(); i++)
		{
			System.out.printf("\nEmployee " +(i+1)+":"+employee.get(i));
		}
		System.out.println();
    }
}