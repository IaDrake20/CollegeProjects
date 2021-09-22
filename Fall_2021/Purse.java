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

        double totalCash = 0.00;

        System.out.println("Please enter your coins as Dollar C, Half Dollar, Quarter, Dime, Nickel, and/or Penny. You can type E to exit");


        for(int i = 0; i <= purse.getCurrentSize(); i++){
       
            while(purse.getFrequencyOf("e") == 0){
                
                switch(input.nextLine().toLowerCase()){

                    case "dollar c": totalCash += 1.0;
                                                        break;
                    case "half dollar": totalCash += 0.5;
                                                        break;
                    case "quarter": totalCash += 0.25;
                                                        break;
                    case "dime": totalCash += 0.1;
                                                        break;
                    case "nickel": totalCash += 0.05;
                                                        break;
                    case "penny": totalCash += 0.01;
                                                        break;
                    case "e": 
                                                        break;
                    default:
                        System.out.println("Please enter your coins as Dollar C, Half Dollar, Quarter, Dime, Nickel, and/or Penny. You can type E to exit");
                }

            }
            
        }

        System.out.println("Total cash amount is: "+ roundTotal(totalCash));

    }

    public static double roundTotal(double money){

        return Math.round(money * 100.0) / 100.0;
    }
    
}
