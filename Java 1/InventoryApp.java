/**
*Practice inheritance our classes.
*Activity 09
*@ Bryce Ellis- COMP-1210-001
*@ 3-30-2020
*/

public class InventoryApp {

    /** 
    *@param args Command line not used.
    *Prints inventory information
    */
    
   public static void main(String[] args) {
      InventoryItem.setTaxRate(0.05);
      
      InventoryItem item1 = new InventoryItem("Oil change kit", 39.0);
      System.out.println(item1);
      
      ElectronicsItem item2 = new ElectronicsItem("Cordless phone", 80.0, 1.8);
      System.out.println(item2);
      
      OnlineArticle item3 = new OnlineArticle("Java News", 8.50);
      item3.setWordCount(700);
      System.out.println(item3);
      
      OnlineBook item4 = new OnlineBook("Java for Noobs", 13.37);
      item4.setAuthor("L.G. Jones");
      System.out.println(item4);
   
   
   
   
   }



}