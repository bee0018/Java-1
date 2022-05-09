import java.util.Scanner;
import java.util.ArrayList;

/**
*Creating Temperature class that hold values.
*Activity 06 
*@ Bryce Ellis- COMP-1210-001
*@ 2-16-2020
*/

public class TemperatureInfo {

/**
*@param args not used
*displays info for temperature object.
*Shown in array list form
*/

   public static void main(String[] args) {
   
      //introduces variables
      
      Scanner userInput = new Scanner(System.in);
      ArrayList<Integer> tempList = new ArrayList<Integer>();
      String tempInput = "";
      
      //introduces input 
      
      do {
         System.out.print("Enter a temperature (or nothing to end list): ");
         tempInput = userInput.nextLine().trim();
         
         if (!tempInput.equals("")) {
            tempList.add(Integer.parseInt(tempInput));
         }
      }
            
      while (!tempInput.equals("")); 
      
         
      Temperatures temps = new Temperatures(tempList);
      
      //prompts user for choices
      
      char choice = 'E';
      do {
         System.out.print("Enter choice - [L]ow temp," 
            + "[H]igh temp, [P]rint, [E]nd: ");
         choice = userInput.nextLine().toUpperCase().charAt(0);
         switch (choice) {
            case 'L':
               System.out.println("\tLow is " + temps.getLowTemp());
               break;
               
            case 'H':
               System.out.println("\tHigh is " + temps.getHighTemp());
               break;
                  
            case 'P':
               System.out.println(temps);
               break;
                  
            case 'E':
               System.out.println("\tDone");
               break;
                    
            default: 
               System.out.println("\tInvalid choice!");
         }
                    
      } while (choice != 'E');
                    
      
      
         
      
   
   
   
   
   
   
   
   }





}


