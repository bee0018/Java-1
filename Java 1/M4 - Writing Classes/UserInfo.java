/**
*Creating descriptions of user info.
*Activity 04 
*@ Bryce Ellis- COMP-1210-001
*@ 2-02-2020
*/

// instance variables
public class UserInfo { 
  
   /** 
   *String for user's first name.
   */
   
   private String firstName;
   
   /** 
   *String for user's last name.
   */
   
   private String lastName;

   /**
   *String for user's location.
   */
   
   private String location;
   
   /**
   *Integer for user's age.
   */
   
   private int age;
   
   /**
   *Shows offline or online.
   */
   
   private int status;
  
    /**
    *Online or offline status.
    */
    
   private static final int OFFLINE = 0, ONLINE = 1;
   
    /**
    *@param firstNameIn for UserInfo.
    *@param lastNameIn for UserInfo 
    */
    
   public UserInfo(String firstNameIn, String lastNameIn) {
      firstName = firstNameIn;
      lastName = lastNameIn;
      location = "Not specified";
      age = 0;
      status = OFFLINE;
   }
    
    /**
    *No parameters used.
    *@return user description
    */
    //constructor
   public String toString() {
      String output = "Name: " + firstName + " " 
         + lastName + "\n";
      output += "Location: " + location + "\n";
      output += "Age: " + age + "\n";
      output += "Status: ";
      if (status == OFFLINE) {
         output += "Offline";
      }
      
      else {
         output += "Online";
      }
       
      return output; 
   }
    
    /**
    *@param locationIn for user info
    *No return output
    */
    
   public void setLocation(String locationIn) {
      location = locationIn;
   }
   
   /**
   *@param ageIn for user info.
   *Describes user age
   *@return age output
   */
    
   public boolean setAge(int ageIn) {
      boolean isSet = false;
      if (ageIn > 0) {
         age = ageIn;
         isSet = true;
      }
   
      return isSet;
   }
   
   /**
   *No parameters used.
   *@return age
   */
   
   public int getAge() {
      return age;
   }
   
   /**
   *No parameters used.
   *@return location
   */
   
   public String getLocation() {
      return location;
   }
   
   /**
   *No parameters used.
   *Shows offline status
   */
   
   public void logOff() {
      status = OFFLINE;
   }
   
   /**
   *No parameters used.
   *Shows online status
   */
   
   public void logOn() {
      status = ONLINE;
   }
   
}







