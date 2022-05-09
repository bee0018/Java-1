import java.io.File;  	
import java.text.DecimalFormat;  	
import java.io.FileNotFoundException;  	
import java.util.Scanner; 	
 /**  	
 *Creating two instances of the same variable.  	
 *Project 06 	  	
 *@ Bryce Ellis- COMP-1210-001	  	
 *@ 2-09-2020	  	
 */
   	
public class EllipsoidList2 {	  	
   private String list;	  	
   private Ellipsoid[] eliplist;	  	
   private int numofellipsoids;	  	
    
    /**	  	
    *@param listIn used for object.	  	
    *@param eliplistIn used for object	  	
    *@param numofellipsoidsIn for object	  	
    *sets variables up  	
    */
   public EllipsoidList2(String listIn, Ellipsoid[] eliplistIn,	  	
        int numofellipsoidsIn) {	  	
      list = listIn;	  	
      eliplist = eliplistIn;	  	
      numofellipsoids = numofellipsoidsIn;	  	
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
      if (numofellipsoids == 0) {	  	
         return 0;	  	
      }
       	  	
      return numofellipsoids;	  	
   }	  	
    	  	
    /**	  	
    *no paramters used.	  	
    *@return totalVolume for list	  	
    */	  	
   public double totalVolume() {	  	
      if (numofellipsoids == 0) {	  	
         return 0;	  	
      }	  	
        	
      else {  	
         int index = 0;	  	
         double totalVolume = 0;
          	  	
         for (index = 0; index < numofellipsoids; index++) {	  	
            totalVolume += eliplist[index].volume();	  	
         }
          	  	
         return totalVolume;	  	
      }	  	
   }  	
    	  	
    /**	  	
    *no paramters used.	  	
    *@return totalSurfaceArea for list
    */
      	
   public double totalSurfaceArea() {  	
      if (numofellipsoids == 0) {
         return 0;
      }
       	
      double totalSurfaceArea = 0;  	
      for (int index = 0; index < numofellipsoids; index++) {
         totalSurfaceArea += eliplist[index].surfaceArea();
      }	
      return totalSurfaceArea;	
   }
      	
    /**  	
    *no paramters used. 	
    *@return averageVolume for list
    */
    	
   public double averageVolume() {	  	
      if (numofellipsoids == 0) {
         return 0;
      }
     	
      double averageVolume = 0;
     	
      for (int index = 0; index < numofellipsoids; index++) {
      
         averageVolume += (eliplist[index].volume() / numofellipsoids);	
      }  
   
      return averageVolume;	  	
   }   	
    /**  	
    *no paramters used. 	
    *@return averageSurfaceArea for list
    */
     	
   public double averageSurfaceArea() {	  	
      if (numofellipsoids == 0) {
         return 0;  	
      }   	
      double averageSurfaceArea = 0;
      for (int index = 0; 
          index < numofellipsoids; index++) {
         averageSurfaceArea += (eliplist[index].surfaceArea() 
             / numofellipsoids);
      }
         	
      return averageSurfaceArea; 	
   }
 	  	
    /** 	
    *no paramters used. 	
    *@return String for list
    */
      	
   public String toString() {	  	
      String output = getName() + "\n";
      int index = 0;
      while (index < numofellipsoids) {
         output += "\n" + eliplist[index] + "\n";
         index++;
      }
     
      return output;  	
   }
    	  	
    /**
    *no paramters used.
    *@return output for list	  	
    */
    
   public String summaryInfo() {
      DecimalFormat ob = new DecimalFormat("#,##0.0##");
      System.out.print("\n");
      String output = "----- Summary for " + getName() + " -----";
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
     	
    /**
    *no parameters used.
    *@return eliplist for list	  	
    */
    
   public Ellipsoid[] getList() {
      return eliplist;  	
   }  	
       	
    /** 
    *@param fileNameIn for list.
    *@return Ellipoid object
    *@throws FileNotFoundException   	
    */
   public EllipsoidList2 readFile(String fileNameIn)
       throws FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      Ellipsoid[] lista = new Ellipsoid[100];	
      list = scanFile.nextLine();
   
      while (scanFile.hasNext()) {
         String labelIn = scanFile.nextLine();
         double aIn = Double.parseDouble(scanFile.nextLine());
         double bIn = Double.parseDouble(scanFile.nextLine());
         double cIn = Double.parseDouble(scanFile.nextLine());  	
         Ellipsoid eob = new Ellipsoid(labelIn, aIn, bIn, cIn);	
         lista[numofellipsoids] = eob;  	
         numofellipsoids++;	  	
      } 	
      EllipsoidList2 elist1 = new EllipsoidList2(list,
         lista, numofellipsoids);  	
      return elist1;  	
   }
      	
