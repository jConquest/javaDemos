package charactercount;
import java.util.Scanner;
/**
 * @author JOSEPH CONQUEST
 */
public class CharacterCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       //DEMONSTRATION
       System.out.println("Demonstration with \"Bennie and the Jets\"");
       ArrayCharacters("Bennie and the Jets");
       
      //PROMT USER FOR INPUT OF STRING 
        System.out.println("Enter a String.");
        Scanner keyboard = new Scanner(System.in); //scanner object created
        String input = keyboard.nextLine();//scanner makes string input next line
     //PRINT THE STRING ENTERED TO USER   
        System.out.printf("You entered the following String: %s\n", input);
     //CAll METHOD TO COUNT OCCURANCES OF ACSII CHARACTERS   
        ArrayCharacters(input);   
    }
    /**
     * METHOD TAKES STRING AS ARGUMENT AND PRINTS ALL THE ASCII CHARACTERS PRESENT 
     * IN STRING AS WELL AS THE NUMBER OF OCCURANCES
     * @param in IS STRING PASSED TO METHOD
     * short[] charArray hold occurances of ASCII char
     * char currentChar holds the char being analyzed within the string
     * short currentShort holds the short value represented by the char ex 'A'=65
     * int stringLength holds the length of string for the for loop going throw all
     * chars of the string
     */    
    public static void ArrayCharacters(String in) {
        short[] charArray = new short[127]; //ARRAY REPRESENTS ALL ASCII CHAR
        char currentChar;
        short currentShort;
        int stringLength = in.length();
        //Analyze content of String marking occurances
        for(int i = 0; i < stringLength; i++) {
          currentChar = in.charAt(i);
          currentShort = (short)currentChar;
          charArray[currentShort]++;
        }
        //Print all ASCII char and occurances if they occured at least once
        for(int i = 0; i < charArray.length; i++) {
            if(charArray[i]>0) {
                System.out.print("\'" + (char) i + "\'   occured " + 
                     charArray[i] + " Time");
                if( charArray[i] > 1 ) System.out.print("s");
                System.out.println();
            }
        }
    }  
}
