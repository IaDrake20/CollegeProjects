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

public class Searches {

    /**
     *
     * @param A
     * @param first
     * @param last
     * @param searchItem
     * @return
     */
    public boolean recSeqSearch(int[] A, int first, int last, int searchItem){
        if(first > last){
            return false;
        } else if(A[first] == searchItem){
            return true;
        } else {
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
    public boolean recBinSearch(int[] A, int first, int last, int searchItem){
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

    public static void  main(Stringp[]args){

        //ask user for initial array size
    }
}
