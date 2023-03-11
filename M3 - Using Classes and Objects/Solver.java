import java.util.Scanner;
import java.text.DecimalFormat;

/**
*Creating program to evaluate expression.
*Project 03 
*@ Bryce Ellis- COMP-1210-001
*@ 1-25-2020
*/

public class Solver {

 /** 
 *Setting up expression for evaluation.
 *@param args Command arguments not used.
 */
 
   public static void main(String[] args) {
   
      Scanner userInput = new Scanner(System.in);
      double x = 0;
      double result = 0;
      
   
      
      // Prompts user for x value.
      System.out.print("Enter a value for x: ");
      x = userInput.nextDouble();
      
      // Calculating epression.
      result = (11 * Math.pow(x, 4)) + (9 * Math.pow(x, 3)) 
         + (7 * Math.pow(x, 2)) + (5 * x) + 4;
      result = Math.abs(result);
      result = Math.sqrt(result);
      result = result / ((2 * x) + 4);
      
      // Display result.
      System.out.println("Result: " + result);
      
      // Change result into String.
      String stringresult = Double.toString(result);
      
      // Find decimal point.
      int decimalpoint = stringresult.indexOf(".");
      
      // Find length of string.
      int lengthresult = stringresult.length();
      
      // Show index left of decimal.
      System.out.println("# of characters to left of decimal point: " 
         + decimalpoint);
      
      // Show index right of decimal.
      System.out.println("# of characters to right of decimal point: "
          + (lengthresult - decimalpoint - 1));
      
      // Formats the result.
      String pattern = "#,##0.0####";
      DecimalFormat decimalformat = new DecimalFormat(pattern);
      String resultx = decimalformat.format(result);
      
      //Displays result.
      System.out.println("Formatted Result: " + resultx);
      
      
   
   
   
   
   
   
   
   
   }
 













}