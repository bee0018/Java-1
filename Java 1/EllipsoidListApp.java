import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
*Creating two instances of the same variable.
*Project 05 
*@ Bryce Ellis- COMP-1210-001
*@ 2-09-2020
*/

public class EllipsoidListApp {


 /**
 * Reads file with Ellipsoid, creates EllipsoidList, prints EllipsoidList.
 * prints summary of EllipsoidList
 * @param args - is not used
 * @throws FileNotFoundException required by Scanner for File
 */
 
   public static void main(String[] args) throws FileNotFoundException {
      ArrayList<Ellipsoid> elist = new ArrayList<Ellipsoid>();
   
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      Scanner scanFile = new Scanner(new File(fileName));
      String listnames = scanFile.nextLine();
   
      while (scanFile.hasNext()) {
         String label = scanFile.nextLine();
         double a = Double.parseDouble(scanFile.nextLine());
         double b = Double.parseDouble(scanFile.nextLine());
         double c = Double.parseDouble(scanFile.nextLine());
         Ellipsoid el = new Ellipsoid(label, a, b, c);
         elist.add(el);
      }
      
      scanFile.close();
      
      EllipsoidList ellip = new EllipsoidList(listnames, elist);
      
      System.out.println("\n" + ellip.toString());
      System.out.println(ellip.summaryInfo());
   
   
   
   
   
   
   
   }

}