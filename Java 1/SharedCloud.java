import java.text.DecimalFormat;

/**
*Practice inheritance our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

public class SharedCloud extends CloudStorage {

   protected double datastored;
   protected double datalimit;
   
   /** COST_FACTOR used for describing limit.*/
   public static final double COST_FACTOR = 1.0;

   /**
   *@param nameIn for cloud.
   *@param storagecostIn for cloud
   *@param datastoredIn for cloud
   *@param datalimitIn for cloud 
   */
   
   public SharedCloud(String nameIn, double storagecostIn, 
      double datastoredIn, double datalimitIn) {
      super(nameIn, storagecostIn);
      datastored = datastoredIn;
      datalimit = datalimitIn;
   }
   
   
   /**
   *@return datastored for data storage.
   */
   public double getDataStored() {
      return datastored;
   }
   
   /**
   *@param datastoredIn for cloud
   *Sets the data storage limit.
   */
   public void setDataStored(double datastoredIn) {
      datastored = datastoredIn;
   }
   
   /**
   *@return datalimit for this class.
   */
   public double getDataLimit() {
      return datalimit;
   }
   
   /**
   *Sets the data limit for this class.
   *@param datalimitIn for the class
   */
   public void setDataLimit(double datalimitIn) {
      datalimit = datalimitIn;
   }
      
   /**
   *@return COST_FACTOR for the cost factor.
   */
   public double getCostFactor() {
      return COST_FACTOR;
   }
      
   /**
   *@return output for the data overage.
   *Shows the data average
   */
   public double dataOverage() {
      double output = 0.0;
      output = datastored - datalimit;
      if (output < 0) {
         return 0; 
      } 
      return output;
   }
   
   /**
   *@return output representing monthly cost.
   */
   public double monthlyCost() {
      double output = (storagecost + dataOverage() * SharedCloud.COST_FACTOR);
      return output;
   }
   
   /**
   *@return toString() for the given characteristics.
   */
   public String toString() {
      DecimalFormat df = new DecimalFormat("###,##0.000 GB");
      return super.toString() + "\nData Stored: " 
         + df.format(datastored) + "\nData Limit: "
         + df.format(datalimit) + "\nOverage: " + df.format(this.dataOverage())
         + "\nCost Factor: " + this.getCostFactor();
   }
}