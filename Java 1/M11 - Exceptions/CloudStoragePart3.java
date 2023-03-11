import java.util.Scanner;
import java.io.FileNotFoundException;

/** 
*Practice making exceptions in our classes.
*Project 11
*@ Bryce Ellis- COMP-1210-001
*@ 4-16-2020
*/

public class CloudStoragePart3 {

   /**
   *@param args -command lines used.
   *@throws FileNotFoundException for the file
   *Prints the report for the file
   */

   public static void main(String[] args) {
   
      CloudStorageList cloudlist2 = new CloudStorageList();
      //Scanner scan2 = new Scanner(System.in);
             
      if (args.length == 0) {
         System.out.println("File name expected as command line argument.\n" 
            + "Program ending.");
         return;
      }
      
      else {
         try {
            cloudlist2.readFile(args[0]);               
         }
         catch (FileNotFoundException exception) {
            System.out.println("\n*** Attempted to read file: " 
               + args[0] + " (No such file or directory)");
            return;
         }
      
      
      //Prints the initial summary
         System.out.println(cloudlist2.generateReport());
      
      //Prints summary by name
         System.out.print(cloudlist2.generateReportByName());
      
      //Prints summary by monthly cost
         System.out.print(cloudlist2.generateReportByMonthlyCost());
      
      //Prints invalid summary report
         System.out.println(cloudlist2.generateInvalidRecordsReport());
      
      }
   }
}