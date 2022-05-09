import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
*Practice testing the method for our object.
*Project 08B
*@ Bryce Ellis- COMP-1210-001
*@ 3-22-2020
*/

public class EllipsoidList2Test {

/**Method tests to see if name gets returned.**/
   @Test public void getNameTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ellipsoid 1", 1, 1, 1);
      test[1] = new Ellipsoid("Ellipsoid 2", 4, 4, 4);
      test[2] = new Ellipsoid("Ellipsoid 3", 9, 9, 9);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid", test, 3);
      Assert.assertEquals("Ellipsoid", e.getName());
   }
   
   /**Method tests to see if number of ellipsoids is returned correctly.**/
   @Test public void numberOfEllipsoidsTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ellipsoid 1", 1, 1, 1);
      test[1] = new Ellipsoid("Ellipsoid 2", 4, 4, 4);
      test[2] = new Ellipsoid("Ellipsoid 3", 9, 9, 9);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid", test, 3);
      Assert.assertEquals(3, e.numberOfEllipsoids());
   }
   
   /**Method tests to see if total volume is returned correctly.**/
   @Test public void totalVolumeTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid", test, 3);
      Assert.assertEquals(4.189138079624109E7, e.totalVolume(), .00001);
   }
   
    /**Method tests to see if total volume is returned correctly.**/
   @Test public void totalSurfaceAreaTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid", test, 3);
      Assert.assertEquals(674531.564495284, e.totalSurfaceArea(), .00001);
   }
   
   /**Method tests to see if average volume is returned correctly.**/
   @Test public void averageVolumeTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid", test, 3);
      Assert.assertEquals(1.3963793598747028E7, e.averageVolume(), .00001);
   }
   
   /**Method tests to see if the average surface area is returned correctly.**/
   @Test public void averageSurfaceAreaTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid", test, 3);
      Assert.assertEquals(224843.85483176133, e.averageSurfaceArea(), .00001);
   }


   /** A test that checks to see if the toString functions properly.**/
   @Test public void toStringTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid", test, 3);
      String output = "Ellipsoid\n" + "\nEllipsoid "
         + "\"Ex 1\"" + " with axes a = 1.0, b = 2.0, c = 3.0 units has:" 
         + "\n\tvolume = 25.1327 cubic units"
         + "\n\tsurface area = 48.9366 square units\n"
         + "\nEllipsoid " + "\"Ex 2\""
         + " with axes a = 2.3, b = 5.5, c = 7.4 units has: " 
         + "\n\tvolume = 392.1127 cubic units"
         + "\n\tsurface area = 317.9245 square units\n"
         + "\nEllipsoid " + "\"Ex 3\" with axes a = 123.4,"
         + " b = 234.5, c = 345.6 units has: " 
         + "\n\tvolume = 41,890,963.5508 cubic units"
         + "\n\tsurface area = 674,164.7034 square units";
      Assert.assertEquals(true, e.toString().contains("Ex 2"));
     
   }
   
   /** A test that checks to see if the toString functions properly.**/
   @Test public void summaryInfoTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid 1", test, 3);
      String output = "\n" + "   ----- Summary for Ellipsoid -----\n"
         + "Number of Ellipsoid Objects: 3\n"
         + "Total Volume: 41,891,380.796 cubic units\n"
         + "Total Surface Area: 674,531.564 square units\n"
         + "Average Volume: 13,963,793.599 cubic units\n"
         + "Average Surface Area: 224,843.855 square units";
      Assert.assertEquals(true, 
         e.summaryInfo().contains("Average Surface Area"));
   }
   
  /** A test that checks to see if the list is returned correctly.**/
   @Test public void getListTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid 1", test, 3);
      Assert.assertEquals(test, e.getList());
   }
   
   /** Tests readFile method.
   *@throws FileNotFoundException 
   if the file cannot be opened.
   **/
   @Test public void readFileTest() throws FileNotFoundException {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid 1", test, 3);
      EllipsoidList2 e1 = new EllipsoidList2("Ellipsoid 2", test, 3);
      e = e.readFile("Ellipsoid_data_1.txt");
      e1 = e.readFile("Ellipsoid_data_1.txt");
      Assert.assertEquals(true, e.getName().contains(e1.getName()));
   }
   
   /** A test that checks the add ellipsoid method.**/
   @Test public void addEllipsoidTest() {
      Ellipsoid[] test = new Ellipsoid[4];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      
      Ellipsoid e4 = new Ellipsoid("Test Example", 1, 1, 1);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid 1", test, 3);
      
      e.addEllipsoid("Test Example", 1, 1, 1);
      Assert.assertEquals(e4, test[3]);
   }
      
  /** A test that checks the delete Ellipsoid method.**/
   @Test public void deleteEllipsoidTest() {
      Ellipsoid[] test = new Ellipsoid[4];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid 1", test, 3);
      e.deleteEllipsoid("Ex 3");
      Assert.assertEquals(false, e.toString().contains("Ex 3"));
   }
   
   /** A test that checks the find ellipsoid method.**/
   @Test public void findEllipsoidTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid 1", test, 3);
      Ellipsoid random = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      
      Assert.assertEquals(random, e.findEllipsoid("Ex 1"));
      Assert.assertEquals(null, e.findEllipsoid("anything"));
   }
   
   /** A test that checks the edit ellipsoid method.**/
   @Test public void editEllipsoidTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid 1", test, 3);
      
      e.editEllipsoid("Ex 1", 10, 10, 10);
      Assert.assertEquals(true, 
         e.toString().contains("4,188.7902 cubic units"));
      Assert.assertEquals(false, e.toString().contains("ant"));
   }
     
     /** A test that ensures smallest volume.**/
   @Test public void findEllipsoidWithSmallestVolumeTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
     
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid 1", test, 3);
      Ellipsoid random = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      
      Assert.assertEquals(random, e.findEllipsoidWithSmallestVolume());
   }

   /** A test that ensure largest volume.**/
   @Test public void findEllipsoidWithLargestVolumeTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
     
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid 1", test, 3);
      Ellipsoid random = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      
      Assert.assertEquals(random, e.findEllipsoidWithLargestVolume());
   }
   
   /** A test ensuring smallest surface area.**/
   @Test public void findEllipsoidWithSmallestSurfaceAreaTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
     
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid 1", test, 3);
      Ellipsoid random = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      
      Assert.assertEquals(random, e.findEllipsoidWithSmallestSurfaceArea());
   }
   
   /** A test ensuring largest surface area.**/
   @Test public void findEllipsoidWithLargestSurfaceAreaTest() {
      Ellipsoid[] test = new Ellipsoid[3];
      test[0] = new Ellipsoid("Ex 1", 1.0, 2.0, 3.0);
      test[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      test[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
     
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid 1", test, 3);
      Ellipsoid random = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      
      Assert.assertEquals(random, e.findEllipsoidWithLargestSurfaceArea());
   }
}