
package inputvalidationmethods;
import java.util.Scanner;

/**
 *
 * @author JOSEPH CONQUEST
 */
public class InputValidationMethods {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        int a = validateInt("Please enter an integer"); //call method with string as argument
        double b = validateDouble("Please enter a real number");//call method with string as argument
        
       
        
       //print results returned from methods called 
       System.out.printf("\nThe Integer you Entered is %d", a);
       System.out.printf("\nThe Real Number you Entered is %f\n", b);
        
    }
    
    /**
     * INTEGER VALIDATOIN METHOD
     * @param prompt IS STRING INPUT FROM USER
     * @return INTEGER OF CONVERTED STRING
     * CATCHES EXCEPTIONS AND REPEATEDLY PROMPTS USER FOR VALID INTEGER INPUT
     */
    public static int validateInt(String prompt) 
    {
        
      
        Scanner keyboard = new Scanner(System.in); //get input from keyboard
        int n = 0; //converted string holder
        boolean go; //do while loop control
        
        do
        {
         System.out.println(prompt); //prompt user for integer
        String promptInt = keyboard.nextLine(); //save integer string to promptInt var
        
        
        
        try
            {
                n = Integer.parseInt(promptInt); //test if string is integer
                System.out.printf("The entered integer is : %d\n", n); //print returned value a
                go = false; //end loop, user has entered correct data type
            }
        catch (IllegalArgumentException e)
            {
                System.out.println("INPUT ERROR!!!"); //TELL USER OF INPUT ERROR
                System.out.println(e.getMessage()); //print exception to user
                go = true; //prompt user for integer again
                
            }
        
       
        } while (go);
        return n;
        
    }
    
    /**
     * REAL NUMBER VALIDATOIN METHOD
     * @param prompt IS STRING INPUT FROM USER
     * @return DOUBLE OF CONVERTED STRING
     * CATCHES EXCEPTIONS AND REPEATEDLY PROMPTS USER FOR VALID DOUBLE INPUT
     */
    
    public static double validateDouble(String prompt)
    {
       // For you to complete
        Scanner keyboard = new Scanner(System.in); //get input from keyboard
        double n = 0;  //converted string holder
        boolean go; //do while loop control
        
        do
        {
            System.out.println(prompt); //prompt user for a real number
            String promptDouble = keyboard.nextLine(); //save real string to promptDouble var


            try //possible exception if user does not enter a real number
                {
                   n = Double.parseDouble(promptDouble); //validate that entry is a real number 
                    System.out.printf("\nThe entered real number is : %f\n", n); //print returned value b
                    go = false; //end loop, user has entered correct data type
                }
            catch (IllegalArgumentException e)
                {
                    System.out.println("INPUT ERROR!!!"); //TELL USER OF INPUT ERROR
                    System.out.println(e.getMessage()); //print exception to user
                    go = true; //cause the loop to prompt user for real number again

                }

            
        } while (go);
        return n;
    }
}
