/**
*Practice inheritance our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

public class CloudStoragesPart1 {
   
   /**
   *Prints of the details of the following clouds.
   *@param args not used
   */
   public static void main(String[] args) {
   
      DedicatedCloud c1 = new DedicatedCloud("Cloud One", 40.00, 10.00);
      System.out.println(c1);
      System.out.println("\n");
   
   
      SharedCloud c2 = new SharedCloud("Cloud Two", 9.0, 12.0, 20.0);
      System.out.println(c2);
      System.out.println("\n");
   
      SharedCloud c3 = new SharedCloud("Cloud Three", 9.0, 25.0, 20.0);
      System.out.println(c3);
      System.out.println("\n");
   
   
      PublicCloud c4 = new PublicCloud("Cloud Four", 9.0, 25.0, 20.0);
      System.out.println(c4);
      System.out.println("\n");
   
   
      PersonalCloud c5 = new PersonalCloud("Cloud Five", 9.0, 21.0, 20.0);
      System.out.println(c5);
   }
}