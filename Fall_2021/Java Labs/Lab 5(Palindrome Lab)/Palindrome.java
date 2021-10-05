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

    }
    userInput.push(input.nextLine()); //assign user's string to the stack after they input


    }
}
