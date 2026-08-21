//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 12/04/2023
//Function: Seventh lab experience

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class L7WriteEmployeeObject {

	public static void main(String args[])
	{
		ArrayList<L7Employee> employee = new ArrayList<>();
		L7Employee e1 = new L7Employee("John","Frost",600);
		L7Employee e2 = new L7Employee("Mary","Moran",550);
		L7Employee e3 = new L7Employee("Jake","Dunne",480);
		L7Employee e4 = new L7Employee("Csaba","Palosi",650);
		L7Employee e5 = new L7Employee("Tom","Nollan",620);

		employee.add(e1);
		employee.add(e2);
		employee.add(e3);
		employee.add(e4);
		employee.add(e5);
		WriteObjectToFile(employee);
		employee.toString();
	}
    public static void WriteObjectToFile(ArrayList<L7Employee> employee)
    {
        try
        {
			System.out.println("In first try ");
            FileOutputStream fileOut = new FileOutputStream("employee.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(employee);
            objectOut.flush();
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        }
        catch
        (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Problem writing to file ");
        }
    }
}