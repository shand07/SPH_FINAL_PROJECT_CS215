package application;
	
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application 
{
	private boolean bartenderOneCollisionOccurred = false;
	private boolean bartenderTwoCollisionOccurred = false;
	private boolean bardCollisionOccurred = false;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) 
	{
		
		try 
			{
				
			MediaPlayer mediaPlayer;
			String s = "E:\\BlueMoonTavernStuff\\HalfMeasure.mp3";
			Media h = new Media(Paths.get(s).toUri().toString());
			mediaPlayer = new MediaPlayer(h);
			mediaPlayer.setAutoPlay(true);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			mediaPlayer.play();
			
			Tavern.ale.setPrice(2.00);
			Tavern.chicken.setPrice(8.00);
			Tavern.pork.setPrice(4.00);
			Tavern.menu.add(Tavern.ale);
			Tavern.menu.add(Tavern.chicken);
			Tavern.menu.add(Tavern.pork);
			
			
			System.out.println("Welcome Adventurer, to the Blue Moon Tavern. Please "
					+ "head to the bar and the bartender will");
			System.out.println("take your order. We are currently serving..");
			
			for(Object i: Tavern.menu.toArray())
			{
				System.out.print(i.toString());
				System.out.println();
			}
			
			launch(args);
			
			}
		
		catch(Exception e) 
			{
				e.printStackTrace();
			}
		
		finally
			{
				System.exit(0);
			}
	}
	@Override
	public void start(Stage primaryStage) 
	{
			
			primaryStage.setTitle("Blue Moon Tavern");//Program name
			BorderPane root = new BorderPane();//borderpane for window
			
			Image background = new Image("Tavern800by741.jpg");//Background image
			
			Scene scene = new Scene(root,800,741);//scene instantiation
		
			primaryStage.setAlwaysOnTop(true);//Keeps game screen up when using console
			
			scene.getStylesheets().add(getClass().getResource("application.css")
			.toExternalForm());
			
			primaryStage.setScene(scene);//sets scene to stage
			
			Image icon = new Image("BlueMoonTavIcon.jpg");//Program Icon
			primaryStage.getIcons().add(icon);
			
			Canvas canvas = new Canvas (800,741);//canvas so setting background
			GraphicsContext context = canvas.getGraphicsContext2D();
			root.setCenter(canvas);//puts canvas in the center of the borderpane
			
			/**
			 * Player control
			 */
			ArrayList<String> inputList = new ArrayList<String>();//arraylist for movement
			scene.setOnKeyPressed((KeyEvent event) ->//event handler for keypress
			{
				String keyName = event.getCode().toString();
				if(!inputList.contains(keyName))
					inputList.add(keyName);
			}
			);
			
			scene.setOnKeyReleased((KeyEvent event) ->//event handler for key release
			{
				String keyName = event.getCode().toString();
				inputList.remove(keyName);
			}
			);
			/**
			 * Sprites
			 */
			Sprite adventurer = new Sprite();//adventurer sprite
			adventurer.position.set(400, 600);//sprite position on screen
			adventurer.setImage("adventurer.png");//sprite image file
			
			Sprite bartenderOne = new Sprite();//bartender 1 sprite
			bartenderOne.position.set(410, 120);//sprite position on screen
			bartenderOne.setImage("Bartender2.png");//sprite image file
			
			Sprite bartenderTwo = new Sprite();//bartender 2 sprite
			bartenderTwo.position.set(550, 120);//sprite position on screen
			bartenderTwo.setImage("Bartender2.png");//sprite image file
			
			Sprite bard = new Sprite();//bard sprite
			bard.position.set(100, 180);//sprite position on screen
			bard.setImage("bard.gif");//sprite image file
			
			Sprite elfMaid = new Sprite();//elfMaid sprite
			elfMaid.position.set(680, 160);//sprite position on screen
			elfMaid.setImage("maid.png");//sprite image file
			
			Sprite patronOne = new Sprite();//elfMaid sprite
			patronOne.position.set(190, 400);//sprite position on screen
			patronOne.setImage("knight.png");//sprite image file
			
			Sprite patronTwo = new Sprite();//elfMaid sprite
			patronTwo.position.set(290, 275);//sprite position on screen
			patronTwo.setImage("necromancer.png");//sprite image file
			
			Sprite patronThree = new Sprite();//elfMaid sprite
			patronThree.position.set(430, 310);//sprite position on screen
			patronThree.setImage("stella.png");//sprite image file
			
			
			Sprite patronFour = new Sprite();//elfMaid sprite
			patronFour.position.set(515, 310);//sprite position on screen
			patronFour.setImage("ashe.png");//sprite image file
			
			Sprite doorMan = new Sprite();//elfMaid sprite
			doorMan.position.set(500, 630);//sprite position on screen
			doorMan.setImage("doorman.png");//sprite image file
			
			Sprite questOne = new Sprite();//elfMaid sprite
			questOne.position.set(401, 65);//sprite position on screen
			questOne.setImage("quest_icon.png");//sprite image file
			
			Sprite questTwo = new Sprite();//elfMaid sprite
			questTwo.position.set(541, 63);//sprite position on screen
			questTwo.setImage("quest_icon.png");//sprite image file
			
	
	AnimationTimer gameLoop = new AnimationTimer()//gameloop
	{
		public void handle(long nanoTime)//handler for player movement
		{
			adventurer.speed.set(0,0);//speed setter
			
			double speed = 70;
			if(inputList.contains("A"))//using A to move west
				{
				adventurer.speed.add(-speed,0);//speed factor
				
				}
			if(inputList.contains("D"))//using D for moving east
				{
				adventurer.speed.add(speed,0);//speed factor
				
				}
			if(inputList.contains("W"))//using W for moving north
				{
				adventurer.speed.add(0,-speed);//speed factor
				}
			if(inputList.contains("S"))//using S for moving south
				{
				adventurer.speed.add(0,speed);//speed factor
				}
			
			adventurer.speed.multiply(1/60.0);//math for calculation rate of movement
			adventurer.position.add(adventurer.speed);//more calcuation
			
			context.drawImage(background,0,0);//draws the background everytime the player moves
			adventurer.render(context);//renders player sprite 
			bartenderOne.render(context);//renders bartender one
			bartenderTwo.render(context);//renders bardtender two
			bard.render(context);//renders bard
			elfMaid.render(context);//renders elfMaid
			patronOne.render(context);
			patronTwo.render(context);
			patronThree.render(context);
			patronFour.render(context);
			doorMan.render(context);
			
			if(bartenderOneCollisionOccurred==false)
			{
				questOne.render(context);
			}
			
			if(bartenderTwoCollisionOccurred==false)
			{
				questTwo.render(context);
			}
			
			if (!bartenderOneCollisionOccurred && 
			adventurer.spriteOverlap(bartenderOne))
			//allows player to order from menu after overlapping sprites with bartender one 
			 {
                Order myOrder = new Order();//Order object
                myOrder.order();//method for placing order
                System.out.println("Your meal will be out shortly!");
                myOrder.orderTimer();
                Timer timer = new Timer();
            	TimerTask task = new TimerTask()
            			{
            				public void run()
            				{
            					System.out.println("Enjoy your meal!");
            					elfMaid.position.set(450, 210);
            				}
            			};
            	timer.schedule(task, 10000);
            	
            	TimerTask task2 = new TimerTask()
            			{
            				public void run()
            				{
            					
            					elfMaid.position.set(680, 160);//resets maid position
            					
            				}
            			};
            	timer.schedule(task2, 11000);
            	bardCollisionOccurred = false;//resets bard
            	bartenderTwoCollisionOccurred = false;//resets order mechanic
                bartenderOneCollisionOccurred=true;//allows movement after ordering
	         }
			
	              
	                
            if (!bardCollisionOccurred && 
            	adventurer.spriteOverlap(bard)) 
            	//allows player to interact with bard
	   			{
	                 System.out.println("la la la la");
	                 bartenderOneCollisionOccurred = false;//resets order mechanic
	             	bartenderTwoCollisionOccurred = false;//resets order mechanic
	                 bardCollisionOccurred = true;//allows movement
	   			}   
	              
          
            if (!bartenderTwoCollisionOccurred && 
            	adventurer.spriteOverlap(bartenderTwo))
            	//allows player to order from menu after overlapping sprites with bartender one 
			 {
            	Order myOrder = new Order();//Order object
                myOrder.order();//method for placing order
                System.out.println("Your meal will be out shortly!");
                myOrder.orderTimer();
                Timer timer = new Timer();
            	TimerTask task = new TimerTask()
            			{
            				public void run()
            				{
            					System.out.println("Enjoy your meal!");
            					elfMaid.position.set(600, 210);//moves maid near player
            				}
            			};
            	timer.schedule(task, 10000);
            	
            	TimerTask task2 = new TimerTask()
            			{
            				public void run()
            				{
            					
            					elfMaid.position.set(680, 160);//resets maid position
            					
            				}
            			};
            	timer.schedule(task2, 11000);
            	bardCollisionOccurred = false;//resets bard
            	bartenderOneCollisionOccurred = false;//resets order mechanic
                bartenderTwoCollisionOccurred=true;//allows movement after ordering
                
			 } 
                    
	}
			
	};
			
		
			gameLoop.start();//starts game loop
			primaryStage.show();//shows the stage
	}
	
	
    
}
	

