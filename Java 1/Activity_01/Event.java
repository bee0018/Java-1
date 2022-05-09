import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

/**  
*Creating event passes using event code.
*Project 03 
*@ Bryce Ellis- COMP-1210-001
*@ 1-25-2020
*/

public class Event {

   /**
   *Setting up event pass info.
   *@param args Command line not used.
   */
   
   public static void main(String[] args) {
   
      Scanner eventcode = new Scanner(System.in);
      String code = "";
      String event = "";
      String year = "";
      String month = "";
      String day = "";
      String hour = "";
      String minutes = "";
      String section = "";
      String row = "";
      String seat = "";
      String price = "";
      String discount = "";
      String cost = "";
      double prizenumber = 0;
      int lengthresult = 0;
      String result = "";
      
   
   
      
   
      System.out.print("Enter your event code: ");
      code = eventcode.nextLine();
      lengthresult = code.length();
      result = code.trim();
   
     // Establish parameters.
      if (lengthresult < 26) {
         System.out.println("");
         System.out.println("Invalid Event Code.");
         System.out.println("Event code must have at least 26 characters.");
      }
      
      
      
      else { // Displays ticket info
         
      // Displays Event
         event = result.substring(25, result.length());  
         System.out.print("\nEvent: " + event);
      
      // Prints date
         year = result.substring(4, 8);
         month = result.substring(2, 4);
         day = result.substring(0, 2);
         System.out.print("   Date: " + day + "/" + month + "/" + year);
         
      // Prints time
         hour = result.substring(8, 10);
         minutes = result.substring(10, 12);
         System.out.println("   Time: " + hour + ":" + minutes);
         
      // Prints section
         section = result.substring(19, 21);
         System.out.print("Section: " + section);
      
      // Prints row
         row = result.substring(21, 23);
         System.out.print("   Row: " + row);
      
      // Prints seat
         seat = result.substring(23, 25);
         System.out.println("   Seat: " + seat);
         
      // Prints price
         price = result.substring(12, 17);
         double pricea = Double.parseDouble(price) / (100);
         DecimalFormat pricey = new DecimalFormat("$#,##0.00");
         System.out.print("Price: " + pricey.format(pricea));
      
      // Prints discount
         discount = result.substring(17, 19);
         double discounta = Double.parseDouble(discount) / (100);
         DecimalFormat discounty = new DecimalFormat("0%");
         System.out.print("   Discount: " + (discounty.format(discounta)));
         
       // Prints cost 
         double costa = (pricea * (1 - discounta));
         DecimalFormat costy = new DecimalFormat("$#,##0.00");
         System.out.println("   Cost: " + costy.format(costa));
       
       // Prints prize number
         Random generator = new Random();
         DecimalFormat prizenum = new DecimalFormat("0000");
         double prizenumbery = generator.nextDouble() * (1000);
         System.out.print("Prize Number: " + (prizenum.format(prizenumbery)));
         
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      }
   
   
   }







}
