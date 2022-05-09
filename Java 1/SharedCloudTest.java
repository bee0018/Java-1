import org.junit.Assert;
import org.junit.Test;

/**
*Practice inheritance our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

/**Test class that ensures proper method function.*/
public class SharedCloudTest {

/**Method testing to see if getDataStored method works.*/
   @Test public void getDataStoredTest() {
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.0, 12.0, 20.0);
      Assert.assertEquals(12.0, c2.getDataStored(), .00001);
   }
   
   /**Method testing to see if setDataStored method works.*/
   @Test public void setDataStoredTest() {
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.0, 12.0, 20.0);
      c2.setDataStored(3.0);
      Assert.assertEquals(3.0, c2.getDataStored(), .00001);
   }
   
   /**Method testing to see if data limit method works.*/
   @Test public void getDataLimitTest() {
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.0, 12.0, 20.0);
      Assert.assertEquals(20.0, c2.getDataLimit(), .00001);
   }
   
   /**Method testing the set data limit functionality.*/
   @Test public void setDataLimitTest() {
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.0, 12.0, 20.0);
      c2.setDataLimit(30.0);
      Assert.assertEquals(30.0, c2.getDataLimit(), .00001);
   }
   
   /**Method testing if the cost factor method works.*/
   @Test public void getCostFactorTest() {
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.0, 12.0, 20.0);
      Assert.assertEquals(1.0, c2.getCostFactor(), .00001);
   }
   
   /**Method testing to see if data overage method works.*/
   @Test public void dataOverageTest() {
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.0, 12.0, 20.0);
      Assert.assertEquals(0.000, c2.dataOverage(), .00001);
      
      SharedCloud testcloud = new SharedCloud("Cloud Two", 9.0, 12.0, 1.0);
      Assert.assertEquals(11.0, testcloud.dataOverage(), .00001);
   }
   
   /**Method testing to see if monthly cost method works.*/
   @Test public void monthlyCostTest() {
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.0, 12.0, 20.0);
      Assert.assertEquals(9.0, c2.monthlyCost(), .00001);
   }
   
   /**Method testing to see if toString method works properly.*/
   @Test public void toStringTest() {
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.0, 12.0, 20.0);
      Assert.assertEquals(true, c2.toString().contains("Cloud Two"));
   }

}
