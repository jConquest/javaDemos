package stringalluniquechar;

import java.util.Scanner;
/**
 *
 * @author JOSEPH CONQUEST
 * String All Unique Char reads a String from command prompt
 * And determines if the string contains any duplicate chars
 * Printing out the result to the command prompt
 */
public class StringAllUniqueChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Test case for array analysis
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the string you want analyzed with "
                + "arrayAnalysis");
        String input = keyboard.nextLine();
        System.out.println("You enetered the following string : "+input);
        boolean duplicatesNotFound = arrayAnalysis(input);
        System.out.println("Using arrayAnalysis determined the following: ");
        if(!duplicatesNotFound) System.out.println("Duplicates were found");
        else System.out.println("Duplicates were not found"); 
        //Test case for comparative analysis
        System.out.println("Please enter the string you want analyzed with "
            + "arrayAnalysis");
        input = keyboard.nextLine();
        System.out.println("You enetered the following string : "+input);
        boolean duplicatesNotFound2 = arrayAnalysis(input);
        System.out.println("Using comparativeAnalysis determined "
                + "the following: ");
        if(!duplicatesNotFound2) System.out.println("Duplicates were found");
        else System.out.println("Duplicates were not found"); 
    }
   /*
    * Method takes in a string "in" for a parameter and anaylzes in for any
    * duplicate chars. Method uses array of int to anaylze duplication,
    *  requiring extra overhead for execution but providing O(n) to analyze
    * RETURN If a duplicate is found, the method returns false
    */ 
    public static boolean arrayAnalysis(String in){
        boolean duplicateNotFound = true;
        int[] array = new int[127];
        for(int j = 0; j < in.length(); j ++){ //for each char in string
            char current = in.charAt(j);
            array[current]++;//
            if ( array[current] > 1){
                duplicateNotFound = false;
                break;
            }
        }        
        return duplicateNotFound;
    }
     /*
    * Method takes in a string "in" for a parameter and anaylzes in for any
    * duplicate chars. Method compares each char to every other char of in,
    *  requiring O(n^2) to analyze, but not requiring data structure overhead
    * RETURN If a duplicate is found, the method returns false
    */    
    public static boolean comparativeAnalysis(String in){
        boolean duplicateNotFound = true;
        for (int i = 0; i < in.length(); i++){ //for each char in string
            char current = in.charAt(i);
            //check all other chars for duplicates
            for(int j = 0; j < in.length(); j++){ 
               if(j != i){ //do not compare current to itself
                   char compare = in.charAt(j);
                   if (compare == current) return false;
               } 
            }
        }
        return duplicateNotFound;
    }
    
}
