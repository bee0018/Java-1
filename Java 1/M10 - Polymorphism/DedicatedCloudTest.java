import org.junit.Assert;
import org.junit.Test;

/**
*Practice inheritance our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

/**Test file making sure that all methods function properly.*/
public class DedicatedCloudTest {

   /**Tests to see if the server cost is returned correctly.*/
   @Test public void getServerCostTest() {
      DedicatedCloud c1 = new DedicatedCloud("Cloud One", 40.00, 10.00);
      Assert.assertEquals(10.0, c1.getServerCost(), .00001);
   }
   
   /**Method testing to if server cost is set correctly.*/
   @Test public void setServerCostTest() {
      DedicatedCloud c1 = new DedicatedCloud("Cloud One", 40.00, 10.00);
      c1.setServerCost(100.0);
      Assert.assertEquals(100.0, c1.getServerCost(), .00001);
   }
   
   /**Method testing if the monthly cost method functions properly.*/
   @Test public void monthlyCostTest() {
      DedicatedCloud c1 = new DedicatedCloud("Cloud One", 40.00, 10.00);
      Assert.assertEquals(50.0, c1.monthlyCost(), .00001);
   }
   
   /**Method testing if the toString method works properly.*/
   @Test public void toStringTest() {
      DedicatedCloud c1 = new DedicatedCloud("Cloud One", 40.00, 10.00);
      Assert.assertEquals(true, c1.toString().contains("Cloud One"));
   }
}

