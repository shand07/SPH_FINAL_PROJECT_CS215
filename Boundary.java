package application;

public class Boundary 
{
	public double x,y,width,height;
	
	public Boundary(double x, double y, double width, double height)
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}

	public boolean overlap(Boundary other)
	{
		boolean noOverlap =
				this.x + this.width < other.x  ||
				other.x + other.width < this.x ||
				this.y + this.height < other.y ||
				other.y + other.height < this.y;
		return !noOverlap;
				
	}
}
