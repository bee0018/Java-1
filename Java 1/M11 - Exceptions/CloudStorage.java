import java.text.DecimalFormat;

/** 
*Practice inheritance our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

public abstract class CloudStorage implements Comparable<CloudStorage> {

   protected String name;
   protected double storagecost;
   protected static int count = 0;
   
   /**
   *@param nameIn for Cloud name.
   *@param storagecostIn for Cloud cost
   */
   
   public CloudStorage(String nameIn, double storagecostIn) {
      name = nameIn;
      storagecost = storagecostIn;
      count++;
   }
   
   /**
   *Methods gets the name of Cloud.
   *@return name of cloud
   */
   public String getName() {
      return name;
   }
    
    /**
    *@param nameIn for Cloud.
    *sets the name for the cloud
    */
   public void setName(String nameIn) {
      name = nameIn;
   }
   
   
   /** 
   *Method gets the base storage cost.
   *@return storagecost for cloud
   */
   public double getBaseStorageCost() {
      return storagecost;
   }
   
   /**
   *@param storagecostIn for Cloud.
   *sets the storage cost for the cloud
   */
   public void setBaseStorageCost(double storagecostIn) {
      storagecost = storagecostIn;
   }
   
   /**
   *Gets the count of cloud info.
   *@return count of the clouds
   */
   public static int getCount() {
      return count;
   }
   
   /**
   *Resets the count for cloud info.
   */
   public static void resetCount() {
      count = 0;
   }
   
  /**
  *Returns the toString for the cloud info.
  *@return name info along with other characteristics
  */
   public String toString() {
      DecimalFormat df = new DecimalFormat("$###,###.00");
      
      return name + " (" + this.getClass() + ") Monthly Cost: " 
         + df.format(this.monthlyCost()) + "\nBase Storage Cost: "
         + df.format(storagecost);  
   }
   
   
   /**
   *Makes the placeholder method for the monthly cost.
   *@return monthlycost for final cost
   */
   public abstract double monthlyCost();
   
   /**
   *Makes the compare method to distinguish clouds.
   *@return result for the distinction
   *@param cloud for the comparison of clouds
   */
   public int compareTo(CloudStorage cloud) {
      int output = this.getName().toLowerCase().
         compareTo(cloud.getName().toLowerCase());
      return output;
   }
}

