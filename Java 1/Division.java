

/**
*Practice exceptions in our classes.
*Activity 11
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

public class Division {
   
   /**
   *@param numerator for divison.
   *@param denominator for divison
   *@return output for the result.
   */
   public static int intDivide(int numerator, int denominator) {
      try {
         int output = numerator / denominator;
         return output;
      }
      catch (ArithmeticException e) {
         return 0;
      }
   }
   
   /**
   *@param numerator for divison.
   *@param denominator for divison
   *@return output for the result.
   */
   public static float decimalDivide(int numerator, int denominator) {
      float output = (float) numerator / denominator;
      if (denominator == 0) {
         throw new IllegalArgumentException("The denominator " 
            + "cannot be zero.");
      }
      return output;
   }
}