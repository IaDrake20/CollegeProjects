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

        try {
            readFile = new Scanner(new File("StudentData.txt"));

            //this should go to the next line and get the necessary input
            tempStudent = new Student(readFile.nextLine(), readFile.next(), readFile.nextInt(), readFile.nextDouble());
            students.add(tempStudent);


        } catch (FileNotFoundException e) {
                System.out.println("File not Found");
                e.printStackTrace();
                System.exit(0);
        }
    }
}
