import java.util.Scanner;
import java.util.StringTokenizer;

public class SortAndCombine {

    public static void main(String[]args){
        
        ArrayQueue <Integer> intUserInputs = new ArrayQueue <Integer>();
        ArrayQueue <Integer> intUserInputs2 = new ArrayQueue <Integer>();

        Scanner input = new Scanner(System.in);
        String s = ""; //rename to something more appropriate
        StringTokenizer sT = new StringTokenizer(s);

        boolean isFinished = false;

        int[] intList = new int[50];

        int highestNumber = 0;

        //ask for input
        System.out.println("Please enter a sequence of integers...");
        s = input.nextLine();

        while (!isFinished) {
            //convert to int
            int currentToken = Integer.valueOf(sT.nextToken());
            
            //sort to arrange low to high
            if(currentToken > intUserInputs.getFront()){
                int temp = intUserInputs.dequeue();
                intUserInputs.enqueue(currentToken);
                intUserInputs.enqueue(temp);
            }

            for (int i = 0; i != 10; i++){ //replace 10 with algorithm

                if(currentToken >= intUserInputs.getFront()){
                        intList[i] = intUserInputs.dequeue();
                }

                else if( intUserInputs.getFront() == null){

                    intUserInputs.enqueue(currentToken);

                    for(int j = 0; intUserInputs.getFront() != null; j++){

                    }
                }
            }
        }
    }

    private int sort(String s, StringTokenizer sT){

        boolean isFinished = false;

        while(!isFinished){

            break;
            //if( )
        }

        return -1;
    }
    
}
