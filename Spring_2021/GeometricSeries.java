/*
* Ian Drake
* 2/4 10:00 AM
* Geometric Series
* This program will prompt the user for 2 inputs, then use said inputs to 
* calculate the geometric sum.
*/
import java.util.Scanner;

public class GeometricSeries {
    
    public static void main(String[]args){

        for(int i =0; i<20; i+=2){
            System.out.println(i);
        }

        int n; //a number that the user will input
        double r; //the geometric ratio that the user will input
        double result;

        Scanner input = new Scanner(System.in); 

        //ask for a number
        System.out.print("Please enter a positive integer for n (highest power): ");
        n = input.nextInt();

        //solves a spacing issue
        //System.out.println();

        //ask for a ratio
        System.out.print("Please enter a real number for r (ratio): ");
        r = input.nextDouble(); 

        //(r^n+1 -r)/r-1
        result = (Math.pow(r,n +1) -r)/ (r-1);

        //print result out in a format
        System.out.printf("\n The sum is %.2f \n ", result);
    }
}
