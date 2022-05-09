import java.text.DecimalFormat;
/**
*Creating two instances of the same variable.
*Project 04 
*@ Bryce Ellis- COMP-1210-001
*@ 2-02-2020
*/

public class Ellipsoid {
   
   //declares instance variables
   private String label = "";
   private double a = 0;
   private double b = 0;
   private double c = 0;

  
   /**
   *@param labelIn used for String.
   *@param aIn used for expression
   *@param bIn used for expression
   *@param cIn used for expression
   */
   
   public Ellipsoid(String labelIn, double aIn, double bIn, double cIn) {
      setLabel(labelIn);
      setA(aIn);
      setB(bIn);
      setC(cIn);
   }
   
   /**
   *no parameters listed.
   *@return label
   */
   
   public String getLabel() {
      return label;
   }
   
   /** 
   *@param labelIn used for expression.
   *@return true for expression
   *Sets label for expression
   */
   
   public boolean setLabel(String labelIn) {
      boolean isSet = true;
      if (labelIn != null) {
         label = labelIn.trim();
         return isSet;
      }
      
      else {
         return false;
      }
   
   }

   /**
   *args not used for expression.
   *@return a for expression
   *gets a for expression
   */

   public double getA() {
      return a;
   }

   /**
   *@param aIn used for expression.
   *@return setA for expression
   */

   public boolean setA(double aIn) {
      boolean isSet;
      if (aIn > 0) {
         isSet = true;
         a = aIn;
      }
      
      else {
         isSet = false;
      }
      
      return isSet;
   } 
    /**
    *args not used.
    *@return double for expression
    *sets b for expression
    */
    
   public double getB() {
      return b;
   }
      
   /**
   *@param bIn used for expression.
   *@return setB for expression
   */
   
   public boolean setB(double bIn) {
      boolean isSet;
      if (bIn > 0) {
         isSet = true;
         b = bIn;
      }
          
      else {
         isSet = false;
      }
      
      return isSet;
   }

   /**
   *no paramters used.
   *@return c for expression 
   */

   public double getC() {
      return c;
   }
   
   /**
   *@param cIn used for expression.
   *@return setC for expression
   */
   
   public boolean setC(double cIn) {
      boolean isSet;
      if (cIn > 0) {
         isSet = true;
         c = cIn;
      }
         
      else {
         isSet = false;
      }
      return isSet; 
   }


   /**
   *accepts no parameters.
   *@return volume for expression
   *calcualtes volume
   */
   
   public double volume() {
      double volume1 = ((4 * Math.PI * a * b * c) / (3));
      return volume1;
   }
   
   /**
   *accepts no parameters.
   *@return surfacearea for expression
   *calculates surface area
   */

   public double surfaceArea() {
      double result = (Math.pow((a * b), 1.6)
         + Math.pow((a * c), 1.6)
         + Math.pow((b * c), 1.6)) / 3;
      result = Math.pow(result, (1 / 1.6));
      result = (4 * Math.PI * result);
      double surfacearea = result;
      return surfacearea;
   }
   
   /**
   *no paramters accepted.
   *@return output used for expression
   *returns ellipsoid values
   */
   
      
   public String toString() {
      DecimalFormat ellipsoid = new DecimalFormat("#,##0.0###");
      String output = ("Ellipsoid \"" + label 
         + "\" with axes a = " + a + ", b = " + b + ", c = "
         + c + " units has: "
         + "\n\tvolume = " + ellipsoid.format(volume())
          + " cubic units" + "\n\tsurface area = " 
          + ellipsoid.format(surfaceArea()) 
          + " square units");
      
      return output; 
   }







}


