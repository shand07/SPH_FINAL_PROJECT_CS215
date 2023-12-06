package application;

import javafx.scene.image.Image;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.canvas.GraphicsContext;

public class Sprite 
{
	public Vector position,speed;
	public Image image;
	public Boundary bound;
	
	
	public Sprite()
	{
		position = new Vector(0,0);
		speed = new Vector(0,0);
		bound = new Boundary(0,0,0,0);
	}

	public void setPosition(double x, double y)
	{
		
		position.set(x,y);
		
	}
	
	public void setImage(String fileName)
	{
		image = new Image(fileName);
		bound.width = image.getWidth();
		bound.height = image.getHeight();
	}
	
	public Boundary getBoundary()
	{
		bound.x = position.x;
		bound.y = position.y;
		
		return bound;
				
	}
	
	public boolean spriteOverlap(Sprite other)
	{
		return this.getBoundary().overlap(other.getBoundary());
	}
	
	public void render(GraphicsContext context)
	{
		context.drawImage(image, position.x, position.y);
	}


	
}
