import java.util.ArrayList;

/**
*Creating two instances of the same variable.
*Activity 05 
*@ Bryce Ellis- COMP-1210-001
*@ 2-09-2020
*/

public class NumberOperations {

   private int number;
   


   public NumberOperations(int numberIn) {
      number = numberIn;
   }

/**
*no paramters used.
*@return placeholder value
*/
   
   public int getValue() {
      return number;
   }

/**
*no paramters used.
*@return placeholder value
*@return output for output
*/

   public String oddsUnder() {
      String output = ""; //placeholder
      int i = 0;
      while (i < number) {
         if (i % 2 !=0) {
            output += i + "\t";
         }
         i++;
        
            
      
      }
      return output;
   }
   
 /**
*no paramters used.
*@return placeholder value
*/
 
   public String powersTwoUnder() {
      String output = "";
      int powers = 1;
      while (powers < number) {
         output += powers + "\t";
         powers = powers * 2;
      }
      powers++;
   
      return output;
   }
      
 /**
*no paramters used.
*@return placeholder value
*/
 
   public int isGreater(int compareNumber) {
      if (number > compareNumber ){
         return 1;
      }
      if (number < compareNumber) {
         return -1;
      }
         
      else {
         return 0;
      }
   }
      
 /**
*no paramters used.
*@return placeholder value
*/

   public String toString() {
      return number + ""; 
   }
   
  
   
   

}