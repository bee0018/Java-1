import org.junit.Assert;
import org.junit.Test;

/**
*Practice inheritance our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/
public class CloudStorageTest {

/**Method testing to see if get name method would work.*/
   @Test public void getNameTest() {
      CloudStorage cloud = new CloudStorage("cloud", 20.0);
      Assert.assertEquals("cloud", cloud.getName());
   }
  
}
