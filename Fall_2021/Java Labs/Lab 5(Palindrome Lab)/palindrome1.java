/**
 * Ian Drake
 * Section 4010
 * Due 10/7/2021
 * This class will accept input and tell the user if it is a palindrome or not
 */
import java.util.*;

public class palindrome1 {

    private static char[] charList;


    public static void main(String[]args){

        Scanner input = new Scanner(System.in);
        int numberOfInputs = 20;//arbitrary number, find better solution
    
        String userInput = "";

        ArrayStack<Character> characters = new ArrayStack<Character>(numberOfInputs);

        //ask user for input
        //get input as a string
        //break down string into char array
        //remove undesired characters
        //check if its a palindrome
        do {
            System.out.println("Please type in your desired characters or E to exit");
            userInput = input.nextLine();

            if(userInput.equalsIgnoreCase("e")){
                
                break;
            }

            charList = userInput.toLowerCase().toCharArray();

            //push to characters the most recent addition to charList
            characters.push(charList[charList.length-1]);

            simplify();

            if(isPalindrome(charList)){

                System.out.println("It is a palindrome");
            }

            else {
                System.out.println("It is not a palindrome");
            }

            System.out.println("You can type E if you wish to exit, otherwise type what you want to check to see if that is a palindrome.");

        } while(!(characters.peek().equals('e')));

    }

    private static boolean isPalindrome(char[] cA) {

        //incrememnts each time a character is equal to a character
        //if this is equal to the length of the array, it is a palindrome
        int count = 0;

       // System.out.println("in isPalindome");

        for(int i = 0; i < cA.length; i++){

            //System.out.println(cA[i]);

            if(cA[0] == (cA[cA.length -1]) && i == 0){

                //System.out.println("in first for. "+cA[0]+"..."+cA.length);
                count++;
            }

           // System.out.println("i..."+i+"...cA[i]:"+cA[i]);


            //if(i>=1){
              // System.out.println("Conditon..."+cA[cA.length-i]+" Compare:"+cA[i]+" to "+cA[cA.length -i]);

          //  }
            //else{
               //System.out.println("Conditon..."+cA[cA.length]+" Compare:"+cA[0]+" to "+cA[cA.length]);
           // }

            if(i >= 1 && cA[i] == (cA[cA.length -(i+1)])){

                //System.out.println("in 2nd for.");// "+cA[0]+"..."+cA[i]);
                //System.out.println("60% sure it is a palindome");
                count++;
            }
           // else{
               // System.out.println("no 2nd for");
           // }
            
        }

        if(count == cA.length){
            return true;
        }

        return false;
    }

    private static void simplify(){

        for(int i = 0; i < charList.length; i++){

            //charList[i];

            if(!(Character.isLetter(charList[i]))){
               
                charList[i] = Character.MIN_VALUE;
            }
        }
    }

    

}

