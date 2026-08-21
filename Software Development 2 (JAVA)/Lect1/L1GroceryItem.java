//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 05/02/2023
//Function: First lab experience

class L1GroceryItem
{
	String name="Potatoes";
	String supplier="John Smith";
	int stockLevel=10;
	double price=2.5;
	int reOrderLevel=20;

	public void display()
	{
		System.out.println(" ");
		System.out.println("Name of product: "+name);
		System.out.println("Supplier of product: "+supplier);
		System.out.println("Stocklevel of product: "+stockLevel+" kg");
		System.out.println("Price of product: "+price+" Euro/kg");
		System.out.println("Reorderlevel of product: "+reOrderLevel+" kg");
	}

}
