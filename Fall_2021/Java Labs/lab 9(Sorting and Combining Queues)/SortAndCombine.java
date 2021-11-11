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

        //ask for input
        System.out.println("Please enter a sequence of integers...");
        s = input.nextLine();

        sT = new StringTokenizer(s);

        //assign values to intUserInputs from tokens
        while(sT.hasMoreTokens()){
            intUserInputs.enqueue(Integer.parseInt(sT.nextToken()));
            ++queueLength;
        }

        int[] intList = new int[queueLength +1];//just in case
        int listEntries = 0;//track how many entries are held 

        

        while (!isFinished) {
            
            //sort to arrange low to high
            for (int i = 0; i < queueLength-1; i++){ 

                try {
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

                    System.out.println("Compare listEntries: "+listEntries+" to queueLength:"+ queueLength);

                    if(intList.length == queueLength){
                        isFinished = true;
                        break;
                    }
                    else {

                        System.out.println("(end of loop)...Now "+intUserInputs.getFront()+ " is the new front");

                    }
                    } 
                    catch(EmptyQueueException e){

                        System.out.println("queue is empty");
                        isFinished = true;
                        break;
                }
            }
        }
    }

    //I don't think I need to loop for this, just move things over.
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
