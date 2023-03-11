import java.util.Scanner;
import java.io.FileNotFoundException;

/** 
*Practice polymorphism within our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

public class CloudStoragePart2 {

   /**
   *@param args -command lines used.
   *@throws FileNotFoundException for the file
   *Prints the report for the file
   */
   public static void main(String[] args) throws FileNotFoundException {
      
      CloudStorageList cloudlist = new CloudStorageList();
      Scanner scan = new Scanner(System.in);
     
      if (args.length == 0) {
         System.out.println("File name expected as command line argument.\n" 
            + "Program ending.");
         return;
      }
      else {
         
         args = new String[1];
         args[0] = "cloud_storage_data_1.csv";
         
         
         cloudlist.readFile(args[0]); 
      
      //Prints the initial summary
         System.out.println(cloudlist.generateReport());
      
      //Prints summary by name
         System.out.println(cloudlist.generateReportByName());
      
      //Prints summary by monthly cost
         System.out.println(cloudlist.generateReportByMonthlyCost());
      }
      
               
   }


}