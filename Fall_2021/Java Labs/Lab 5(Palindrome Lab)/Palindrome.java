/**
 * Input a string and check to see fi it is a palindrome
 * only compares letters, ignores everything else
 * 
 * Enter ur strng
 * ""
 * The string is/isn't a Palindorme
 */

 import java.util.Scanner;

public class Palindrome {
    
    public static void main(String[]args){
        
    Scanner input = new Scanner(System.in);
    int numberOfInputs = 20;//arbitrary number, find better solution

    ArrayStack<String> userInput = new ArrayStack<String>(numberOfInputs);

    while(!(userInput.peek().equals("E"))){
        userInput.push(input.nextLine()); //assign user's string to the stack after they input

        
    }
  //userInput.push(input.nextLine()); //assign user's string to the stack after they input


    }

    /**
     * 
     * @param s String
     * @return return T/F if the string is the same when reversed
     */
    private static boolean isPalindrome(String s){

        String simplified = simplifyString(s);
        String[] strArray = stringToArray(s);

        if(
    }

    /**
     * 
     * @param s String
     * @return new string that is a copy with no punctuation or unwanted symbols
     */
    private static String simplifyString(String s){

        //used to replace punctuation and offending characters
        String replace = "";
        
        //new string to be returned
        String returnMe = "";

        for(int i = 0; i < s.length(); i++){

            replace = s.charAt(i);

            //flesh out for other punctuation
            if(s.charAt(i) == "!" && s.charAt(i) == "?" && s.charAt(i) == "."){ 

                replace = " ";
            }

            returnMe += replace;
        }
        return s; 
    }

    /**
     * 
     * @param s String
     * @return an array that holds each character in a different index
     */
    private static String[] stringToArray(String s){
        String[] sA = new String[s.length()];

        for(int i = 0; i < s.length(); i++){
            sA[i] = s.charAt(i);
        }

        return sA;
    }

}
