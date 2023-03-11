import java.util.Scanner;

/**
*Finding the measurements of area using different conversions.
*Project 02 
*@ Bryce Ellis- COMP-1210-001
*@ 1-19-2020
*/

public class SquareUnits {

   /** 
   *Assigning variables for the conversions.
   *@param args Command line arguments - not used.
   */
   
   public static void main(String[] args) {
    
      Scanner userInput = new Scanner(System.in);
      int acres = 0;
      int squareyards = 0;
      int squarefeet = 0;  
      int squareinches = 0;
      
      //prompts user to input given area
      System.out.print("Enter the area in square inches: ");
      squareinches = userInput.nextInt();
     
     //sets limit on output values from input
      if (squareinches > 1000000000) {
         System.out.print("Limit of 1,000,000,000 square inches exceeded!");
      }
      
      //carries out calculations when area is under limit
      else {
         System.out.println("Number of Units: ");
      
         //converts area in square inches to acres
         acres = (squareinches / 6272640);
         System.out.println("\tAcres: " + acres);
         
        //converts area in square inches to square yards
         squareyards = ((squareinches % 6272640) / 1296);
         System.out.println("\tSquare Yards: " + squareyards);
         
         //converts area in square inches to square feet
         squarefeet = ((squareinches % 6272640 % 1296) / 144);
         System.out.println("\tSquare Feet: " + squarefeet);
         
         //converts area in square inches to square inches
         squareinches = (squareinches % 6272640 % 1296 % 144);
         System.out.println("\tSquare Inches: " + squareinches);
        
      }
   
   
   
   
   
   
   
   
   }

}