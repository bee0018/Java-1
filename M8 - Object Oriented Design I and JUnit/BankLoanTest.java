import org.junit.Assert;
import org.junit.Test;

/**
*Practice testing the method for our object.
*Activity 08
*@ Bryce Ellis- COMP-1210-001
*@ 3-16-2020
*/

public class BankLoanTest {

   /**
   *Tests to see if the chargeInterestTest method
   *works and passes with no defects.
   */
   
   @Test public void chargeInterestTest() {
      BankLoan loan1 = new BankLoan("Jane", .10);
      loan1.borrowFromBank(1000.00);
      loan1.chargeInterest();
      Assert.assertEquals(" ", 1100, loan1.getBalance(), .000001);
   }


   
}
