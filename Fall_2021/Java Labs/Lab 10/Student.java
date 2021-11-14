

public class Student{

    private int studentAge;
    private String studentName;
    private double studentGPA;

    public Student() {

        studentAge = 0;
        studentName  = "";
        studentGPA = 0.0;
    }

    public Student(int age, double gpa, String name){

        studentAge = age;
        studentGPA = gpa;
        studentName = name;
    }

    public int getAge() {

        return studentAge;
    }

    public double getGPA(){

        return studentGPA;
    }

    public String getName() {

        return studentName;
    }

    public void setAge(int age) {
        studentAge = age;
    }

    public void setGPA(double gpa){
        studentGPA = gpa;
    }

    public void setName(String name){
        studentName = name;
    }

    public String toString(){
        return "Name: "+studentName+ " Age: "+studentAge +" GPA: "+studentGPA;
    }
}