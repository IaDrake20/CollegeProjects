/*
* Ian Drake
* 2/18 10:00 AM
* City Tax
* This program will prompt the user for their income, value of their car, and age. It will then calculate
* and print the income taxe, car tax, tax credit and total tax due.
*/

import java.util.Scanner;

public class CityTax {
    
    public static void main(String[]args){

        Scanner input = new Scanner(System.in); //is used to accept user input and transfer data to a variable
        double income, carValue, age; //income of user, user's car's value, and the user's age
        final double Lowest_Tax_Rate, Middle_Tax_Rate, Highest_Tax_Rate, Car_Tax; //max values of different income tax sections, tax on car. Not to be changed
        double taxesDue; //final value after calculations are finished for taxes
        
        taxesDue = 0.0; //initializes to account for scope problems

        Lowest_Tax_Rate = 0.006;
        Middle_Tax_Rate = 0.011;
        Highest_Tax_Rate = 0.016;

        Car_Tax = 0.0185;

        System.out.print("Please enter your total income: $");
        income = input.nextDouble();

        System.out.print("Now please enter your car's value: $");
        carValue = input.nextDouble();

        System.out.print("Enter your age: ");
        age = input.nextDouble();

        //Calculating taxes

        if (income > 9000 && income < 35000){
            taxesDue = Lowest_Tax_Rate;
        }

        else if (income > 35000 && income < 90000){
            
            taxesDue = income * Lowest_Tax_Rate;
            taxesDue += income * Middle_Tax_Rate;
        }

        else if (income > 90000){
            
            taxesDue = income * Lowest_Tax_Rate;
            taxesDue += income * Middle_Tax_Rate;
            taxesDue += income * Highest_Tax_Rate;
        }

        if ( (age % 4 == 0 && age % 7 == 0) ){

            System.out.println("You do not qualify for credit on your taxes.");
        }
        
        else if ((age % 4 == 0) || (age % 7 == 0)) {

                 System.out.println("You are eligible for the credit of $600 on your taxes.");
                 taxesDue -= 600.0;
        }

        else {

            System.out.println("You do not qualify for credit on your taxes.");
        }

        //checks taxes due to make sure the number is not negative
        if (taxesDue < 0){

            taxesDue = 0.0;
        }
        
        taxesDue += (carValue * Car_Tax); //add the car tax to the taxes due

        System.out.println("Your taxes are $"+ taxesDue);


    }
}
