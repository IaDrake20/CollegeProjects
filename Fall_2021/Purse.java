/*********************************************************************************
* Ian Drake
* 9/23/2021
* Section 4010
* This class will do accept input with error correction. 
* It will then print the total cash amount and the amount of each coin.
* After it will reduce all numbers of coins to 1 and reprint the cash total.
**********************************************************************************/

import java.util.Scanner;

public class Purse {

    public static void main(String[]args){

        ArrayBag<String> purse = new ArrayBag<String>(100);
   
        Scanner input = new Scanner(System.in);

        int numberOfCoins;//used to hold number of coins typed in for later

        String temp = "";

        double totalCash = 0.00;

        System.out.println("Please enter your coins as DO, H, Q, D, N, and/or P. You can type E to exit");


        while(!(purse.contains("E"))){

            temp = input.nextLine();
            purse.add(temp);

            switch(temp){

                case "DO": totalCash += 1.0;
                                                    break;
                case "do": totalCash += 1.0;
                                                    break;                                    
                case "H": totalCash += 0.5;
                                                    break;
                case "h": totalCash += 0.5;
                                                    break;
                case "Q": totalCash += 0.25;
                                                    break;
                case "q": totalCash += 0.25;
                                                    break;
                case "D": totalCash += 0.1;
                                                    break;
                case "d": totalCash += 0.1;
                                                    break;
                case "N": totalCash += 0.05;
                                                    break;
                case "n": totalCash += 0.05;
                                                    break;
                case "P": totalCash += 0.01;
                                                    break;
                case "p": totalCash += 0.01;
                                                    break;
                case "E": 
                                                    break;
                case "e":
                                                    break;
                default:
                    System.out.println("Please enter your coins as DO, H, Q, D, N, and/or P.  You can type E to exit");
            }
        }

        System.out.println("\nTotal cash amount is: $"+ roundTotal(totalCash));

        //print number of each coin
        System.out.println("\nThe number of DO coins is "+purse.getFrequencyOf("DO"));
        System.out.println("The number of H coins is "+purse.getFrequencyOf("H"));
        System.out.println("The number of Q coins is "+purse.getFrequencyOf("Q"));
        System.out.println("The number of D coins is "+purse.getFrequencyOf("D"));
        System.out.println("The number of N coins is "+purse.getFrequencyOf("N"));
        System.out.println("The number of P coins is "+purse.getFrequencyOf("P"));

        //remove duplicates
        numberOfCoins = purse.getFrequencyOf("DO");
        for(int i = 1; i < numberOfCoins; i++){

            purse.remove("DO");

            totalCash -= 1;
        }

        numberOfCoins = purse.getFrequencyOf("H");
        for(int i = 1; i < numberOfCoins; i++){

            purse.remove("H");

                totalCash -= 0.5;
        }

        numberOfCoins = purse.getFrequencyOf("Q");
        for(int i = 1; i < numberOfCoins; i++){

            purse.remove("Q");

                totalCash -= 0.25;
        }

        numberOfCoins = purse.getFrequencyOf("D");
        for(int i = 1; i < numberOfCoins; i++){

            purse.remove("D");

                totalCash -= 0.1;
        }

        numberOfCoins = purse.getFrequencyOf("N");
        for(int i = 1; i < numberOfCoins; i++){

            purse.remove("N");

                totalCash -= 0.05;
        }

        numberOfCoins = purse.getFrequencyOf("P");
        for(int i = 1; i < numberOfCoins; i++) {//purse.getFrequencyOf("P"); i++){

            purse.remove("P");

            totalCash -= 0.01;
            
        }

        //while(purse.getFrequencyOf("P") != 1){

            //purse.remove("P");

            //if(purse.remove("P")){

                //totalCash -= 0.01;
           // }
      //  }

        System.out.println("\nTotal cash amount after removal of duplicates is: $"+ roundTotal(totalCash));
        System.out.println("\nThe number of DO coins is "+purse.getFrequencyOf("DO"));
        System.out.println("The number of H coins is "+purse.getFrequencyOf("H"));
        System.out.println("The number of Q coins is "+purse.getFrequencyOf("Q"));
        System.out.println("The number of D coins is "+purse.getFrequencyOf("D"));
        System.out.println("The number of N coins is "+purse.getFrequencyOf("N"));
        System.out.println("The number of P coins is "+purse.getFrequencyOf("P"));

    }

    public static double roundTotal(double money){

        return Math.round(money * 100.0) / 100.0;
    }
    
}