    /**	
    *@param labelIn for list. 	
    *@param aIn for list 	
    *@param bIn for list	  	
    *@param cIn for list  	
    */     	
   public void addEllipsoid(String labelIn, 
       double aIn, double bIn, double cIn) {
      Ellipsoid eliptemp = new Ellipsoid(labelIn, aIn, bIn, cIn);
      eliplist[numofellipsoids] = eliptemp;
      numofellipsoids++;  	
   }
	  	
    /**	
    *@param labelIn used for list.	
    *@return eliptemp for list  	
    *finds ellipsoid  	
    */ 	
   public Ellipsoid findEllipsoid(String labelIn) {
      Ellipsoid result = null;
      for (int index = 0; index < numofellipsoids; index++) {
      
         if (eliplist[index].getLabel().equalsIgnoreCase(labelIn)) {
            result = eliplist[index];
         } 	
      }	
      return result;  	
   }  	
    /**  	
    *@param labelIn used for list. 	
    *deletes ellipsoid	  	
    *@return deleted for list  	
    */
    	
   public Ellipsoid deleteEllipsoid(String labelIn) {	  	
      Ellipsoid result = null;	  	
      for (int i = 0; i < numofellipsoids; i++) {	  	
         if (eliplist[i].getLabel().equalsIgnoreCase(labelIn)) {	  	
            result = eliplist[i];
               	
            for (int j = i; j < numofellipsoids; j++) {  	
               eliplist[j] = eliplist[j + 1];	  	
            }
               	
            eliplist[numofellipsoids - 1] = null;  	
            numofellipsoids--;   	
            break; 	
         }  	
      }  	
      return result;	  	
   }  	
    /**	  	
    *@param labelIn for list.  	
    *@param aIn for list  	
    *@param bIn for list  	
    *@param cIn for list  	
    *@return re for final mods  	
    */ 	
   public Ellipsoid editEllipsoid(String labelIn, 	  	
       double aIn, double bIn, double cIn) { 	
      Ellipsoid re = findEllipsoid(labelIn);
       	
      for (int i = 0; i < numofellipsoids; i++) {   	
         if (eliplist[i].getLabel().equalsIgnoreCase(labelIn)) {
           	
            eliplist[i].setA(aIn);
            eliplist[i].setB(bIn);	  	
            eliplist[i].setC(cIn);	  	
            re = eliplist[i];	  	
               	
         }  	
      }	  	
      return re;            	
   } 
   
   /**
   *This returns the ellipsoid with the smallest volume.
   *@return output for smallest volume
   */
   
   public Ellipsoid findEllipsoidWithSmallestVolume() {
      int index = numofellipsoids - 1;
      
      for (int i = 0; i < numofellipsoids; i++) {
         Ellipsoid obj = eliplist[i];
         Ellipsoid eob = eliplist[index];
         index--;
         if (obj.volume() > eob.volume()) {
            Ellipsoid small = eob;
            return eob; 
         }
      }
      return null;     
   } 	
   
   /**
   *This returns the ellipsoid with the largest volume.
   *@return output for largest volume
   */
   
   public Ellipsoid findEllipsoidWithLargestVolume() {
      int index = numofellipsoids - 1;
      
      for (int i = 0; i < numofellipsoids; i++) {
         Ellipsoid obj = eliplist[i];
         Ellipsoid eob = eliplist[index];
         index--;
         if (obj.volume() > eob.volume()) {
            Ellipsoid large = obj;
            return obj; 
         }
      }
      return null;     
   }
    
    
    /**
   *This returns the ellipsoid with the smallest surface area.
   *@return output for smallest surface area
   */  
   
   public Ellipsoid findEllipsoidWithSmallestSurfaceArea() {
      int index = numofellipsoids - 1;
      
      for (int i = 0; i < numofellipsoids; i++) {
         Ellipsoid obj = eliplist[i];
         Ellipsoid eob = eliplist[index];
         index--;
         if (obj.surfaceArea() < eob.surfaceArea()) {
            Ellipsoid small = obj;
            return obj; 
         }
      }
      return null;     
   }
   
   /**
   *This returns the ellipsoid with the smallest surface area.
   *@return output for smallest surface area
   */ 
   public Ellipsoid findEllipsoidWithLargestSurfaceArea() {
      int index = numofellipsoids - 1;
      
      for (int i = 0; i < numofellipsoids; i++) {
         Ellipsoid obj = eliplist[i];
         Ellipsoid eob = eliplist[index];
         index--;
         if (obj.surfaceArea() > eob.surfaceArea()) {
            Ellipsoid large = obj;
            return obj; 
         }
      }
      return null;     
   }
}
 
	  	
