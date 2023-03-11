/**
*Practice inheritance our classes.
*Activity 09
*@ Bryce Ellis- COMP-1210-001
*@ 3-30-2020
*/

public class ElectronicsItem extends InventoryItem {

 
   protected double weight;
   /**
   *weight used in this class.
   *SHIPPING_COST used for extra cost
   */
   public static final double SHIPPING_COST = 1.5;
   
   /**
   *@param nameIn for electronic item.
   *@param priceIn for electronic item
   *@param weightIn for electronic item
   */
   public ElectronicsItem(String nameIn, double priceIn, double weightIn) {
      super(nameIn, priceIn);
      weight = weightIn;
   }

   /**@return super calculated cost for new item.**/
   public double calculateCost() {
      return super.calculateCost() + (SHIPPING_COST * weight);
   }


}