//Turtle Graphics
import java.util.Scanner;

public class Turtle
{
  private static int currentX = 0;
  private static int currentY = 0;
  private static boolean penUp = true;
  private enum Direction {UP, DOWN, LEFT, RIGHT};
  private static int[][] floor = new int[20][20]; //20-by-20 array for tracking the turtle's movements
  
  public static void main(String[] args)
  {
    
    System.out.printf( "Welcome to Turtle Graphics%n" );
    System.out.printf( ":========================:%n" );
    System.out.printf( "Your commands are%n %-8d%s%n %-8d%s%n %-8d%s%n %-8d%s%n %-8s%s%n %-8d%s%n %-8d%s%n%n", 1, "Pen Up", 2, "Pen Down", 3, "Turn Right", 4, "Turn Left", "5, 10", "Move forward 10 spaces ( replace 10 for different number of spaces )", 6, "Display 20-by-20 array", 9, "End of data (sentinel)" );

    //Initializing the array to zeros
    for(int row = 0; row < floor.length; ++row) 
    {
      for(int col = 0; col < floor[row].length; ++col)
      {
        floor[row][col] = 0;
      }
    }
    
    //create a Scanner object to access its methods
    Scanner input = new Scanner(System.in);
    
    Direction direction = Direction.RIGHT; //default direction
    
    boolean shouldContinue = true;
    while(shouldContinue)
    {
      System.out.print("Please enter your command: ");
      String command = input.next();
      
      switch(command)
      {
        case "1":
          penUp = true;
          break;
          
        case "2":
          penUp = false;
          break;
        
        case "3":
          switch(direction)
        {
          case UP:
            direction = Direction.RIGHT;
            break;
           
          case DOWN:
            direction = Direction.LEFT;
            break;
          
          case LEFT:
            direction = Direction.UP;
            break;
           
          case RIGHT:
            direction = Direction.DOWN;
            break;
        }
          break;
          
        case "4":
          switch(direction)
        {
          case UP:
            direction = Direction.LEFT;
            break;
           
          case DOWN:
            direction = Direction.RIGHT;
            break;
          
          case LEFT:
            direction = Direction.DOWN;
            break;
           
          case RIGHT:
            direction = Direction.UP;
            break;
        }
          break;
       
        case "6":
          displayFloor(floor);
          break;
        
        case "9":
          shouldContinue = false;
          break;
          
        default:
          if(command.startsWith("5"))
        {
         int steps = Integer.parseInt(command.replace("5," , ""));
         switch(direction)
         {
           case UP:
             moveUp(steps);
             break;
             
           case DOWN:
             moveDown(steps);
             break;
           
           case LEFT:
             moveLeft(steps);
             break;
            
           case RIGHT:
             moveRight(steps);
             break;
         }//end switch
        }
          break;
      }//end switch
    }//end while
  }//end main
  
  public static void moveUp(int steps)
  {
    int end = currentY - steps;
    while(currentY > end)
    {
      if(penUp == false)
      {
        floor[currentX][currentY] = 1;
      }
      currentY--;
    }
  }//end method
  
  public static void moveDown(int steps)
  {
    int end = currentY + steps;
    while(currentY < end)
    {
      if(penUp == false)
      {
        floor[currentX][currentY] = 1;
      }
      currentY++;
    }
  }//end method
  
  public static void moveLeft(int steps)
  {
    int end = currentX - steps;
    while(currentX > end)
    {
      if(penUp == false)
      {
        floor[currentX][currentY] = 1;
      }
      currentX--;
    }
  }//end method
  
  public static void moveRight(int steps)
  {
    int end = currentX + steps;
    while(currentX < end)
    {
      if(penUp == false)
      {
        floor[currentX][currentY] = 1;
      }
      currentX++;
    }
  }//end method
  
  public static void displayFloor(int[][] array)
  {
    for(int row = 0; row < array.length; ++row) 
    {
      for(int col = 0; col < array[row].length; ++col)
      {
        if(array[row][col] == 1)
        {
          System.out.print("*");
        }
        else
        {
          System.out.print(" ");
        }
      }//end inner for loop
      
      System.out.println();
      
    }//end outer for loop
  }//end method 
  
}//end class