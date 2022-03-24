
public class Patient{

    public static class birthDate{
        boolean hasError = false;
        private int day;
        private int month;
        private int year;

        public birthDate(int d, int mon, int y){
            day = d;
            if(d >31){
                hasError = true;
            }
            month = mon;
            if(mon > 12){
                hasError = true;
            }
            year = y;
            if(y < 0){
                hasError = true;
            }
        }

        public birthDate(){
        }

        public void setDay(int d){
            if(d > 31){
                hasError = true;
                //System.out.println("Error in assiginng day");
            }
            day = d;
            //System.out.println("Day set to "+d);
        }
        public void setMonth(int m){
            if(m > 12){
                hasError = true;
                //System.out.println("Error in assiginng month");
            }
            month = m;
            //System.out.println("month set to "+m);
        }
        public void setYear(int y){
            if(y < 0){
                hasError = true;
                //System.out.println("Error in assiginng year");
            }
            year = y;
            //System.out.println("year set to "+y);
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

        public boolean getHasError(){
            return hasError;
        }

        public String toString(){
            return +getYear()+"-"+getMonth()+"-"+getDay();
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
        dateOfBirth = new birthDate(0, 0, 0);
    }

    public Patient(String fn, String ln, int pID, birthDate dOB){
        firstName = fn;
        lastName = ln;
        dateOfBirth = dOB;
        
        String s_patID = pID + "";
        if(s_patID.charAt(0) == 0){
            System.out.println("Error: Patient ID starts with 0.");
            this.firstName = "";
            this.lastName = "";
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

    public void setDateOfBirth(int d, int m, int y){
        dateOfBirth.setDay(d);
        dateOfBirth.setMonth(m);
        dateOfBirth.setYear(y);
    }

    
    public String toString(){
        birthDate bd = new birthDate(this.getDateOfBirth().getDay(), this.getDateOfBirth().getMonth(), this.getDateOfBirth().getYear()); 
        return firstName+", "+lastName+" "+patientID+" "+ bd.toString();
    }
    
}