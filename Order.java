package application;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Queue;
import java.util.LinkedList;

public class Order 
{//startorderclass
static Scanner scan = new Scanner(System.in);
public static String again;
public static int choose, quantity;
public static double total;
static Queue<Item> order = new LinkedList<Item>();

public static void order()
	{//startorder()
		System.out.println("Press 1 to order Ale, Press 2 to order Chicken, "
		+ "Press 3 to order Pork, Press 4 to Cancel");
		System.out.print("Which would you like to buy? :");
		choose = scan.nextInt();
		
		if(choose==1)
			{//start1
				System.out.println("You choose Ale");
				System.out.print("How many Ales would you like to buy?");
				quantity = scan.nextInt();
				for(int i=0; i<quantity;i++)
					{//startforloop
						order.add(Tavern.ale);
					}//endforloop
				
				System.out.println("Would you like anything else?(y/n)");
				again = scan.next();
				if(again.equalsIgnoreCase("y"))
					{//startif
						order();
					}//endif
			}//end1
		else if(choose==2)
		{//start2
			System.out.println("You choose Chicken");
			System.out.print("How many Chickens would you like to buy?");
			quantity = scan.nextInt();
			for(int i=0; i<quantity;i++)
				{//startforloop
					order.add(Tavern.chicken);
				}//endforloop
			
			System.out.println("Would you like anything else?(y/n)");
			again = scan.next();
			if(again.equalsIgnoreCase("y"))
				{//startif
					order();
				}//endif
		
		}//end2
		else if(choose==3)
		{//start3
			System.out.println("You choose Pork");
			System.out.print("How much Pork would you like to buy?");
			quantity = scan.nextInt();
			for(int i = 0; i < quantity; i++)
				{//startforloop
					order.add(Tavern.pork);
				}//endforloop
			
			System.out.println("Would you like anything else?(y/n)");
			again = scan.next();
			if(again.equalsIgnoreCase("y"))
				{//startif
					order();
				}//endif
		}//end3
		else if(choose==4)
		{//start4
			System.out.println("Thank you for your patronage");
		}//end4
	}//endorder()
public void orderTimer()
{
	Timer timer = new Timer();
	TimerTask task = new TimerTask()
			{
				public void run()
				{
					for(int i = 0; i < quantity; i++)//forloop to count through orders
					{
						order.remove();//removes item at head of the order queue
					}
					System.out.println("Order up!");
				}
			};
	timer.schedule(task, 5000);
	
}
}//endorderclass
