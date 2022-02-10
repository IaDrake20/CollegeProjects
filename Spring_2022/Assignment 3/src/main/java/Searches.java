/*
Ian Drake
1/27/2022
This class will count the number of searches for an unsuccessful search for a variety of integer arrays in each of the searches.
After asking the user for an array size, the program will count the number of comparisons and keep doubling the size while counting the comparisons.
It will then print the size of the array and # of comparisons for each case...
-----------------------------------------------------------------------------------------------------------------
enter size __
(type) search results
Size Comps
x	 ###(some number)
2x	 ###
4x	 ###
8x	 ###
16x	 ###
...
----------------------------------------------------------------------------------------------------------------- */
import java.util.Scanner;
public class Searches {
    /**
     *
     * @param A
     * @param searchItem
     * @return
     */
    public static boolean itSeqSearch(int[] A, int searchItem){
        for(int i = 0; i < A.length; i++){
            if(searchItem == A[i]){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param A
     * @param first
     * @param last
     * @param searchItem
     * @return
     */
    public static boolean recSeqSearch(int[] A, int first, int last, int searchItem){
        //int totalCalls;
        if(first > last){
            return false;
        } else if(A[first] == searchItem){
            return true;
        } else {
            //++totalCalls;

            return recSeqSearch(A, ++first, last, searchItem);
        }
    }

    /**
     *
     * @param A
     * @param first
     * @param last
     * @param searchItem
     * @return
     */
    public static boolean recBinSearch(int[] A, int first, int last, int searchItem){
        if(first > last){
            return false;
        }
        else if(searchItem > first && searchItem < last){
            recBinSearch(A, first, last, searchItem);
        }
        //TEMP
        //TODO: change to actual return statement
        return false;
    }

    private static int[] createIntArray(int size){
        int[] intArray = new int[size];
        for(int i = 0; i < size; i++){
            double temp = Math.random() * 10;
            intArray[i] = (int)temp;
        }
        return intArray;
    }

    private static int[] resizeIntArray(int[] arr){
        int[] temp = new int[arr.length * 2];
        for(int i = 0; i < arr.length -1; i++){
            temp[i] = arr[i];
        }
        return arr;
    }

    private void printResults(int[] arr){

    }

    public static void  main(String[]args){

        Scanner input = new Scanner(System.in);
        int userNumber = 0;

        //ask user for initial array size
        System.out.print("Please enter the size of the integer array: ");
        userNumber = input.nextInt();

        int[] myArray = createIntArray(userNumber);

        System.out.println("Size            Comparisons");


        System.out.println(itSeqSearch(myArray, -1));

        System.out.println(recBinSearch(myArray, myArray[0], myArray[myArray.length-1], -5));

    }
}
