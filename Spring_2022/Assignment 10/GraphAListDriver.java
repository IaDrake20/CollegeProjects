import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class GraphAListDriver {
    
    public static void main(String[] args){

        File test1 = new File("myTestData.txt");
        //File input1 = new File("GraphA.txt");
        //File input2 = new File("GraphB.txt");

        int[][] edgeArray;
        ArrayList<LinkedList<Integer>> edgeList;
        //int[][] testGraph = new int[20][20];


        Scanner readFile;
        //Scanner readGraphA;
       // Scanner readGraphB;

        GraphAList testInput = new GraphAList(0, 0);
        //GraphAList testGraph1 = new GraphAList(0, 0);
        //GraphAList testGraph2 = new GraphAList(0, 0);

        try {
            readFile = new Scanner(test1);
            int numV = readFile.nextInt();
            int numE = readFile.nextInt();

            edgeArray = new int[numV][numV];
            edgeList = new ArrayList<LinkedList<Integer>>();
            testInput = new  GraphAList(numV, numE);

            //read in graph as a 2d array that holds int 
            for(int row = 0; row < numV; row++){
                for(int column = 0; column < numV; column++){
                    int currentVal = readFile.nextInt();
                    if(currentVal == 0){
                        edgeArray[row][column] = 0;
                    } else {
                        edgeArray[row][column] = 1;
                    }
                }
            }

            //turn 2d array into edgelist
            for(int row = 0; row < numV; row++){
                for(int column = 0; column < numV; column++){
                    int rowVal = row;
                    int columnVal = column;
                    int currentVal = edgeArray[row][column];
                    if(currentVal == 0){
                        //TODO: index out of bounds exception, issue with the method
                        //testInput.removeEdge(rowVal, columnVal);
                    } else {
                        testInput.addEdge(rowVal, columnVal);
                    }
                }
            }
            
            //readGraphA = new Scanner(input1);
           // testGraph1 = new GraphAList(readGraphA.nextInt(), readGraphA.nextInt());
           /// readGraphB = new Scanner(input2);
           // testGraph2 = new GraphAList(readGraphB.nextInt(), readGraphB.nextInt());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }


        System.out.println("Printing from main\n"+testInput.toString());
        //System.out.println(testGraph1.toString());
       // System.out.println(testGraph2.toString());
        //read in 
        //first num is rows
        //second num is columns
        //print graph://output prints edges
        //System.out.println(testInput.toString());

        //Call BFS that will print the edges traversed and resulting order of vertices visited.
        testInput.BFS();

        //Call DFS that will print the edges traversed and resulting order of vertices visited.
        testInput.DFS();

    }
}
