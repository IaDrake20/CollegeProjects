package cs0048spring2022.assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentListDriver {

    static File file = new File("C:\\Users\\Ian of Drake\\Documents\\GitHub\\CollegeProjects\\Spring_2022\\Assignment 1\\StudentData.txt");
    static Scanner readFile;

    static {
        try {
            readFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[]args) throws FileNotFoundException {

        Iterator myIterator = studentList.listIterator();

        studentList = readData();
        readFile.close();

        System.out.println("Number of Students is " +studentList.size());

        System.out.println("The student at index 100 is..."+studentList.get(100).toString());

        System.out.println("Print and remove the student at index 57");
        printStudents(57,57);
        studentList.remove(57);

        System.out.println("Print how many students have a GPA among 3 and 4");
        System.out.println("The number of students is "+countBetween(3.0, 4.0));

        System.out.println("Print the student names only of those whom have a GPA among 2.5 and 3");
        printNamesBetween(2.5, 3.0);

        System.out.println("Delete student record with name of Todd Novak");
        deleteName("Todd", "Novak");

        System.out.println("Print students from index 100 to end");
        printStudents(100, 119);
    }

   public static ArrayList<Student> readData(){
        ArrayList<Student> myList = new ArrayList<>();
        Student st;

       do {
           st = new Student(readFile.next(), readFile.next(), readFile.nextInt(), readFile.nextDouble());
           myList.add(st);
       } while (readFile.hasNext());
       return myList;
    }

    public static int countBetween(double lowerGPA, double higherGPA){
        int count = 0;
        Iterator it = studentList.listIterator();

        for (int i = 0; it.hasNext(); i++) {
            double currGPA = studentList.get(i).getGpa();
            if (currGPA >= lowerGPA && currGPA <= higherGPA) {
                count++;
            }
            it.next();
        }
        return count;
    }

    public static void printNamesBetween(double lowerGPA, double higherGPA){
        Iterator it = studentList.listIterator();
        for (int i = 0; it.hasNext(); i++) {
            double currGPA = studentList.get(i).getGpa();
            if (currGPA >= lowerGPA && currGPA <= higherGPA) {
                System.out.println(studentList.get(i).getFirstName() + " " + studentList.get(i).getLastName());
            }
            it.next();
        }
    }

    public static String deleteName(String fn, String ln){
        String deletedName = "";
        ArrayList<Student> temp = studentList;
        Iterator<Student> it = studentList.listIterator();
        while(it.hasNext()){//for (int i = 0; it.hasNext(); i++) {
            Student val = it.next();
           if(val.getFirstName().equalsIgnoreCase(fn) && val.getLastName().equalsIgnoreCase(ln)){
               deletedName = val.getFirstName() +" "+val.getLastName();
               it.remove();
               System.out.println("Removed the student.");
               break;
            }
        }
        return deletedName;
    }

    public static void printStudents(int lowerIndex, int upperIndex){
        for(int i = 0; i < studentList.size(); i++){
            if(i >= lowerIndex && i <= upperIndex ) {
                System.out.println(studentList.get(i).toString());
            }
        }
    }
}
