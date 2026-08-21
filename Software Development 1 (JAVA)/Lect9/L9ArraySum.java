//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 10/12/2022
//Function: Ninth lab experience

public class L9ArraySum
{
	public static void main(String[]args)
	{
		int data[]={2,4,6,9,5,4,5,7,12,15,21,32,45,5,6,7,12};

		int sum;
		sum=0;
		for(int x=0; x<data.length; x++)
			{
			sum=sum+data[x];
			System.out.println(sum);
			}
		System.out.println("\r");
		int pro;
		pro=0;
		for(int y=0; y<data.length; y++)
		{
			pro=pro*data[y];
			System.out.println(pro);
		}
		System.out.println("\r");
		for(int i=0; i<data.length; i++)
		{
			if(data[i]%3==0)
				{
				System.out.println(data[i]);
				}
		}
		System.out.println("\r");
		for(int c=0; c<data.length; c++)
		{
			if(data[c]==5)
				{
				System.out.println(data[c]);
				}
		}
	}
}

