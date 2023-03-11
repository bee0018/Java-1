import java.util.ArrayList;
/**
*Creating Temperature class that hold values.
*Activity 06 
*@ Bryce Ellis- COMP-1210-001
*@ 2-16-2020
*/

public class Temperatures {
  
  /**
   *@param temperaturesIn used for variables.
   *sets variables up
   */
   
   private ArrayList<Integer> temperatures = new ArrayList<Integer>(); //placeholder ArrayList
  
   /**
   *@param temperaturesIn used for variables.
   */
   
   public Temperatures(ArrayList<Integer> temperaturesIn) {
      temperatures = temperaturesIn;
      
   }
   
   /**
   *@return 0 for placeholder
   *gets low temp
   */
   
   public int getLowTemp() {
   
      if (temperatures.isEmpty()) {
         return 0;
      }
         
      int low = temperatures.get(0);
      for (int i = 1; i < temperatures.size(); i++) {
         if (temperatures.get(i) < low) {
            low = temperatures.get(i);
         }
      }
      return low;
   }
      
      /** 
      *@return 0 for placeholder
      *gets high temp
      */
      
   public int getHighTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      
      int high = temperatures.get(0);
      for (Integer temp: temperatures) {
         if (temp > high) {
            high = temp;
         }
      }
      return high;
   }
   
   /**
   *@param lowIn used for variables.
   *@return integer value
   *gets low minimum value
   */
   
   public int lowerMinimum(int lowIn) {
      return lowIn < getLowTemp() ? lowIn : getLowTemp();
   }
      
      
   /**
   *@param highIn used for variables.
   *@return integer value
   *gets high minimum value
   */  
   
   public int higherMaximum(int highIn) {
      return highIn > getHighTemp() ? highIn : getHighTemp();
   }
         
      
   /** 
   *@return string for variable
   */
   
   public String toString() {
      return "\tTemperatures: " + temperatures
         + "\n\tLow: " + getLowTemp()
         + "\n\tHigh: " + getHighTemp();
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}