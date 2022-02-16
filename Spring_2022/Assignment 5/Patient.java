import java.text.DateFormat;
import java.util.Locale;

public class Patient{

    public class birthDate{
        private int day;
        private int month;
        private int year;

        public birthDate(int d, int mon, int y){
            day = d;
            month = mon;
            year = y;
        }

        public birthDate(){
        }

        public void setDay(int d){
            day = d;
        }
        public void setMonth(int m){
            month = m;
        }
        public void setYear(int y){
            year = y;
        }
        public int getDay(){
            return day;
        }
        public int getMonth(){
            return month;
        }
        public int getYear(){
            return year;
        }
    }

    private String firstName;
    private String lastName;
    private int patientID;
    private birthDate dateOfBirth;

    public Patient(){
        firstName = "";
        lastName = "";
        patientID = 0;
        dateOfBirth = null;
    }

    public Patient(String fn, String ln, int pID, birthDate dOB){
        firstName = fn;
        lastName = ln;
        dateOfBirth = dOB;
        
        String s_patID = pID + "";
        if(s_patID.charAt(0) == 0){
            System.out.println("Error: Patient ID starts with 0.");
            this.firstName = null;
            this.lastName = null;
            this.patientID = 0;
            this.dateOfBirth = null;

        }
        patientID = pID;
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

    public birthDate getDateOfBirth(){
        return dateOfBirth;
    }

    public void setFirstName(String fn){
        firstName = fn;
    }

    public void setLastName(String ln){
        lastName = ln;
    }

    public void setPatientID(int id){
        patientID = id;
    }

    public void setDateOfBirth(birthDate bd){
        dateOfBirth.setDay(bd.getDay());
        dateOfBirth.setMonth(bd.getMonth());
        dateOfBirth.setYear(bd.getYear());
    }

}