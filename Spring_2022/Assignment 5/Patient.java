import java.text.DateFormat;

public class Patient{

    private String firstName;
    private String lastName;
    private int patientID;
    //date of birth

    public Patient(){
        firstName = "";
        lastName = "";
        patientID = 0;

    }

    public Patient(String fn, String ln, int pID){
        firstName = fn;
        lastName = ln;
        patientID = pID;
        //TODO: add DoB(date of birth)
    }
}