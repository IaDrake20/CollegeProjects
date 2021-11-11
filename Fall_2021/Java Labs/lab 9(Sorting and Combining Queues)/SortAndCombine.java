import java.util.Scanner;
import java.util.StringTokenizer;

public class SortAndCombine {

    public static void main(String[]args){
        
        ArrayQueue <Integer> intUserInputs = new ArrayQueue <Integer>();
        ArrayQueue <Integer> intUserInputs2 = new ArrayQueue <Integer>();

        Scanner input = new Scanner(System.in);
        String s = ""; //rename to something more appropriate
        StringTokenizer sT;

        int queueLength = 0;

        //ask for input
        System.out.println("Please enter a sequence of integers...");
        s = input.nextLine();

        sT = new StringTokenizer(s);

        //assign values to intUserInputs from tokens
        while(sT.hasMoreTokens()){
            intUserInputs.enqueue(Integer.parseInt(sT.nextToken()));
            ++queueLength;
        } 

        int[] myArray1 = createIntList(intUserInputs, queueLength);

        //ask for 2nd input
        System.out.println("Please enter a second sequence of integers...");
        s = input.nextLine();
        sT = new StringTokenizer(s);

        //assign values to intUserInputs from tokens
        while(sT.hasMoreTokens()){
            intUserInputs.enqueue(Integer.parseInt(sT.nextToken()));
            ++queueLength;
        }

        int[] myArray2 = createIntList(intUserInputs2, queueLength);

    }

    //this will work for only a few scenarios, needs to be able to shift many values across indexes
    private static int[] makeRoom(int pos, int[] intArray){

        if(intArray[pos] != 0 && intArray[pos + 1] == 0){

            System.out.println("Making space");
            intArray[pos + 1] = intArray[pos];
            intArray[pos] = 0;
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

        boolean isFinished = false;

        int[] intList = new int[lengthOfQueue];

        int entries = 0;

        while (!isFinished) {
            
            //sort to arrange low to high
            for (int i = 0; i < lengthOfQueue-1; i++){ 

                try {
                    //System.out.println("Currently "+inputs.getFront()+" is in front of the queue");

                    if(i == 0){

                        intList[0] = inputs.dequeue();
                        ++entries;
                    }

                    if(inputs.getFront() >= intList[i]){

                        //System.out.println(":::::::::place "+inputs.getFront()+ " into the intList");
                        makeRoom(i, intList);
                        intList[i] = inputs.dequeue();
                        ++entries;

                    }

                    else if( inputs.getFront() < intList[i]){

                      intList[i] = inputs.dequeue();
                    }

                    //System.out.println("Compare listEntries: "+entries+" to queueLength:"+ lengthOfQueue);

                    if(intList.length == lengthOfQueue){
                        isFinished = true;
                        break;
                    }
                    else {

                        //System.out.println("(end of loop)...Now "+inputs.getFront()+ " is the new front");
                    } 
                }
                    catch(EmptyQueueException e) {

                        isFinished = true;
                        throw e;
                    }
                }

            }//end of while loop
        return intList;
    }    
}
