//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 12/04/2023
//Function: Eighth lab experience
import java.util.*;

public class L8Queue
{
	public static void main(String[] args)
	{
		Queue<String>queue=new LinkedList<String>();
		queue.add("Saturday");
		queue.add("Sunday");
		queue.add("Monday");
		queue.add("Tuesday");
		queue.add("Wednesday");
		queue.add("Thursday");
		queue.add("Friday");

		System.out.println("Elements in Queue: "+queue);
		System.out.println("");

		queue.remove();
		queue.remove();

		System.out.println("Elements in Queue after removal: "+queue);
		System.out.println("");
	}
}