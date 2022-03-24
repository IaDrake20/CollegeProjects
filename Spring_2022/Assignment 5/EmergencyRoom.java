import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

import java.util.Scanner;

public class EmergencyRoom {
    static Scanner read; 
    static File data = new File("C:\\Users\\Ian of Drake\\Documents\\GitHub\\CollegeProjects\\Spring_2022\\Assignment 5\\PatientData.txt");
    static {
        try {
            read = new Scanner(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int genPatients(){
        //randomly generate 0-3 new cases each cycle 
        switch((int)(Math.random()*10)){
            case 0:
            case 1: //generate 0 cases
                //System.out.println("generated 0 patients");
                break;
            case 2:
            case 3:
            case 4: //generate 1 case
                //this.readFile(1);
                //System.out.println("generated 1 patient");
                return 1;
            case 5:
            case 6: 
            case 7: //generate 2 cases
                //this.readFile(2);
                //System.out.println("generated 2 patients");
                return 2;
            case 8:
            case 9: //gen 3 cases
                //this.readFile(3);
                //System.out.println("generated 3 patients");
                return 3;
            default: return 0;
        }

        //shuold never get this far
        return 0;
    }

    public int patientsSeen(){
        
        int numberSeen = 0;
        //multiply by 100 to use ints to check if people are seen or not
        int checkMe = (int)(Math.random() * 100);
        if(checkMe <= 25){ //0 patients seen
            numberSeen = 0;
            //System.out.println("Seen 0 patients");

        } else if(checkMe > 25 && checkMe <= 75){ //1 pateint seen
            numberSeen = 1;
            //System.out.println("Seen 1 patient");

        } else if(checkMe > 75){ //two patients seen
            numberSeen = 2;
            //System.out.println("Seen 2 patients");
        }

        return numberSeen;
    }

    public PriorityQueue<ERCase> addressTimeWait(int tw, PriorityQueue<ERCase> pq){
        PriorityQueue<ERCase> temp = new PriorityQueue<>();
        for(int i = 0; i < pq.size(); i++){
                pq.peek().setTimeWaiting(tw);
                temp.add(pq.remove());
            }
        pq = temp;
        return pq;
    }

    public PriorityQueue<ERCase> addNewPatients(PriorityQueue<ERCase> pq1, PriorityQueue<ERCase> pq2){
        for(int i = 0; i < pq2.size(); i++){
            pq1.add(pq2.remove());
        }

        return pq1;
    }

    /**
     * produce a PQ
     */
    public PriorityQueue<ERCase> readFile(int numberOfPatients){
        PriorityQueue<ERCase> myPQ = new PriorityQueue<ERCase>();
        ERCase erC = new ERCase();
        Patient pt = new Patient();
        int i = 1;
        String[] s_Arr;


        try {
            //firstName, lastName, patientID, year, month, day, priority will be copied from data into objects in this order
            while(read.hasNext() && i <= numberOfPatients){
                erC = new ERCase();//reset
                pt = new Patient();
                s_Arr = read.nextLine().split(", ");
                pt.setFirstName(s_Arr[0]);
                pt.setLastName(s_Arr[1]);
                pt.setPatientID(Integer.parseInt(s_Arr[2]));
                pt.setDateOfBirth(Integer.parseInt(s_Arr[5]), Integer.parseInt(s_Arr[4]), Integer.parseInt(s_Arr[3]));
                erC.setPriority(Integer.parseInt(s_Arr[6]));

                //plug in object
                erC.setPatient(pt);

                //System.out.println("Trying to add patient......."+ erC.toString());


                //check for errors and remove erroneous cases
                if(checkForErrors(erC)){
                    erC = null;
                }
                else {

                    //Now that everything is clear, add to Pqueue
                    myPQ.add(erC);
                }

                ++i;
            }
        } catch(Exception e){

        }
        return myPQ;
    }

    public void printValues(PriorityQueue<ERCase> foo){
        System.out.println("--------------------PRINTING VALUES OF PQ------------------------");
        System.out.println(Arrays.toString(foo.toArray()));
        System.out.println("\n");
    }

    public PriorityQueue<ERCase> incrementWaitTime(PriorityQueue<ERCase> pq){
        ERCase tempErC;
        PriorityQueue<ERCase> tempPQ = pq;
        int cycles = pq.size();
        for(int i = 0; i < cycles; i++){
            tempErC = pq.remove();
            tempErC.incrementTimeWaiting(1);
            tempPQ.add(tempErC);
        }

        return tempPQ;
    }

    public double printAvgTimeWaited(PriorityQueue<ERCase> foo){
        double avg = 0.0;
        int totalPatients = 0;
        ERCase temp;
        for(int i = 0; i < foo.size(); i++){
            temp = foo.remove();
            avg += temp.getTimeWaiting();
            ++totalPatients;
        }
        return (avg/totalPatients);
    }

    //check the date of birth object for issues
    public boolean checkForErrors(ERCase erc){
        if(erc.getPatient().getDateOfBirth().getHasError()){
            System.out.println("This ER case had a clerical error, data will be removed.");
            System.out.println("Case is: "+erc.toString());
            return true;
        }
        return false;
    }

    public static void main(String[]args){
        EmergencyRoom er = new EmergencyRoom();

        //give pq 5 patients from PatientData
        PriorityQueue<ERCase> pq = er.readFile(5);

        try {
            //run 10 iterations
            for(int i = 0; i < 10; i++){

                //debugging
                //System.out.println("\n\n\nBefore::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                //er.printValues(pq);
                
                //potentially get new patients
                int numPatients = er.genPatients();
                er.addNewPatients(pq, er.readFile(numPatients));
                //pq.addAll(er.readFile(numPatients));

                //debugging
                //System.out.println("\n\n\nDuring::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                //er.printValues(pq);

                //see patients
                int numSeen = er.patientsSeen();
                for(int j = 0; j < numSeen; j++){
                    System.out.println("Removing"+ pq.remove());
                }

                //debugging
                //System.out.println("Size: "+pq.size());
                //er.printValues(pq);

                //System.out.println("\n\n\nAfter::::::::::::::::::::::::::::::::::::::::::::::::::::::");

                //print out the array queue's contents
                er.printValues(pq);


                System.out.println("Continue? Y/N");
                Scanner b = new Scanner(System.in);
                String foo = b.next();
                if(foo == "N"){

                    //for loop will check i and find it greater than 10, thus exiting the loop
                    i = 20;
                }
            }
        } catch(NoSuchElementException e){
            System.out.println("All patients were seen, leaving cycle early");
        }//end of first simulation

        //clear and reset
        er = new EmergencyRoom();
        pq = null;
        pq = er.readFile(5);

        //this will not count the base 5 we started with since they are already in the ER
        int patientsArrived = 0;
        int patientsSeen = 0;

        try {
            //simulation 2
        for(int i = 0; i < 75; i++){

            //potentially get new patients
            int numPatients = er.genPatients();
            patientsArrived += numPatients;
            er.addNewPatients(pq, er.readFile(numPatients));

            //see patients
            int numSeen = er.patientsSeen();
            for(int j = 0; j < numSeen; j++){
                try {
                    if(pq.remove() != null){
                    
                        //increment patients seen
                        ++patientsSeen;
                    }
                } catch( NoSuchElementException e){
                }
            }

            er.incrementWaitTime(pq);

        }
    } catch(ArrayIndexOutOfBoundsException e){
        System.out.println("No more patient data is available.");
            
    }

        //print patients arrived
        System.out.println("Total patients that arrived: "+patientsArrived);
        //print patients seen
        System.out.println("Total patients that were seen: "+patientsSeen);
        //print avg wait time
        System.out.println("The avg wait time is: "+er.printAvgTimeWaited(pq));
        }
    
}
