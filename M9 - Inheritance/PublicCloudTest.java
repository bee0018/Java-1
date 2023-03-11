import org.junit.Assert;
import org.junit.Test;

/**
*Practice inheritance our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

/**Class file to make sure all methods works properly.*/
public class PublicCloudTest {

   /**Method testing if the cost factor method returns properly.*/
   @Test public void getCostFactorTest() {
      PublicCloud c4 = new PublicCloud("Cloud Four", 9.0, 25.0, 20.0);
      Assert.assertEquals(2.0, c4.getCostFactor(), .00001);
   }

   /**Method testing to see if the monthly cost method works properly.*/
   @Test public void monthlyCostTest() {
      PublicCloud c4 = new PublicCloud("Cloud Four", 9.0, 25.0, 20.0);
      Assert.assertEquals(19.0, c4.monthlyCost(), .00001);
   }
}
