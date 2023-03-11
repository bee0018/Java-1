import java.util.Arrays;
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.io.File;  
import java.util.NoSuchElementException;

/** 
*Practice polymorphism in our classes.
*Project 09
*@ Bryce Ellis- COMP-1210-001
*@ 4-1-2020
*/

public class CloudStorageList {

   private CloudStorage[] cloudobjects;
   private String [] invalid;
   
   /**Instantiates the arrays of the files.*/
   public CloudStorageList() {
      cloudobjects = new CloudStorage[0];
      invalid = new String[0];
   }
   
   /**
   *@return cloudobjects for the array.
   */
   public CloudStorage[] getCloudStorageArray() {
      return cloudobjects;
   }
   
   /**
   *@return invalid for the invalid arrays.
   */
   public String[] getInvalidRecordsArray() {
      return invalid;
   }
   
   /**
   *Adds the cloud storage in places of the array.
   *@param obj for the new added cloud storage object
   */
   public void addCloudStorage(CloudStorage obj) {
      cloudobjects = Arrays.copyOf(cloudobjects, cloudobjects.length + 1);
      cloudobjects[cloudobjects.length - 1] = obj;
   }
   
   /**
   *Adds the invalid storage in places of the array.
   *@param element for the invalid info
   */
   public void addInvalidRecord(String element) {
      invalid = Arrays.copyOf(invalid, invalid.length + 1);
      invalid[invalid.length - 1] = element;
   }
   
   /**
   *Reads the test file that is given.
   *@param fileNameIn for the file that is read in
   *@throws FileNotFoundException for this file
   */
   public void readFile(String fileNameIn)
       throws FileNotFoundException {
      
      Scanner scanFile = new Scanner(new File(fileNameIn));
      
      
      while (scanFile.hasNext()) {
      
         String c = scanFile.nextLine();
         try {
            Scanner scanFile2 = new Scanner(c);
            scanFile2.useDelimiter(",");
            String name = scanFile2.next(); 
            char category = name.toUpperCase().charAt(0);
            String cloudNumber = scanFile2.next();
            double basestoragecost = Double.parseDouble(scanFile2.next()); 
            double servercost = Double.parseDouble(scanFile2.next()); 
         
         
            switch (category) {
               case 'D' :
                  CloudStorage dedicated = new DedicatedCloud(
                     cloudNumber, basestoragecost, servercost);
                  addCloudStorage(dedicated);
                  break;
               
               case 'S' :
                  double datastored = Double.parseDouble(scanFile2.next());
                  CloudStorage sharedcloud = new SharedCloud(
                     cloudNumber, basestoragecost, servercost, datastored);
                  addCloudStorage(sharedcloud);
                  break;
               
               case 'C' :
                  double test = Double.parseDouble(scanFile2.next());
                  CloudStorage pub = new PublicCloud(
                     cloudNumber, basestoragecost, servercost, test);
                  addCloudStorage(pub);
                  break;
               
               case 'Z' :
                  throw new InvalidCategoryException(name);
               
               case 'P' :
                  double personaltest = Double.parseDouble(scanFile2.next());
                  CloudStorage personal = new PersonalCloud(
                     cloudNumber, basestoragecost, servercost, personaltest);
                  addCloudStorage(personal);
                  break;
               
               default :
                  addInvalidRecord(c);
                  continue;
            }
         }
         
         catch (InvalidCategoryException e) {
            addInvalidRecord(c + "\n" + e);
         
         }
         
         catch (NumberFormatException e2) {
            addInvalidRecord(c + "\n" + e2);
         }
         
         catch (NoSuchElementException e3) {
            addInvalidRecord(c + "\n" + e3 + ": For missing input data");
         }
      }
   }
   
   /**
   *Gives the general report.
   *@return header + output for the final report
   */
   public String generateReport() {
      String header = "-------------------------------\n" 
         + "Monthly Cloud Storage Report\n" 
         + "-------------------------------\n";
      String output = "";
      int i = 0;
      while (i < cloudobjects.length) {
         output += "\n" + cloudobjects[i] + "\n";
         i++;
      }
      return header + output;
   }
   
   /**
   *Gives the report sorted by name.
   *@return header + output for the report
   */
   public String generateReportByName() {
      String header = "----------------------------------------- \n" 
         + "Monthly Cloud Storage Report (by Name)\n" 
         + "----------------------------------------- \n";
      String output = "";
      Arrays.sort(cloudobjects);
      int i = 0;
      while (i < cloudobjects.length) {
         output += cloudobjects[i] + "\n\n";
         i++;
      }
         
      return header + output; 
   }
   
   /**
   *@return header + output for the report sorted by monthly cost.
   */
   public String generateReportByMonthlyCost() {
      String header = "-------------------------------------------------\n" 
         + "Monthly Cloud Storage Report (by Monthly Cost)\n" 
         + "-------------------------------------------------\n";
      String output = "";
      Arrays.sort(getCloudStorageArray(), new MonthlyCostComparator());
      int i = 0;
      while (i < cloudobjects.length) {
         output += cloudobjects[i] + "\n" + "\n";
         i++;
      }
         
      return header + output;
   }
   
   /**
   *@return header + output for the invalid report.
   */
   
   public String generateInvalidRecordsReport() {
      String header = "----------------------\n" 
         + "Invalid Records Report\n" 
         + "----------------------\n";
      String output = "";
      int i = 0;
      while (i < invalid.length) {
         output += invalid[i] + "\n" + "\n";
         i++;
      }
      
      return header + output;
   }
}