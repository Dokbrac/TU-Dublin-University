//Programmer: Csaba Palosi
//Student ID: B00148978
//Date Written: 13/04/2023
//Function: Ninth lab experience

class L9TestShape
{
	public static void main(String args[])
	{
		Triangle t=new Triangle();
		t.area(5,6);
		Circle c=new Circle();
		c.area(3);
		Rectangle r=new Rectangle();
		r.area(4,2);
	}
}

abstract class Shape
{
	public void area()
	{
		System.out.println("Find area");
	}
}
class Triangle extends Shape
{
	public void area(double b, double h)
	{
		System.out.println("Triangle area= "+0.5*b*h);
	}
}
class Circle extends Shape
{
	public void area(int r)
	{
		System.out.println("Circle area= "+Math.PI*r*r);
	}
}
class Rectangle extends Shape
{
	public void area(int l, int b)
	{
		System.out.println("Rectangle area= "+l*b);
		super.area();
	}
}