//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 12/04/2023
//Function: Eighth lab experience
import java.util.*;

public class L8RandomLinkedList
{
     public static void main(String args[])
     {
         LinkedList<Integer>linkedlist=new LinkedList<Integer>();
         linkedlist.add(1+(int)(Math.random()*100));
         linkedlist.add(1+(int)(Math.random()*100));
         linkedlist.add(1+(int)(Math.random()*100));
         linkedlist.add(1+(int)(Math.random()*100));
         linkedlist.add(1+(int)(Math.random()*100));
         linkedlist.add(1+(int)(Math.random()*100));
         linkedlist.add(1+(int)(Math.random()*100));
         linkedlist.add(1+(int)(Math.random()*100));
         linkedlist.add(1+(int)(Math.random()*100));
         linkedlist.add(1+(int)(Math.random()*100));
         linkedlist.add(1+(int)(Math.random()*100));
         linkedlist.add(1+(int)(Math.random()*100));

         System.out.println("12 random numbers 1-100");
         System.out.println("");
         System.out.println("Unsorted Linked List: "+linkedlist);
         System.out.println("");

         Collections.sort(linkedlist);

         System.out.println("Sorted Linked List: "+linkedlist);
         System.out.println("");

         System.out.println("Largest random number in Linked List: "+Collections.max(linkedlist));
         System.out.println("");

         System.out.println("Smallest random number in Linked List: "+Collections.min(linkedlist));
         System.out.println("");

     }
}