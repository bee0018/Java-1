/** 
*Practice making exceptions in our classes.
*Project 11
*@ Bryce Ellis- COMP-1210-001
*@ 4-16-2020
*/

public class InvalidCategoryException extends Exception {

   /**
   *@param categoryIn representing the invalid category character.
   */
   public InvalidCategoryException(String categoryIn) {
      super("For category: " + categoryIn);
   }
}