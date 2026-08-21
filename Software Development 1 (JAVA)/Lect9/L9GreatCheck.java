//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 10/12/2022
//Function: Ninth lab experience

class L9GreatCheck
{
	public static void main(String[]args)
	{

		int number[]={3,22,2,26,4,5,7,19,7,12,56,43,23,7,18};

		for(int i=0; i<number.length; i++)
			{
				if(number[i]>number[14])
				{
					System.out.println("number "+(i+1)+"   "+number[i]);
				}
			}
	}
}