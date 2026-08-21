//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 12/04/2023
//Function: Eighth lab experience
import java.util.*;

public class L8StackAnimals
{
	public static void main(String[]args)
	{
		Scanner scan=new Scanner(System.in);

		Stack<String>animal=new Stack<String>();
        animal.push("Dog");
        animal.push("Cat");
        animal.push("Rabbit");
        animal.push("Giraffe");
        animal.push("Elephant");
        animal.push("Cow");
        animal.push("Pelican");
        animal.push("Goldfish");

        System.out.println("Enter an animal for searching: ");
        String name=scan.nextLine();
        System.out.println("");

        int result=(animal.search(name));

        if(result==-1)
        {
			System.out.println("Not found");
			System.out.println("");
		}
		else
		{
			System.out.println("Found");
			System.out.println("PLace in the List: " + animal.search(name));
			System.out.println("");
		}
    }
}