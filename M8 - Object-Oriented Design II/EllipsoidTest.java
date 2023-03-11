import org.junit.Assert;
import org.junit.Test;


/**
*Practice testing the method for our object.
*Project 08
*@ Bryce Ellis- COMP-1210-001
*@ 3-16-2020
*/

public class EllipsoidTest {


   /** A test that tests for the correct label.**/
   @Test public void getLabelTest() {
      String label = "Ellipsoid 1";
      double a = 10;
      double b = 13;
      double c = 14;
      Ellipsoid e = new Ellipsoid(label, a, b, c);
      Assert.assertEquals("Ellipsoid 1", e.getLabel());
   }
   
   /** A test that makes sure the label is set.**/
   @Test public void setLabelTest() {
      String label = "Ellipsoid 1";
      double a = 12;
      double b = 13;
      double c = 14;
      Ellipsoid e = new Ellipsoid(label, a, b, c);
      Assert.assertEquals(true, e.setLabel(label));
      Assert.assertEquals(false, e.setLabel(null));
   }
   
   /** A test that tests for correct a assignment.**/
   @Test public void getATest() {
      String label = "Ellipsoid 1";
      double a = 112;
      double b = 3;
      double c = 4;
      Ellipsoid e = new Ellipsoid(label, a, b, c);
      Assert.assertEquals(a, e.getA(), 112);
   }
   
   /** A test that checks to see if a is set.**/
   @Test public void setATest() {
      String label = "Ellipsoid 1";
      double a = 22;
      double b = 13;
      double c = 4;
      Ellipsoid e = new Ellipsoid(label, a, b, c);
      Assert.assertEquals(true, e.setA(a));
      Assert.assertEquals(false, e.setA(0));
   }
   
   /** A test that makes sure b is correct.**/
   @Test public void getBTest() {
      String label = "Ellipsoid 1";
      double a = 762;
      double b = 397;
      double c = 422;
      Ellipsoid e = new Ellipsoid(label, a, b, c);
      Assert.assertEquals(b, e.getB(), 397);
   }
      
  /** A test that makes sure b is set correctly.**/
   @Test public void setBTest() {
      String label = "Ellipsoid 1";
      double a = 111;
      double b = 3111;
      double c = 8764;
      Ellipsoid e = new Ellipsoid(label, a, b, c);
      Assert.assertEquals(true, e.setB(b));
      Assert.assertEquals(false, e.setB(0));
   }
   
   /** A test that makes sure c is is correct.**/
   @Test public void getCTest() {
      String label = "Ellipsoid 1";
      double a = 254;
      double b = 39675;
      double c = 4448;
      Ellipsoid e = new Ellipsoid(label, a, b, c);
      Assert.assertEquals(c, e.getC(), 4448);
   }
   
   /** A test that makes sure c is set correctly.**/
   @Test public void setCTest() {
      String label = "Ellipsoid 1";
      double a = 32352;
      double b = 356435463;
      double c = 489656;
      Ellipsoid e = new Ellipsoid(label, a, b, c);
      Assert.assertEquals(true, e.setC(c));
      Assert.assertEquals(false, e.setC(0));
   }
   
   /** A test that makes sure volume is taken correctly.**/
   @Test public void volumeTest() {
      String label = "Ellipsoid 1";
      double a = 2;
      double b = 3;
      double c = 4;
      Ellipsoid e = new Ellipsoid(label, a, b, c);
      Assert.assertEquals(100.53096491487338, e.volume(), .000001);
   }
   
   /** A test that makes sure the surface area is taken correctly.**/
   @Test public void surfaceAreaTest() {
      String label = "Ellipsoid 1";
      double a = 2;
      double b = 3;
      double c = 4;
      Ellipsoid e = new Ellipsoid(label, a, b, c);
      Assert.assertEquals(111.5708526308508, e.surfaceArea(), .00001);
   }

   /** A test that checks to see if the toString functions properly.**/
   @Test public void toStringTest() {
      String label = "Ellipsoid 1";
      double a = 2;
      double b = 3;
      double c = 4;
      Ellipsoid e = new Ellipsoid(label, a, b, c);
      String output = ("Ellipsoid " + "\"Ellipsoid 1"
         + "\" with axes a = 2.0" + ", b = 3.0" + ", c = 4.0"
         + " units has: "
         + "\n\tvolume = " + "100.531"
          + " cubic units" + "\n\tsurface area = " 
          + "111.5709" 
          + " square units");
      Assert.assertEquals(true, e.toString().contains(output));
     
   }
   
   /** Tests to see if get count method works properly.**/
   @Test public void getCountTest() {
      String label = "Ellipsoid 1";
      double a = 6546;
      double b = 363653;
      double c = 49786655;
      Ellipsoid elip = new Ellipsoid(label, a, b, c);
      elip.resetCount();
      Ellipsoid e1 = new Ellipsoid(label, a, b, c);
      Assert.assertEquals(1, elip.getCount());
   }

   /** Tests to see if reset count method works properly.**/
   @Test public void resetCountTest() {
      String label = "Ellipsoid 1";
      double a = 254354;
      double b = 3584;
      double c = 489765986;
      Ellipsoid elip = new Ellipsoid(label, a, b, c);
      int expected = 0;
      elip.resetCount();
      Assert.assertEquals(expected, elip.getCount());
   }

   /** Tests to see if the equals method works properly.**/
   @Test public void equalsTest() {
      String label = "Ellipsoid 1";
      double a = 209809;
      double b = 9879873;
      double c = 767904;
      Ellipsoid e = new Ellipsoid(label, a, b, c);
      Ellipsoid e1 = new Ellipsoid("Ellipsoid 2", a, b, c);
      Ellipsoid e2 = new Ellipsoid(label, 8, b, c);
      Ellipsoid e3 = new Ellipsoid(label, a, 8, c);
      Ellipsoid e4 = new Ellipsoid(label, a, b, 8);
      Ellipsoid test = new Ellipsoid(label, a, b, c);
      
      Assert.assertEquals(true, e.equals(test));
      test = e;
      
      Assert.assertEquals(true, e.equals(test));
      test = e1;
      
      Assert.assertEquals(false, e.equals(test));
      test = e2;
      
      Assert.assertEquals(false, e.equals(test));
      test = e3;
      
      Assert.assertEquals(false, e.equals(test));
      test = e4;
   }
       
   /** Tests the functionality of the hashcode method.**/
   @Test public void hashCodeTest() {
      String label = "Ellipsoid 1";
      double a = 4656752;
      double b = 5457653;
      double c = 9879874;
      int expected = 0;
      Ellipsoid e = new Ellipsoid(label, a, b, c);
      e.resetCount();
      Assert.assertEquals(expected, e.hashCode());
   }

   
}
