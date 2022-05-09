/**
*Creating static variables for and referecing them.
*Activity 08
*@ Bryce Ellis- COMP-1210-001
*@ 3-16-2020
*/


public class BankLoan {
	// constant fields
   private static final int MAX_LOAN_AMOUNT = 100000;

   // instance variables (can be used within the class)
   private String customerName;
   private double balance, interestRate;
   private static int loansCreated = 0;

    /**
   *@param customerNameIn used for object.
   *@param interestRateIn used for object
   *sets variables up
   */
   
   public BankLoan(String customerNameIn, double interestRateIn) { 
      customerName = customerNameIn;
      interestRate = interestRateIn;
      balance = 0;
      loansCreated++;
   }
   
   /**
   *@param amount used for object.
   *@return wasLoanMade for final borrowed amount
   *shows borrowed amount
   */
   
   public boolean borrowFromBank(double amount) {
      
      boolean wasLoanMade = false;
      
      if (balance + amount < MAX_LOAN_AMOUNT) {
         wasLoanMade = true;
         balance += amount;
      }
   
      return wasLoanMade;
   }

   /**
   *@param amountPaid used for object.
   *@return Math.abs(newBalance)
   *shows paid amount
   */

   public double payBank(double amountPaid) {
      double newBalance = balance - amountPaid;
      if (newBalance < 0) {
         balance = 0;
         // paid too much, return the overcharge
         return Math.abs(newBalance);
      }
      else {
         balance = newBalance;
         return 0;
      }
   }
   
   /**
   *@return balance for class
   *shows balance
   */
   
   public double getBalance() {
      return balance;
   }
   
   /**
   *@param interestRateIn used for object.
   *shows interest rate
   *@return interst rate for customer
   */
   
   public boolean setInterestRate(double interestRateIn) {
   
      if (interestRateIn >= 0 && interestRateIn <= 1) {
         interestRate = interestRateIn;
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
   *@return interestRate for class.
   *shows interest rate
   */
   
   public double getInterestRate() {
      return interestRate;
   }
   
   /**
   *shows the charge interest for the customer.
   */
   
   public void chargeInterest() {
      balance = balance * (1 + interestRate);
   }
   
   /**
   *@return output for class.
   *shows client details
   */
   
   public String toString() {
      String output = "Name: " + customerName + "\r\n" 
         + "Interest rate: " + interestRate + "%\r\n" 
         + "Balance: $" + balance + "\r\n";
      return output;
   }
   
   /**
   *@param amount used for object.
   *shows validity of account
   *@return validity for client transactions
   */
   
   public static boolean isAmountValid(double amount) {
      if (amount >= 0) {
         return true;
      }
      
      return false;
   }
   
   /**
   *@param loan used for object.
   *shows loan amount  of account
   *@return debt possibility for client transactions
   */
   
   public static boolean isInDebt(BankLoan loan) {
      if (loan.getBalance() > 0) {
         return true;
      } 
         
      return false;
   }
   
   /**
   *@return loansCreated for class.
   *shows loan objects that were created by clients
   */
   
   public static int getLoansCreated() {
      return loansCreated;
   }
  
   /**
   *resets the loan back to zero.
   */
   
   public static void resetLoansCreated() {
      loansCreated = 0;
   }  

}

