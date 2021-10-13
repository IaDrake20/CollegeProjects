/**
 * Input a string and check to see fi it is a palindrome
 * only compares letters, ignores everything else
 * 
 * Enter ur strng
 * ""
 * The string is/isn't a Palindorme
 */

 import java.util.*;

public class Palindrome {
    
    public static void main(String[]args){
        
    Scanner input = new Scanner(System.in);
    int numberOfInputs = 20;//arbitrary number, find better solution

    String userInput = "";

    ArrayStack<Character> characters = new ArrayStack<Character>(numberOfInputs);

    do {
        
        //characters.push(input.next); //assign user's string to the stack after they input
        userInput = input.nextLine();

        characters.push(stringToCharArray(userInput));

        if(isPalindrome(characters.peek())){

            System.out.println(characters.peek() + "is a palindrome.");
        }

        else {
            System.out.println(characters.peek() + "isn't a palindrome");
        }



        
    } while(!(characters.peek().equals("E")));
  //characters.push(input.nextLine()); //assign user's string to the stack after they input


    }

    /**
     * 
     * @param s String
     * @return return T/F if the string is the same when reversed
     */
    private static boolean isPalindrome(String s){

        /*
        String simplified = simplifyString(s);
        char[] strArray = stringToCharArray(simplified);

        //counts number of times indexes are equal
        int count = 0;

        for(int i = 0; i < simplified.length(); i++){

            //hopefully this should check the indexes and compare them.
            //If they are equal, count will increment
            if(strArray[i] == (strArray[simplified.length() - i])){

                count++;
            }

            if(count == simplified.length()){
                return true;
            }
        }
        
        return false;
        */
        charAToString();

        return false;
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

        char compare;

        for(int i = 0; i < s.length(); i++){

            compare = s.charAt(i);

            replace = "";

            //flesh out for other punctuation
            if((compare == "!") || (compare == "?") || (compare == ".") || (compare == "<")){ 

                replace = " ";
            }

            returnMe += replace;
        }
        return returnMe; 
    }

    /**
     * 
     * @param s String
     * @return uses toCharArray method to turn a string into char array
     */
    private static char[] stringToCharArray(String s){

        return s.toCharArray();
    }


    public static String charAToString(char[] cA){

        String returnMe = "";

        for(int i = 0; i < cA.length; i++){

            returnMe += cA[i];
        }
        return returnMe;
    }

}
