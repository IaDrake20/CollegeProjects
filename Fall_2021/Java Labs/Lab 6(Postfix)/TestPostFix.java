/**
 * Ian Drake
 * Section 4010
 * 10/14/2021
 * Accept user input and turn that into postfix. Then calculate the answer to the expression.
 */
import java.util.Scanner;

public class TestPostFix {

    public static void main(String[]args){
        
        Scanner input = new Scanner(System.in);
        
        //better var name?
        String expression = "";

        //ask for user input. Make it professional later
        System.out.println("Please enter a mathematic expression using the variables a to e. The variable a is 2.0, b is 3.0, and the rest up to e continue the pattern.");
        expression = input.nextLine();


        //convert to postfix
        expression = Postfix.convertToPostfix(expression);

        //print evaluation
        System.out.println(Postfix.evaluatePostfix(expression));

        //test
        //System.out.println(Postfix.test());
    }
    
    //ask for user input

    //convert to postfix through mehtod

    //print evaluation of method's reult
}