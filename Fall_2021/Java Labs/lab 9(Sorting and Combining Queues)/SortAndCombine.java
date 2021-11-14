import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.border.EmptyBorder;

public class SortAndCombine {

    public static void main(String[]args){
        
        ArrayQueue <Integer> intUserInputs = new ArrayQueue <Integer>();
        ArrayQueue <Integer> intUserInputs2 = new ArrayQueue <Integer>();
        ArrayQueue <Integer> finalQueue = new ArrayQueue<Integer>();

        Scanner input = new Scanner(System.in);

        String userInput = ""; //rename to something more appropriate
        String finalOutput = "";
        StringTokenizer sT;

        int queueLength1 = 0;

        //ask for input
        System.out.println("Enter integers for the first queue. Make sure to seperate them by a space.");
        userInput = input.nextLine();
        sT = new StringTokenizer(userInput);

        //assign values to intUserInputs from tokens
        while(sT.hasMoreTokens()){
            intUserInputs.enqueue(Integer.parseInt(sT.nextToken()));
            ++queueLength1;
        } 

        
        int[] myArray1 = createIntList(intUserInputs, queueLength1);  

        //ask for 2nd input
        System.out.println("Please enter a second sequence of integers that are all seperated by spaces.");
        userInput = input.nextLine();
        sT = new StringTokenizer(userInput);

        int queueLength2 = 0;

        //assign values to intUserInputs from tokens
        while(sT.hasMoreTokens()){
            intUserInputs2.enqueue(Integer.parseInt(sT.nextToken()));
            ++queueLength2;
        }

        int[] myArray2 = createIntList(intUserInputs2, queueLength2);

        //make sure arrays actually have stuff in them
        //printValues(myArray1);
        //printValues(myArray2);

        //reassign values (sorted) to queue1
        for( int i = 0; i < queueLength1; i++){

            intUserInputs.enqueue(myArray1[i]);
        }

        //same for queue 2
        for( int i = 0; i < queueLength2; i++){

            intUserInputs2.enqueue(myArray2[i]);
        }


        boolean isFinished = false;

        while(!isFinished){ //fix

            if(intUserInputs.isEmpty() && (!intUserInputs2.isEmpty())){

                finalQueue.enqueue(intUserInputs2.dequeue());

            }

            if(intUserInputs2.isEmpty() && (!intUserInputs.isEmpty())){

                finalQueue.enqueue(intUserInputs.dequeue());
            }

            if((!intUserInputs.isEmpty()) && (!intUserInputs2.isEmpty())){

                if(intUserInputs.getFront() < intUserInputs2.getFront()){
                    
                    finalQueue.enqueue(intUserInputs.dequeue());
                }
                else {
                    finalQueue.enqueue(intUserInputs2.dequeue());
                }
            }

            if(intUserInputs.isEmpty() && intUserInputs2.isEmpty()){
                isFinished = true;
            }
        }
        //System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjj");

        while(!finalQueue.isEmpty()){
            //System.out.println(finalQueue.dequeue());
            finalOutput += finalQueue.dequeue();
        }

        System.out.println("Sorted combined queue is "+finalOutput);
        

        
    }

    //this will work for only a few scenarios, needs to be able to shift many values across indexes
    private static int[] makeRoom(int pos, int[] intArray, int numEntries){

        for(int i = numEntries; i > pos; i--){

            intArray[i] = intArray[i-1];
        }

        
        /*
        for(int i = 0; i < intArray.length -1; i++){

            //if wanted spot is occupied and next spot is empty, move occupied spot's data to empty one
            if(intArray[pos] != 0 && intArray[pos + 1] == 0){

                    System.out.println("Making space");
                    intArray[pos + 1] = intArray[pos];
                    intArray[pos] = 0;
            }

            if(intArray[pos] == 0){

                //this is what we want, do nothing
                System.out.println("Space available for "+pos);
            }
        }
        */
        return intArray;
    }

    private static int[] createIntList(ArrayQueue<Integer> inputs, int lengthOfQueue){

        int[] intList = new int[lengthOfQueue];

        int entries = 0;
        int temp;

        boolean done = false;

        try{
            intList[0] = inputs.dequeue();
        } catch(EmptyQueueException e){
            done = true;
        }
        ++entries;
        --lengthOfQueue;

        //while(lengthOfQueue != 0) { //set to notDone

        while(!done) {

            try {
            temp = inputs.dequeue();
            } catch(EmptyQueueException e){
                done = true;
                break;
            }

           //System.out.println("temp is "+temp);
            //--lengthOfQueue;

            int index = 0;

            for (index = 0; index < entries; index++) {

                //System.out.println(index+ " "+ intList[index] + " "+ temp);
                if( intList[index] > temp ) { 

                    //System.out.println("setting index to "+index);
                    break;	
                }
            }

            makeRoom(index, intList, entries);
            //printValues(intList);
            intList[index] = temp;
            //System.out.println("inserting "+temp+"  @ "+ index);
            ++entries;	

            
        }

        return intList;
    }    

    private static void printValues(int[] values){

        for(int i = 0; i < values.length; i++){
            System.out.println("Index "+i+ " is "+values[i]);
        }

    }
}