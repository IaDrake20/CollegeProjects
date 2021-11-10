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

        boolean isFinished = false;

        int[] intList = new int[50];
        int listEntries = 0;


        //ask for input
        System.out.println("Please enter a sequence of integers...");
        s = input.nextLine();

        sT = new StringTokenizer(s);

        while(sT.hasMoreTokens()){
            intUserInputs.enqueue(Integer.parseInt(sT.nextToken()));
            ++queueLength;
        }

        

        while (!isFinished) {

            //convert to int
            //int currentToken = Integer.valueOf(sT.nextToken());
            
            //sort to arrange low to high
            for (int i = 0; i < queueLength-1; i++){ 

                System.out.println("Currently "+intUserInputs.getFront()+" is in front of the queue");

                if(i == 0){

                    intList[0] = intUserInputs.dequeue();
                    ++listEntries;
                }

                if(intUserInputs.getFront() >= intList[i]){

                    System.out.println(":::::::::place "+intUserInputs.getFront()+ " into the intList");
                    makeRoom(i, intList);
                    intList[i] = intUserInputs.dequeue();
                    ++listEntries;

                }
                else if( intUserInputs.getFront() < intList[i]){

                    intList[i] = intUserInputs.dequeue();
                }

                System.out.println("Compare "+listEntries+" to "+ queueLength);

                if(intList.length == queueLength){
                    isFinished = true;
                    break;
                }

                try{
                    System.out.println("(end of loop)...Now "+intUserInputs.getFront()+ " is the new front");
                } catch(EmptyQueueException e){

                }
            }
        }
    }

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
    
}
