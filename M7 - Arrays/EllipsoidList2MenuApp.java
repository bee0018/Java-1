import java.util.Scanner;
import java.io.FileNotFoundException;


/**
*Creating two instances of the same variable.
*Project 06 
*@ Bryce Ellis- COMP-1210-001
*@ 2-09-2020
*/

public class EllipsoidList2MenuApp {

 /** 
 *@param args is not used.
 *@throws FileNotFoundException if file cannot be opened
 */
 
   public static void main(String[] args) 
      throws FileNotFoundException {
   
      String error = "*** no list name assigned ***";
      Ellipsoid[] elist1 = new Ellipsoid[100];
      int numofellipsoids = 0;
      EllipsoidList2 listb = new EllipsoidList2(error, elist1, numofellipsoids);
      Scanner choice = new Scanner(System.in); 
      String fileName = "no file name";
      String label = "";
      double a = 0;
      double b = 0;
      double c = 0;
   
      String layout = "";
   
   //Provides user with the options
      System.out.print("Ellipsoid List System Menu\n"
         + "R - Read File and Create Ellipsoid List\n"
         + "P - Print Ellipsoid List\n"
         + "S - Print Summary\n"
         + "A - Add Ellipsoid\n"
         + "D - Delete Ellipsoid\n"
         + "F - Find Ellipsoid\n"
         + "E - Edit Ellipsoid\n"
         + "Q - Quit" + "\n");
   
   //Prompts user for choice
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: "); 
         layout = choice.nextLine().toUpperCase();
         if (layout.length() == 0) {
            continue;
         }
        
         layout = layout.toUpperCase();
         char letter = layout.charAt(0);
         switch(letter) {
         
         //Read in file 
            case 'R' :
               System.out.print("\tFile Name: ");
               fileName = choice.nextLine();
               listb = listb.readFile(fileName);
               System.out.println("\tFile read in " 
                  + "and Ellipsoid List created" + "\n");
               break;
         
         //Prints the Ellipsoid
            case 'P' :
               System.out.println(listb.toString());
               break;
         
         //Prints the Summary
            case 'S' :
               System.out.println(listb.summaryInfo() + "\n");
               break;
         
         //Prints Added Ellipsoids
            case 'A' :
               System.out.print("\tlabel: ");
               label = choice.nextLine();
               
               System.out.print("\ta: ");
               a = Double.parseDouble(choice.nextLine());
               
               System.out.print("\tb: ");
               b = Double.parseDouble(choice.nextLine());
              
               System.out.print("\tc: ");
               c = Double.parseDouble(choice.nextLine());
            
               listb.addEllipsoid(label, a, b, c);
               System.out.println("\t*** Ellipsoid added ***\n");
               break;
               
          
          //Deletes Ellipsoids
            case 'D' :
               System.out.print("\tlabel: ");
               label = choice.nextLine();
               
               if (listb.findEllipsoid(label) == null) {
                  System.out.println("\t\"" + label + "\" not found" + "\n");
                  break;
               }
               
               else {
                  Ellipsoid deleted = listb.deleteEllipsoid(label);
                  System.out.println("\t\"" 
                     + deleted.getLabel() + "\" deleted" + "\n");
                  break;
               }
               
            
            //Finds Ellipsoids
            case 'F' :
               System.out.print("\tlabel: ");
               label = choice.nextLine();
            
               if (listb.findEllipsoid(label) != null) {
                  System.out.println(
                     listb.findEllipsoid(label).toString() + "\n");
               }
               
               else {
                  System.out.println("\t\"" + label  + "\" not found" + "\n"); 
               }        
               break;
               
               
            //Edit Ellipsoids
            case 'E' :
               System.out.print("\tlabel: ");
               label = choice.nextLine();
               
               System.out.print("\ta: ");
               a = Double.parseDouble(choice.nextLine());
               
               System.out.print("\tb: ");
               b = Double.parseDouble(choice.nextLine());
               
               System.out.print("\tc: ");
               c = Double.parseDouble(choice.nextLine());
               
               if (listb.findEllipsoid(label) != null) {
                  
                  Ellipsoid object = listb.editEllipsoid(label, a, b, c);
                  System.out.println("\t\"" 
                     + object.getLabel() + "\" successfully edited\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
               
          //Quits Program
            case 'Q' :
               break;
                  
            default: 
               System.out.println("\t*** invalid code ***\n");
         }
         
      }
        
      while (!layout.equalsIgnoreCase("Q"));     
   }

}


