/**
*Creating two instances of the same variable.
*Activity 04 
*@ Bryce Ellis- COMP-1210-001
*@ 2-02-2020
*/

public class UserInfoDriver {

    /** 
    *@param args Command line not used.
    *Prints user1 information
    */
     
   public static void main(String[] args) {
      
      UserInfo user1 = new UserInfo("Pat", "Doe");
      System.out.println("\n" + user1);
      user1.setLocation("Auburn");
      user1.setAge(19);
      user1.logOn();
      System.out.println("\n" + user1);
      
      /**
      *@param args Command line not used.
      *Prints user2 information
      */
      
      UserInfo user2 = new UserInfo("Sam", "Jones");
      System.out.println("\n" + user2);
      user2.setLocation("Atlanta");
      user2.setAge(21);
      user2.logOn();
      System.out.println("\n" + user2);
      
      
      
      
   }



}