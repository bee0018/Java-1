import org.junit.Assert;
import org.junit.Test;

/**
*Practice inheritance our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

/**Class files testing if the methods work properly.*/
public class PersonalCloudTest {

/**Method testing to see if the cost factor returns properly.*/
   @Test public void getCostFactorTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.0, 21.0, 20.0);
      Assert.assertEquals(3.0, c5.getCostFactor(), .00001);
   }
   
   /**Method testing to see if the monthly cost is returned properly.*/
   @Test public void monthlyCostTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.0, 21.0, 20.0);
      Assert.assertEquals(12.0, c5.monthlyCost(), .00001);
   }
   
   /**Method testing to see if name is assigned correctly.*/
   @Test public void getNameTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.0, 21.0, 20.0);
      Assert.assertEquals("Cloud Five", c5.getName());
   }
   
   /**Method testing to see if name is set properly.*/
   @Test public void setNameTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.0, 21.0, 20.0);
      c5.setName("test");
      Assert.assertEquals("test", c5.getName());
   }
   
   /**Method testing to see if storage cost is returned correctly.*/
   @Test public void getBaseStorageCostTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.0, 21.0, 20.0);
      Assert.assertEquals(9.0, c5.getBaseStorageCost(), .00001);
   }
   
   /**Method testing to see if storage cost is set correctly.*/
   @Test public void setBaseStorageCostTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.0, 21.0, 20.0);
      c5.setBaseStorageCost(100);
      Assert.assertEquals(100, c5.getBaseStorageCost(), .00001);
   }
   
   /**Method testing to see if count is returned correctly.*/
   @Test public void getCountTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.0, 21.0, 20.0);
      c5.resetCount();
      PersonalCloud c6 = new PersonalCloud("Cloud Six", 11.0, 29.0, 293.0);
      Assert.assertEquals(1.0, c6.getCount(), .00001);
   }
   
   /**Method testing to see if count is reset correctly to zero.*/
   @Test public void resetCountTest() {
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.0, 21.0, 20.0);
      c5.resetCount();
      Assert.assertEquals(0, c5.getCount(), .00001);
   }
}
