import java.util.Scanner;

/*
* Ian Drake
* January 28th, Thursday @ 10AM
* Program will do some simple calculations
*/
public class Calc {
    
    public static void main(String[]args) {

    
        int firstNum = 29645;
        int secondNum = 392;
        int sum; //sum of firstNum and SecondNum
        int diff; //difference of firstNum and secondNum
        int product; //product of firstNum and secondNum
        double quotient; //firstNum divided by secondNum
        double average; //average of firstNum and secondNum
        int remainder; //remainder when firstNum is divided by secondNum

        sum = firstNum + secondNum;
        diff = firstNum - secondNum;
        product = firstNum * secondNum;
        quotient = (double)firstNum / (double)secondNum;
        average = ((double)firstNum + (double)secondNum) / 2;
        remainder = firstNum % secondNum; //should be 605, returning 245

        System.out.println("The sum is "+sum);
        System.out.println("The difference is "+diff);
        System.out.println("The product is "+product);
        System.out.println("The quotient is "+quotient);
        System.out.println("The average is "+ average);
        System.out.println("The remainder is "+remainder);
    }
}
