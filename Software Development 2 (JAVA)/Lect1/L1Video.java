//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 05/02/2023
//Function: First lab experience

class L1Video
{
	String name="Star Wars";
	String director="George Lucas";
	String category="Action";
	String rating="4.5/5";
	double price=15;
	boolean borrowed=true;

	public void display()
	{
		System.out.println(" ");
		System.out.println("Name of video: "+name);
		System.out.println("Director of video: "+director);
		System.out.println("Category of video: "+category);
		System.out.println("Rating of video: "+rating);
		System.out.println("Price of video: "+price+" Euro");
		System.out.println("Video borrowed: "+borrowed);
	}
}