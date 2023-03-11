/**
*Practice inheritance our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

public class PublicCloud extends SharedCloud {

/** Uses cost factor as a method in purchase.*/
   public static final double COST_FACTOR = 2.0;
   
   /**
   *@param nameIn for the cloud.
   *@param storagecostIn for the cloud
   *@param datastorageIn for the cloud
   *@param datalimitIn for the cloud
   */
   
   public PublicCloud(String nameIn, double storagecostIn,
      double datastorageIn, double datalimitIn) {
      super(nameIn, storagecostIn, datastorageIn, datalimitIn);
   }
   
   /**
   *@return COST_FACTOR for the class.
   */
   public double getCostFactor() {
      return COST_FACTOR;
   }

   /**
   *@return output for the system.
   */
   public double monthlyCost() {
      double output = storagecost + dataOverage() * PublicCloud.COST_FACTOR;
      return output;
   }



}