import java.util.Scanner;

public class TestPostFix {

    public static void main(String[]args){
        
        Scanner input = new Scanner(System.in);
        
        //better var name?
        String words = "";

        //ask for user input. Make it professional later
        System.out.println("Please enter stuff");
        words = input.nextLine();


        //convert to postfix
        words = Postfix.convertToPostfix(words);

        //print evaluation
        System.out.println(Postfix.evaluatePostfix(words));
    }
    
    //ask for user input

    //convert to postfix through mehtod

    //print evaluation of method's reult
}