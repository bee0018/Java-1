import java.text.DecimalFormat;

/**
*Practice inheritance our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

public class DedicatedCloud extends CloudStorage {

   private double servercost;
   /**
   *@param nameIn for new cloud.
   *@param storagecostIn for new cloud
   *@param servercostIn for new cloud
   */
   
   public DedicatedCloud(String nameIn, 
      double storagecostIn, double servercostIn) {
      super(nameIn, storagecostIn);
      servercost = servercostIn;
   }
   
   
   /**
   *Returns the cost of the server.
   *@return servercost the cost of the server
   */
   public double getServerCost() {
      return servercost;
   }
   
   /**
   *Sets the server cost of the system.
   *@param servercostIn for the final cost
   */
   public void setServerCost(double servercostIn) {
      servercost = servercostIn;
   }
   
   /**
   *Shows the monthly cost of the system.
   *@return output for the system
   */
   public double monthlyCost() {
      double monthlycost;
      double output = super.storagecost + servercost;
      return output;
   }
   
   /**
   *Shows the toString for this file.
   *@return name along with other characteristics
   */
   public String toString() {
      DecimalFormat df = new DecimalFormat("$###,###.00");
      
      return super.toString() + "\nServer Cost: " + df.format(servercost);
   }
}