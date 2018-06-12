/**
 * @author JOSEPH CONQUEST
 * Last Updated : 6/11/2018 12:16 pm
 * Purpose: The follow java program provides an example of Input validation 
 *   for the integer and double data types with input origin coming from a
 *   Scanner keyboard object
 */
package inputvalidationmethods;
import java.util.Scanner; // for importing input from keyboard

public class InputValidationMethods {
    /**
     * @param args the command line arguments are not used
     */
    public static void main(String[] args) {
      //call method with string as argument
      int a = validateInt("Please enter an integer"); 
      //call method with string as argument
      double b = validateDouble("Please enter a real number");    
        
      //print results returned from methods called 
      System.out.printf("\nThe Integer you Entered is %d", a);
      System.out.printf("\nThe Real Number you Entered is %f\n", b);   
    }
    
    /**
     * INTEGER VALIDATOIN METHOD
     * @param prompt IS STRING FOR OUTPUT TO PROMPT USER FOR INPUT
     * @return strConvert INTEGER CONVERTED FROM STRING INPUT
     * CATCHES EXCEPTIONS AND REPEATEDLY PROMPTS USER FOR VALID INTEGER INPUT
     *   UNTIL VALID INPUT HAS BEEN PROVIDED
     */
    public static int validateInt(String prompt) {
      Scanner keyboard = new Scanner(System.in); //set up input from keyboard
      int strConvert = 0; //converted string holder
      boolean go; //do while loop control
        
      do {
        System.out.println(prompt); //prompt user for integer
        //set integer string to promptInt var
        String promptedIn = keyboard.nextLine(); 
        
        try { //possible exception if user does not enter a integer
          //test if string is integer
          strConvert = Integer.parseInt(promptedIn);
          //print tested value
          System.out.printf("The entered integer is : %d\n", strConvert);
          go = false; //end loop, user has entered correct data type
        }
        catch (IllegalArgumentException e) {
          //TELL USER OF INPUT ERROR
          System.out.println("INPUT ERROR: Please enter an integer");
          System.out.println(e.getMessage()); //print exception to user
          go = true; //prompt user for integer again
        }   
      } while( go );
      return strConvert;
    }
    
    /**
     * REAL NUMBER VALIDATOIN METHOD
     * @param prompt IS STRING FOR OUTPUT TO PROMPT USER FOR INPUT
     * @return DOUBLE OF CONVERTED STRING
     * CATCHES EXCEPTIONS AND REPEATEDLY PROMPTS USER FOR VALID DOUBLE INPUT
     */
    public static double validateDouble(String prompt) {
      Scanner keyboard = new Scanner(System.in); //get input from keyboard
      double strConvert = 0;  //converted string holder
      boolean go; //do while loop control
        
      do {
        //prompt user for a real number
        System.out.println(prompt); 
         //save real string to promptDouble var
        String promptDouble = keyboard.nextLine();
        
        try { //possible exception if user does not enter a real number
          //validate that entry is a real number
          strConvert = Double.parseDouble(promptDouble); 
          //print returned value b
          System.out.printf("\nThe entered real number is : %f\n", strConvert);
          go = false; //end loop, user has entered correct data type
        }
        catch (IllegalArgumentException e) {
          //TELL USER OF INPUT ERROR
          System.out.println("INPUT ERROR: Please enter a real number"); 
          System.out.println(e.getMessage()); //print exception to user
          go = true; //cause the loop to prompt user for real number again
        }
      } while( go );
      return strConvert;
    }
}
