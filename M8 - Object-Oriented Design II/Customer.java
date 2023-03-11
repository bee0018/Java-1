/**
*Getting practice with interfaces and OO programming.
*Activity 8B 
*@ Bryce Ellis- COMP-1210-001
*@ 3-22-2020
*/

public class Customer implements Comparable<Customer> {

   private String name;
   private String location;
   private double balance;

 /**
 *Constructor that takes in parameters.
 *@param nameIn for customer
 **/
 
   public Customer(String nameIn) {
      name = nameIn;
      location = "";
      balance = 0;
   }
   
   /**
   *Sets location for the customer.
   *@param locationIn used
   **/
   
   public void setLocation(String locationIn) {
      location = locationIn;
   }
   
   /**
   *Sets location for the customer.
   *@param city used
   *@param state used
   **/
   public void setLocation(String city, String state) {
      location = city + ", " + state;
   }

   
   /**
   *Changes balance for the customer.
   *@param amount used
   **/
   
   public void changeBalance(double amount) {
      balance += amount;
   }
   
   /**
   *Get location for the customer.
   *@return location for town
   **/
   public String getLocation() {
      return location;
   }
   
   /**
   *Gets balance for the customer.
   *@return balance for user balance
   **/
   
   public double getBalance() {
      return balance;
   }
   
   /**
   *Sets summary for the customer.
   *@return name along with other attributes
   **/
   
   public String toString() {
      return name + "\n" + location + "\n$" + balance;
   }


   /**
   *Sets up compareTo for the customer.
   *@param obj used
   *@return 0, -1, and 1 for all instances
   **/
   public int compareTo(Customer obj) {
   
      if (Math.abs(this.balance - obj.getBalance()) < 0.000001) {
         return 0;
      }
      else if (this.balance < obj.getBalance()) {
         return -1;
      }
         
      else {
         return 1;
      }
   }
         


   

}