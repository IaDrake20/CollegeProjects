package cs0048spring2022.assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentListDriver {

    public static void main(String[]args){

        Scanner readFile;
        ArrayList<Student> students = new ArrayList<>();
        Student tempStudent;
        File file = new File("StudentData.txt");

        try {
            readFile = new Scanner(new File("C:\\Users\\Ian of Drake\\Documents\\GitHub\\CollegeProjects\\Spring_2022\\Assignment 1- Reading from a .txt file\\cs0048spring2022\\assign1\\StudentData.txt"));
            
        } catch (FileNotFoundException e) {
                System.out.println("File not Found");
                e.printStackTrace();
                System.err.println(file.getAbsolutePath());
                System.exit(0);
        }
    }
}
