/**
*Creating and configuring arrays.
*Project 06 
*@ Bryce Ellis- COMP-1210-001
*@ 3-1-2020
*/

public class Scores {

   private int [] numbers;
   
   /** 
   *@param numbersIn used for arrays.
   *setting up constructor
   */
   
   public Scores(int[] numbersIn) {
      numbers = numbersIn;
   }
   
   /**
   *param args not used.
   *@return null for arrays
   *finds even values
   */
   
   public int[] findEvens() {
      int numberEvens = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            numberEvens++;
         }
      }
      int[] evens = new int [numberEvens];
            
      int count = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            evens[count] = numbers[i];
            count++;
         }
      }
      return evens;
   } 
   
   /**
   *param args not used.
   *@return null for array 
   *finds odd values
   */
   
   public int[] findOdds() {
      int numberOdds = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 1) {
            numberOdds++;
         }
      }
      int[] odds = new int [numberOdds];
            
      int count = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 1) {
            odds[count] = numbers[i];
            count++;
         }
      }
      return odds;
                  
   }
   
   /**
   *param args not used.
   *@return avg for last array
   */   
   
   public double calculateAverage() {
      int sum = 0;
     
      for (int i = 0; i < numbers.length; i++) {
         sum += numbers[i];
      }
         
      return (double) sum / (double) numbers.length;
   }


   /**
   *param args not used.
   *@return toString for arrays
   */ 
   
   public String toString() {
      String result = "";
      for (int i = 0; i < numbers.length; i++) {
         result += numbers[i] + "\t";
      }
      return result;
   }
   
   
   /**
   *param args not used.
   *@return result reversetoString in reverse
   */ 
   
   public String toStringInReverse() {
      String result = "";
      for (int i = numbers.length - 1; i >= 0; i--) {
         result += numbers[i] + "\t";
      }   
      return result;
   }

}