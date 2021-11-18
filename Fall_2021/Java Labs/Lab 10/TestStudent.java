

public class TestStudent {

    public static void main(String[]args){

        AList <Student> myAList = new AList <Student> (25);

        Student currentStudent = new Student(18, 3.45, "Joe Smith");
        myAList.add(currentStudent);

        currentStudent = new Student(19, 2.95, "Jen Brown");
        myAList.add(currentStudent);

        currentStudent = new Student(20, 3.23, "Jane Green");
        myAList.add(currentStudent);

        currentStudent = new Student(19, 2.06, "Jerry Black");
        myAList.add(currentStudent);

        currentStudent = new Student(19, 3.88, "Jo Blue");
        myAList.add(currentStudent);

        try {
            //delete student at position 3
            myAList.remove(3);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("The index specified is not there.");
        }

        //add new student Kate Poole to the list pos 2
        currentStudent = new Student(20, 4.0, "Kate Poole");
        myAList.add(2, currentStudent);


        //replace first student on list with John Black and his info
        currentStudent = new Student(22, 3.32, "John Black");
        myAList.replace(1, currentStudent);

        //swap students position 2 and 5
        Student tempStudent = myAList.getEntry(2);
        
        //set pos 5 to pos 2
        myAList.replace(2, myAList.getEntry(5));

        //set pos 5 to temp
        myAList.replace(5, tempStudent);

        //change age of 4th student to 21
        tempStudent = myAList.getEntry(4);
        tempStudent.setAge(21);

        tempStudent = myAList.getEntry(myAList.getLength());
        tempStudent.setName("Sandy Last");

        //print list one student per line
        System.out.println("----------------------------------------------------------------------");
        for(int i = 0; i < myAList.getLength(); i++){
            currentStudent = myAList.getEntry(i+1);
            System.out.print(currentStudent.toString()+"\n");//.toString();
        }
        System.out.println("----------------------------------------------------------------------");

    }
}
