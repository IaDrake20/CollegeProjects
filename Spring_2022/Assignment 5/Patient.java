import java.text.DateFormat;
import java.util.Locale;

public class Patient{

    private String firstName;
    private String lastName;
    private int patientID;
    private DateFormat dateOfBirth;

    public Patient(){
        firstName = "";
        lastName = "";
        patientID = 0;
        dateOfBirth = null;
    }

    public Patient(String fn, String ln, int pID){
        firstName = fn;
        lastName = ln;
        patientID = pID;
        //TODO: add DoB(date of birth)
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getPatientID(){
        return patientID;
    }

    /*
    * TODO:build get for dateOfbirth
    */

    public void setFirstName(String fn){
        firstName = fn;
    }

    public void setLastName(String ln){
        lastName = ln;
    }

    public void setPatientID(int id){
        patientID = id;
    }

    //TODO:build get for set date of birth

}