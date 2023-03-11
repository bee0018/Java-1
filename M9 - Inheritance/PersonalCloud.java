/**
*Practice inheritance our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

public class PersonalCloud extends SharedCloud {

   /** Defines the cost factor to 3.*/
   public static final double COST_FACTOR = 3.0;
 
 /**
 *@param nameIn for cloud.
 *@param storagecostIn for cloud
 *@param datastorageIn for cloud
 *@param datalimitIn for cloud
 */
   
   public PersonalCloud(String nameIn, double storagecostIn,
      double datastorageIn, double datalimitIn) {
      super(nameIn, storagecostIn, datastorageIn, datalimitIn);
   }
   
   /**
   *@return COST_FACTOR  for the system.
   */
   public double getCostFactor() {
      return COST_FACTOR;
   }
   
   
   /**
   *@return output for the monthly cost.
   */
   
   public double monthlyCost() {
      double output = storagecost + dataOverage() * PersonalCloud.COST_FACTOR;
      return output;
   }

}