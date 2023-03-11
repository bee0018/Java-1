import java.util.Comparator;

/** 
*Practice inheritance our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

public class MonthlyCostComparator implements Comparator<CloudStorage> {
   
   /**
   *@param c1 for the object being compared.
   *@param c2 for the other object being compared
   *@return -1, 1, 0 to establish order
   */
   public int compare(CloudStorage c1, CloudStorage c2) {
      if (c1.monthlyCost() > c2.monthlyCost()) {
         return -1;
      }
      
      else if (c1.monthlyCost() < c2.monthlyCost()) {
         return 1;
      }
      
      else {
         return 0;
      }
   }
}