/**
*Practice inheritance our classes.
*Activity 09
*@ Bryce Ellis- COMP-1210-001
*@ 3-30-2020
*/

public abstract class OnlineTextItem extends InventoryItem {

  /**
  *@param nameIn for this class.
  *@param priceIn for this class
  */
   public OnlineTextItem(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   }

  /** @return price for this type of item.**/
   public double calculateCost() {
      return price;
   }



}
