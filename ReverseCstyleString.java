package reversecstylestring;
import java.util.Scanner;
/**
 * @author JOSEPH CONQUEST
 * This object after compilation will allow a user to enter a string into 
 * command prompt. The string is then converted to a char array, reversed, and 
 * printed to the command prompt
 * Note: String input is limited to 100 characters
 */
public class ReverseCstyleString {

    /**
     * @param args the command line arguments are not used
     */
    public static void main(String[] args) {
        char[] beforeR = new char[100];
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        if(input.length() < 100){
            int i;
            for(i = 0; i < input.length(); i++){
                beforeR[i] = input.charAt(i);
            }
            beforeR[i] = '\0';
            System.out.print("input was : ");
            int j = 0;
            while(beforeR[j] != '\0'){
                System.out.print(beforeR[j]);
                j++;
            }
            reverse(beforeR);
            System.out.print("\nString after reversal: ");
            j = 0;
            while(beforeR[j] != '\0'){
                System.out.print(beforeR[j]);
                j++;
            }
        }
        else System.out.println("Error: This class can only take String input"
                + "of 100 character length or less");
    }
    /*
    * The reverse method takes a char[] named str as a parameter and reverses
    * the content of str by swapping the first and last characters in the array
    * While this is O(n), it will run more efficiently then iterating through
    * the whole C-string and copying the contents in reverse. Swapping allows
    * for the theoretical O(n) to execute closer to o(n/2)
    */
    public static void reverse(char[] str){
        int start = 0;
        int end = 0;
        while(str[end] != '\0') end++;
        end--;
        while(start < end){
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }  
    }
}
