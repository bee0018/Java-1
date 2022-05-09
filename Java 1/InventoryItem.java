/**
*Practice inheritance our classes.
*Activity 09
*@ Bryce Ellis- COMP-1210-001
*@ 3-30-2020
*/

public class InventoryItem {

   protected String name;
   protected double price;
   private static double taxRate = 0;
   
   /**
   *@param nameIn for inventory.
   *@param priceIn for inventory
   */
   
   public InventoryItem(String nameIn, double priceIn) {
      name = nameIn;
      price = priceIn;
   }
   
   /** @return name for the customer.**/
   public String getName() {
      return name;
   }
   
   /** @return price and tax for final cost.**/
   public double calculateCost() {
      return price * (1 + taxRate);
   }
   
   /** 
   *Sets the tax rate to a value.
   *@param taxRateIn for variables
   **/
   public static void setTaxRate(double taxRateIn) {
      taxRate = taxRateIn;
   }
   
   /** @return name along with customer details.**/
   public String toString() {
      return name + ": $" + calculateCost();
   }



}