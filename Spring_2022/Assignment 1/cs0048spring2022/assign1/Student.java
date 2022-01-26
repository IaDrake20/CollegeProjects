package cs0048spring2022.assign1;
public class Student {

    private String firstName;
    private String lastName;
    private double gpa;
    private int age;

    /**
     * creates a student object and sets constructor parameters to default values.
     */
    public Student(){
        firstName = "";
        lastName = "";
        gpa = 0.0;
        age = 0;
    }

    /**
     * creates a student object with user specified values
     * @param fn-String firstname
     * @param ln-String lastname
     * @param yearsLived - int age
     * @param gradePointAverage - double gpa
     */
    public Student(String fn, String ln, int yearsLived, double gradePointAverage) {

        firstName = fn;
        lastName = ln;
        gpa = gradePointAverage;
        age = yearsLived;
    }

    /**
     * Set the student's first name to the string
     * @param Fn
     */
    public void setFirstName(String Fn){
        firstName = Fn;
    }

    /**
     * Set the stduent's lastname to the string
     * @param lN
     */
    public void setLastName(String lN){
        lastName = lN;
    }

    /**
     * Set a student's gpa to the number
     * @param num
     */
    public void setGpa(double num){
        gpa = num;
    }

    /**
     * Set a student's age to the number
     * @param num
     */
    public void setAge(int num){
        age = num;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public double getGpa(){
        return gpa;
    }

    public int getAge(){
        return age;
    }

    public String toString(){
        return "First Name: "+firstName+"... Last name: "+lastName+"... GPA: "+gpa+"... Age: "+age;
    }
}
