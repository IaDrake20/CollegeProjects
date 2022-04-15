import java.util.Scanner;
public class Untitled {

    public static void main(String[]args){

        problem1RUN();
        problem2RUN();
        problem3RUN();
    }

    /*
    {2, 3, 5} and {1, 7, 5} 
{8, 9, 4, -1} and {9, 7, 3, -1} 
{9, 9, 2, 7, 6, -1, -1, -1} and {9, 0, 5} 
{6, 9, 4, 1, -1, -1} and {5, 0, 0, 0, 6, 7, 3, -1, -1,  -1, -1} 
*/
    public static void problem3RUN(){

        Scanner input = new Scanner(System.in);
        int[] temp = new int[50];
        int[] arr1; 
        int[] arr2;
        int[] result;
        int numValues = 0;
        String s; //contains user input
        boolean run = true;

        
        while(run){
            //input 2 arrays. Each array will hold an int that has had its digits seperated into the indices. the largest place value digit should be at entry 0.
        System.out.println("Please enter the first int array. Type x to exit the loop or finish to end the program.");
        for(int i = 0; i < 50; i++){
            numValues++;
            s = input.next();
            if(s.equalsIgnoreCase("x")){
                break;
            } else if(s.equalsIgnoreCase("finish")){
                run = false;
                System.exit(0);
            } else if(s.equals("-1")) {
                numValues--;
            } else {
                temp[i] = Integer.parseInt(s);
            }
        }

        arr1 = new int[numValues];

        //copy values from temp to arr1 including -1s
        for(int i = 0; i < arr1.length-1; i++){
            //System.out.println("this is the length of arr 1: "+arr1.length+" and currenty at index "+i);
            arr1[i] = temp[i];
            //System.out.println("temp1 "+i+" is "+temp[i]);
        }

        numValues = 0;
        temp = new int[50];
        System.out.println("Please enter the second int array.");
        for(int i = 0; i < 50; i++){
            numValues++;
            s = input.next();
            if(s.equalsIgnoreCase("x")){
                break;
            } else if(s.equals("-1")) {
                numValues--;
            } else {
                temp[i] = Integer.parseInt(s);
            }
        }

        arr2 = new int[numValues];

        //copy values from temp to arr1 including -1s
        for(int i = 0; i < arr2.length-1; i++){
            arr2[i] = temp[i];
            //System.out.println("temp2 "+i+" is "+temp[i]+" and currenty at index "+i);
        }
        
        //take the 2 arrays and grab the digits from their indexes. start from the back and go to the front to preserve the values
        int arr1len = arr1.length;
        int arr2len = arr2.length;

        if( arr1len > arr2len){
            //loop thru and concatenate strings from the last index to first
            result = new int[arr1len];
            for(int i = arr1len-1; i >= 0; i--){

                if( i >= arr2len){
                    result[i] = arr1[i];
                }
                else if(arr1[i] == -1 || arr2[i] == -1){
                    i++;
                }
                else if(i < arr2len){
                    result[i] = arr1[i] + arr2[i];
                }
                //System.out.println("result["+i+"] is "+result[i]);
            }
        }
        else if(arr2len > arr1len){
            //loop thru and concatenate strs
            result = new int[arr2len];
            for(int i = arr2len-1; i >= 0; i--){

                if( i >= arr1len){
                    result[i] = arr2[i];
                }
                else if(arr2[i] == -1 || arr1[i] == -1){
                    i++;
                }
                else if(i < arr1len){
                    result[i] = arr1[i] + arr2[i];
                }
                //System.out.println("result["+i+"] is "+result[i]);
            }
        }
        else {
            //case that they are equals
            result = new int[arr1len];
            for(int i = arr1len-1; i >= 0; i--){
                if(arr2[i] == -1 || arr1[i] == -1){
                    i++;
                }
                else {
                    result[i] = arr1[i] + arr2[i];
                    //System.out.println("result["+i+"] is "+result[i]);
                }
            }
        }

        //print out values of result array
        for(int i = 0; i < result.length; i++){
            System.out.println("The current index "+i+" contains "+result[i]);
        }
        }
    }

