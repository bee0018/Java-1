import java.util.Scanner;

/**
*Finding the results from specified expressions after reading input values.
*Project 02 
*@ Bryce Ellis- COMP-1210-001
*@ 1-19-2020
*/

public class Expression {

  /**
  *Using input values to create and calculate expression. 
  *@param args Command line arguments - not used.
  */

   public static void main(String [] args) {
   
      Scanner userInput = new Scanner(System.in);
      double x = 0;
      double y = 0;
      double result = 0;
      
      //Provides the equation for user and input values
      System.out.println("result = (10x + 32.6) (5y - 1.567) / xy ");
      
      //creates input space for x-value
      System.out.print("\tx = ");
      x = userInput.nextDouble();
       
      //creates input space for y-value        
      System.out.print("\ty = ");
      y =  userInput.nextDouble();
      
      //makes equation undefined if divided by 0
      if (x == 0 || y == 0) { 
         System.out.print("result is \"undefined\"");
      }
        
      //makes equation follow through normally if math is legal   
      else { 
         result = (10 * x + 32.6) * (5 * y - 1.567) / (x * y);
         System.out.print("result = " + result); 
      
      }
   }
}

