public class Problem1 {
    
    /*
    Input: None 
    Output: All the positive 4 digit numbers with no 1's where the product of its digits is a factor of the number 
    Test Data: None 
    Example: 6624 has no 1's, the product of the digits is 6 x 6 x 2 x 4 = 288 and 6624/288 = 23 so 288 is a factor of 6624
    */

    public static void main(String[]args){

        //print numbers 1000 to 9999 with conditions as stated above
        
        //algorithm to use numbers that have a last char != 1.
        //seperate digits into char array and multiply them, then check that remainder of orig and newNum == 0

        int product = 0;
        for(int i = 1000; i < 1009; i++){

            //make a char array of i
            char[] arr = ("" +i).toCharArray();
            boolean no1s = false;
            //verify that this is working
            //TODO  check later

            System.out.println("Product is "+product+ ". arr is "+arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3] );
            product = 0;
            

            for(int j = 0; j < 4; j++){

                //System.out.println("Chekcing "+arr[j]+" for 1s.");
                String s = String.valueOf(arr[j]);
                if(1 != Integer.parseInt(s)){
                    no1s = true;
                }
                else {
                    no1s = false;
                }

                if(1 != arr[0]){
                    no1s = true;
                }
                //System.out.println(no1s);
            }

            if(no1s && arr[arr.length-1] != 1){
                for(int k = 0; k < 4; k++){

                    System.out.println("Product in assign is "+product+ ". arr is "+arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+". k is "+k );

                    //product =0;
                    //System.out.println("Product in inital assign is "+product);

                    if(k==0){
                        product += arr[k];
                        //System.out.println(product+" "+arr[0]+" "+arr[1]+" "+arr[2]+ " "+arr[3]);
                        System.out.println(i+ " k == 0");
                    }
                    else {
                        product *= arr[k];
                        //System.out.println("multiplying current value by product's value                                                                                        "+product);
                    }
                }
            }


            if(no1s && product == 0){

                System.out.println(i + " has no 1 digits, the product of "+ arr[0] +" * "+ arr[1] + " * "+ arr[2]+" * "+ arr[3]+" is "+product+" and "+i+" / "+product+" is 0 so its a factor of "+i);
                
            }
            else if(no1s && i % product == 0){
                System.out.println(i + " has no 1 digits, the product of "+ arr[0] +" * "+ arr[1] + " * "+ arr[2]+" * "+ arr[3]+" is "+product+" and "+i+" / "+product+" is "+i / product+" so its a factor of "+i);
            }
            else if(no1s){
                System.out.println("ERROR");
                System.out.println(i + " has no 1 digits, the product of "+ arr[0] +" * "+ arr[1] + " * "+ arr[2]+" * "+ arr[3]+" is "+product+" and "+i+" / "+product+" is 0 so its a factor of "+i);

            }
        }
    }
}
