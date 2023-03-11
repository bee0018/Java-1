import java.util.Scanner;

/**
*Creating two instances of the same variable.
*Project 04
*@ Bryce Ellis- COMP-1210-001
*@ 2-02-2020
*/

public class EllipsoidApp {


   /**
   *Using input values to create and calculate expression. 
   *@param args Command line arguments - not used.
   */
   
   public static void main(String[] args) {
    
      double a = 0;
      double b = 0;
      double c = 0;
      String label = "";
      Scanner ellipsoid = new Scanner(System.in);
      
      System.out.println("Enter label and axes a, b, c for an ellipsoid.");
       
    // prompts user for label
      System.out.print("\tlabel: ");
      label = ellipsoid.nextLine();
    
    // prompts user for a
      System.out.print("\ta: ");
      a = ellipsoid.nextDouble();
      
    // sets up a parameters
      if (a <= 0) {
         System.out.println("Error: axis value must be positive.");
         return;
      }
        
    // prompts user for b
      System.out.print("\tb: ");
      b = ellipsoid.nextDouble();
      
      
    // sets up b parameters
      if (b <= 0) {
         System.out.println("Error: axis value must be positive.");
         return;
      }  
          
     // prompts user for c 
      System.out.print("\tc: ");
      c = ellipsoid.nextDouble();
         
     // sets up c parameters
      if (c <= 0) {
         System.out.println("Error: axis value must be positive.");
         return;
      }
         
      else {
         Ellipsoid object = new Ellipsoid(label, a, b, c);
         System.out.println("\n" + object);
      }
             
    
    
    
    
    
   }









}