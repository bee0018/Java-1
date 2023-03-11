import javax.swing.JOptionPane;

/**
*Practice exceptions in our classes.
*Activity 11
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

public class DivisionDriver {

/**
*Driver of the division program.
*@param args - command line arguments not used
*/
   public static void main(String[] args) {
   
      String numInput = JOptionPane.showInputDialog("Enter the numerator:");
      String denomInput = JOptionPane.showInputDialog("Enter the denominator:");
      try {
         int num = Integer.parseInt(numInput);
         int denom = Integer.parseInt(denomInput);
         String result = "Integer division: \n"
            + Division.intDivide(num, denom)
            + "\n\nFloating point division: \n" 
            + Division.decimalDivide(num, denom);
         JOptionPane.showMessageDialog(null,
            result, "Result", JOptionPane.PLAIN_MESSAGE);
      }
      catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(null,
            "Invalid input: enter numerical integer values only.",
            "Error", JOptionPane.ERROR_MESSAGE);
      }
      
      catch (IllegalArgumentException e) {
         JOptionPane.showMessageDialog(null, e,
            "Error", JOptionPane.ERROR_MESSAGE);
      }
   }


}