import java.util.ArrayList;
import java.text.DecimalFormat;
/**
*Creating two instances of the same variable.
*Project 05 
*@ Bryce Ellis- COMP-1210-001
*@ 2-09-2020
*/

public class EllipsoidList {

   private String list = "";
   private ArrayList<Ellipsoid> eliplist = new ArrayList<Ellipsoid>();
   
   /**
   *@param listIn used for object.
   *@param eliplistIn used for object
   *sets variables up
   */
   
   public EllipsoidList(String listIn, ArrayList<Ellipsoid> eliplistIn) {
      list = listIn;
      eliplist = eliplistIn;
   }  
   
   /**
   *no paramters used.
   *@return list for list
   */
   
   public String getName() {
      return list;
   }
  
   /**
   *no paramters used.
   *@return eliplist.size for list
   */
  
   public int numberOfEllipsoids() {
      if (eliplist.size() == 0) {
         return 0;
      }
      else {
         return eliplist.size();
      }
   }
   
   /**
   *no paramters used.
   *@return totalVolume for list
   */
   public double totalVolume() {
      if (eliplist.size() == 0) {
         return 0;
      }
      
      else {
         int index = 0;
         double totalVolume = 0;
         while (index < eliplist.size()) {
            totalVolume += eliplist.get(index).volume();
            index++;
         }
         return totalVolume;
      }
   }
   
   /**
   *no paramters used.
   *@return totalSurfaceArea for list
   */
   
   public double totalSurfaceArea() {
      if (eliplist.size() == 0) {
         return 0;
      }
        
      else {
         int index = 0;
         double totalSurfaceArea = 0; //placeholder variable
         while (index < eliplist.size()) {
            totalSurfaceArea += eliplist.get(index).surfaceArea();
            index++; 
         }
         return totalSurfaceArea;     
      }
   }
   
   /**
   *no paramters used.
   *@return averageVolume for list
   */
   
   public double averageVolume() {
      if (eliplist.size() == 0) {
         return 0;
      }
      
      else {
         int index = 0;
         double averageVolume = 0;
         while (index < eliplist.size()) {
            averageVolume += eliplist.get(index).volume() / eliplist.size();
            index++;
         }
         
         return averageVolume;
      }
   }
   
   /**
   *no paramters used.
   *@return averageSurfaceArea for list
   */
   
   public double averageSurfaceArea() {
      if (eliplist.size() == 0) {
         return 0;
      }
      
      else {
         int index = 0;
         double averageSurfaceArea = 0;
         while (index < eliplist.size()) {
            averageSurfaceArea += eliplist.get(index).
               surfaceArea() / eliplist.size();
            index++;
         }
         
         return averageSurfaceArea;
      }    
   }
   
   /**
   *no paramters used.
   *@return String for list
   */
   
   public String toString() {
      String output = list + "\n";
      for (int index = 0; index < eliplist.size(); index++) {
         output += "\n" + eliplist.get(index).toString() + "\n";
      }
      return output;
   
   }
   
   
   /**
   *no paramters used.
   *@return output for list
   */
   
   public String summaryInfo() {
      DecimalFormat ob = new DecimalFormat("#,##0.0###");
      String output = "-----Summary for " + getName() + " -----";
      output += "\nNumber of Ellipsoid Objects: " + numberOfEllipsoids();
      output += "\nTotal Volume: " + ob.format(totalVolume()) + " cubic units";
      output += "\nTotal Surface Area: " 
         + ob.format(totalSurfaceArea()) + " square units";
      output += "\nAverage Volume: " 
         + ob.format(averageVolume()) + " cubic units";
      output += "\nAverage Surface Area: " 
         + ob.format(averageSurfaceArea()) + " square units";
      
      return output;
   
   
   
   }   
   
   
   
   
   
   
   
   
}
   
   
   
   
   
   
   
   
   

   
   









