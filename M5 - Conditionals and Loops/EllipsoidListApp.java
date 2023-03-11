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
 * Reads file with Ellipsoid, creates EllipsoidList, prints EllipsoidList,
 * prints summary of EllipsoidList
 * @param args - is not used
 * @throws FileNotFoundException required by Scanner for File
 */
 
   public static void main(String[] args) throws FileNotFoundException {
      ArrayList<Ellipsoid> elist = new ArrayList<Ellipsoid>();
   
      Scanner filename = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String name = filename.nextLine();
   
      Scanner scan = new Scanner(new File(filename));
      String listnames = scan.nextLine();
   
      while (scan.hasNext()) {
         String label = scan.nextLine();
         double a = scan.nextDouble();
         double b = scan.nextDouble();
         double c = scan.nextDouble();
         Ellipsoid el = new Ellipsoid(label, a, b, c);
         elist.add(el);
      }
      
      scan.close();
      
      EllipsoidList result = new EllipsoidList(listnames, elist);
      
      System.out.println(result);
      System.out.println(result.summaryInfo());
   
   
   
   
   
   
   
   }














}