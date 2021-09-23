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
            

           // if(!(temp.equals("Dollar C") && !(temp.equals("Half Dollar") && !(temp.equals("Quarter") && !(temp.equals("Dime") && !(temp.equals("Nickel") && !(temp.equals("Penny")))))))){

                //System.out.println("Please enter your coins as Dollar C, Half Dollar, Quarter, Dime, Nickel, and/or Penny. You can type E to exit");
           // }
        }



        

/*
        for(int i = 0; i <= purse.getCurrentSize(); i++){
       
            while(purse.getFrequencyOf("e") == 0){

                purse.add(input.nextLine());
                
                //fix switch's conditional
                //purse.getFrequencyOf(null);

                switch(purse.contains(i)){

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
*/
        System.out.println("Total cash amount is: "+ roundTotal(totalCash));

        //print number of each coin
        System.out.println("The number of dollar coins is "+purse.getFrequencyOf("Dollar C"));
        System.out.println("The number of half dollars is "+purse.getFrequencyOf("Half Dollar"));
        System.out.println("The number of quarters is "+purse.getFrequencyOf("Quarter"));
        System.out.println("The number of dimes is "+purse.getFrequencyOf("Dime"));
        System.out.println("The number of nickels is "+purse.getFrequencyOf("Nickel"));
        System.out.println("The number of pennys is "+purse.getFrequencyOf("Penny"));

        //remove duplicates
        for(int i = 1; i < purse.getFrequencyOf("Dollar C"); i++){

            purse.remove("Dollar C");

            if(purse.remove("Dollar C")){

                totalCash -= 1;
            }
        }

        for(int i = 1; i < purse.getFrequencyOf("Half Dollar"); i++){

            purse.remove("Half Dollar");

            if(purse.remove("Half Dollar")){

                totalCash -= 0.5;
            }
        }

        for(int i = 1; i < purse.getFrequencyOf("Quarter"); i++){

            purse.remove("Quarter");

            if(purse.remove("Quarter")){

                totalCash -= 0.25;
            }
        }

        for(int i = 1; i < purse.getFrequencyOf("Dime"); i++){

            purse.remove("Dime");

            if(purse.remove("Dime")){

                totalCash -= 0.1;
            }
        }

        for(int i = 1; i < purse.getFrequencyOf("Nickel"); i++){

            purse.remove("Nickel");

            if(purse.remove("Nickel")){

                totalCash -= 0.05;
            }
        }

        for(int i = 1; i < purse.getFrequencyOf("Penny"); i++){

            purse.remove("Penny");

            if(purse.remove("Penny")){

                totalCash -= 0.01;
            }
        }

        System.out.println("Total cash amount after removal of duplicates is: "+ roundTotal(totalCash));


    }

    public static double roundTotal(double money){

        return Math.round(money * 100.0) / 100.0;
    }
    
}