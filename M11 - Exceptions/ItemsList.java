/**
*Practice polymorphism our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

public class ItemsList {

   private InventoryItem [] inventory;
   private int count;
   
   /**The constructor of the class and assignments.**/
   public ItemsList() {
      inventory = new InventoryItem[20];
      count = 0;
   }
   
   /**
   *@param itemIn for the add item.
   *Increments count
   */
   public void addItem(InventoryItem itemIn) {
      inventory [count] = itemIn;
      count++;
   }
   
   /**
   *@param electronicsSurcharge for the calculated total.
   *@return electronicsSurcharge for the method
   */
   public double calculateTotal(double electronicsSurcharge) {
      double total = 0;
      for (int i = 0; i < count; i++) {
         if (inventory[i] instanceof ElectronicsItem) { 
            total += inventory[i].calculateCost() + electronicsSurcharge;
         }
         else {
            total += inventory[i].calculateCost();
         }
      }
      return total;
   }
   
   /**
   *The toString for the following class.
   *@return output for the toString result
   */
   public String toString() {
      String output = "All inventory:\n\n";
   
      for (int i = 0; i < count; i++) {
         output += inventory [i] + "\n";
      }
      return output;
   }
   
}