    /**
     * 1, 7, 2, 10, 6, 6, 2, 8, 9}  returns 9 
  {8, 7, 6, 1, 6, 5, 2, 1, 2}  returns 7 
  {1, 7, 2, 9, 6, 9, 2, 8, 6}  returns 8
  {7, 7, 6, 1, 6, 5, 2, 1, 2}  returns 7 
  {-4, -2, -9, -3, -8, -10, -6, -2, -1}  returns -2 
     */
    public static void problem2RUN(){

        boolean finish = false;
        int arrSize = 0;
        int[] arr;

        Scanner input = new Scanner(System.in);
        //loop to run program w/ input at user's discretion
        while(!finish){
            System.out.println("Please enter an int that will be the size of the array, then the contents. Type finish to exit.");
            String userInput = input.next();

            //check to see if we want to leave
            if(userInput.equalsIgnoreCase("finish")){
                finish = true;
                break;
            }
            else {
                arrSize = Integer.parseInt(userInput);
            }

            //get input and put into array NO SORTING
            arr = new int[arrSize];
            int greatestNum = 0;
            int secGreatestNum = 0;

            System.out.println("Please enter the contents of the int array");
            for(int i = 0; i < arrSize; i++){
                arr[i] = input.nextInt();
            }

            //Traverse ONCE and get 2nd largest num
            for(int i = 0; i < arrSize; i++){
                //System.out.println("Comparing "+arr[i]+" to gn: "+greatestNum);
                
                if(arr[i] > greatestNum){
                    //System.out.println("Assigning "+arr[i]+" to gn");
                    //save new second greatest number to var, update greatest number
                    secGreatestNum = greatestNum;
                    greatestNum = arr[i];
                }

                //System.out.println("Comparing "+arr[i]+" to sgn: "+secGreatestNum);
                if(arr[i] > secGreatestNum && arr[i] != greatestNum){
                    secGreatestNum = arr[i];
                    //System.out.println("sgn is now "+secGreatestNum);
                }
                //System.out.println(greatestNum+" is now the second greatest #.");
                //greatestNum = arr[i];
                //System.out.println(greatestNum+" is now the greatest #.");
            }//end of for loop to retrieve 2nd greatest number

            //print that num
            System.out.println("The second greatest number for the array is "+secGreatestNum);

        }//end of while
    }//end of method

    public static void problem1RUN(){

        for(int i = 1000; i < 9999; i++){

            //make a char array of i
            char[] arr = ("" +i).toCharArray();
    
            for(int z = 0; z < arr.length; z++){
                //System.out.println(arr[z]);
            }
            boolean no1s = false;
            boolean digitIsZero = false;
            int product = 0;
    
            //check that no digits are 1
            for( int k = 0; k < 4; k++){
                String s = String.valueOf(arr[k]);
                if(Integer.parseInt(s) == 1){
                    no1s = false;
                    k=3;
                    //System.out.println(s+" was found to be a 1.");
                    //System.out.println("product inside creation of char array(if 1) is "+product);
    
                }
                else {
                    no1s = true;
                    //System.out.println(s+ " was found not to be a 1");
                    //System.out.println("product inside creation of char array(else 1) is "+product);
    
                }
                if(Integer.parseInt(s) == 0){
                    product = 0;
                    digitIsZero = true;
                    //System.out.println("product inside creation of char array(if 2) is "+product);
    
                }
            } //end of checking that any digit is 1
    
    
            //product is being initialized somehow, manually setting to 0
            product = 0;
           // System.out.println("product before calculations and after creation of char array is "+product);
    
            product = 0;
            //System.out.println("(2)product before calculations and after creation of char array is "+product);
    
    
            //calculating the product
            for(int j = 0; j < 4; j++){
                String s = "";
                if(digitIsZero){
                    break;
                }
                else if(j==0){
                    s = String.valueOf(arr[j]);
                    product = Integer.parseInt(s);
                    //System.out.println(product+" "+arr[0]+" "+arr[1]+" "+arr[2]+ " "+arr[3]);
                    //System.out.println(i+ " j == 0");
                    //System.out.println("setting initial product value to be "+product);
                }
                else {
                    s = String.valueOf(arr[j]);
                    product *= Integer.parseInt(s);
                    //System.out.println("multiplying current value by product's value to get      "+product);
                }
            }
    
            //System.out.println("product before prints is "+product);
            if(digitIsZero){
    
            }
            else if(no1s && product == 0){
    
                System.out.println(i+" has no 1 digits, the product of "+ arr[0] +" * "+ arr[1] + " * "+ arr[2]+" * "+ arr[3]+" is "+product+" and "+i+" / "+product+" is 0 so its a factor of "+i);
                
            }
            else if(no1s && i % product == 0){
                System.out.println(i + " has no 1 digits, the product of "+ arr[0] +" * "+ arr[1] + " * "+ arr[2]+" * "+ arr[3]+" is "+product+" and "+i+" / "+product+" is "+i / product+" so its a factor of "+i);
            }
            else if(no1s){
                //System.out.println(i + " has no 1 digits, the product of "+ arr[0] +" * "+ arr[1] + " * "+ arr[2]+" * "+ arr[3]+" is "+product+" and "+i+" / "+product+" is " +i/product+" so its a factor of "+i);
    
            }    
        }
    }
}
    

    

    

