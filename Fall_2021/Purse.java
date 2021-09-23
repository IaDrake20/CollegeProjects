/****************
* Ian Drake
* 9/23/2021
* Section 4010
* This class will do something 
******************/

import java.util.Scanner;

public class Purse {

    public static void main(String[]args){

        ArrayBag<String> purse = new ArrayBag<String>(100);
   
        Scanner input = new Scanner(System.in);

        int numberOfCoins;//used to hold number of coins typed in for later

        String temp = "";

        double totalCash = 0.00;

        System.out.println("Please enter your coins as Dollar C, Half Dollar, Quarter, Dime, Nickel, and/or Penny. You can type E to exit");


        while(!(purse.contains("E"))){

            temp = input.nextLine();
            purse.add(temp);

            switch(temp){

                case "Dollar C": totalCash += 1.0;
                                                    break;
                case "Half Dollar": totalCash += 0.5;
                                                    break;
                case "Quarter": totalCash += 0.25;
                                                    break;
                case "Dime": totalCash += 0.1;
                                                    break;
                case "Nickel": totalCash += 0.05;
                                                    break;
                case "Penny": totalCash += 0.01;
                                                    break;
                case "E": 
                                                    break;
                default:
                    System.out.println("Please enter your coins as Dollar C, Half Dollar, Quarter, Dime, Nickel, and/or Penny. Case matters. You can type E to exit");
            }
        }

        System.out.println("\n Total cash amount is: $"+ roundTotal(totalCash));

        //print number of each coin
        System.out.println("\n The number of dollar coins is "+purse.getFrequencyOf("Dollar C"));
        System.out.println("The number of half dollars is "+purse.getFrequencyOf("Half Dollar"));
        System.out.println("The number of quarters is "+purse.getFrequencyOf("Quarter"));
        System.out.println("The number of dimes is "+purse.getFrequencyOf("Dime"));
        System.out.println("The number of nickels is "+purse.getFrequencyOf("Nickel"));
        System.out.println("The number of pennys is "+purse.getFrequencyOf("Penny"));

        //remove duplicates
        numberOfCoins = purse.getFrequencyOf("Dollar C");
        for(int i = 1; i < numberOfCoins; i++){

            purse.remove("Dollar C");

            totalCash -= 1;
        }

        numberOfCoins = purse.getFrequencyOf("Half Dollar");
        for(int i = 1; i < numberOfCoins; i++){

            purse.remove("Half Dollar");

                totalCash -= 0.5;
        }

        numberOfCoins = purse.getFrequencyOf("Quarter");
        for(int i = 1; i < numberOfCoins; i++){

            purse.remove("Quarter");

                totalCash -= 0.25;
        }

        numberOfCoins = purse.getFrequencyOf("Dime");
        for(int i = 1; i < numberOfCoins; i++){

            purse.remove("Dime");

                totalCash -= 0.1;
        }

        numberOfCoins = purse.getFrequencyOf("Nickel");
        for(int i = 1; i < numberOfCoins; i++){

            purse.remove("Nickel");

                totalCash -= 0.05;
        }

        numberOfCoins = purse.getFrequencyOf("Penny");
        for(int i = 1; i < numberOfCoins; i++) {//purse.getFrequencyOf("Penny"); i++){

            purse.remove("Penny");

            totalCash -= 0.01;
            
        }

        //while(purse.getFrequencyOf("Penny") != 1){

            //purse.remove("Penny");

            //if(purse.remove("Penny")){

                //totalCash -= 0.01;
           // }
      //  }

        System.out.println("\n Total cash amount after removal of duplicates is: $"+ roundTotal(totalCash));
        System.out.println("\n The number of dollar coins is "+purse.getFrequencyOf("Dollar C"));
        System.out.println("The number of half dollars is "+purse.getFrequencyOf("Half Dollar"));
        System.out.println("The number of quarters is "+purse.getFrequencyOf("Quarter"));
        System.out.println("The number of dimes is "+purse.getFrequencyOf("Dime"));
        System.out.println("The number of nickels is "+purse.getFrequencyOf("Nickel"));
        System.out.println("The number of pennys is "+purse.getFrequencyOf("Penny"));

    }

    public static double roundTotal(double money){

        return Math.round(money * 100.0) / 100.0;
    }
    
}