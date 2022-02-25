public class ERCase implements Comparable<ERCase>{

    private Patient patient;
    private int priority;

    private int timeWaiting;

    @Override
    public int compareTo(ERCase c) {
        if(this.getPriority() > c.getPriority()){
            return 1;
        }
        else if(this.getPriority() < c.getPriority()){
            return -1;
        }
        else if(this.getPriority() == c.getPriority()){
            return 0;
        }
        //should never reach this far
        return 78;
    }

    public ERCase(){
        patient = null;
        priority = 0;
        timeWaiting = 0;
    }

    /**
     * Patient pat
     * int number <--priority
     * int tw <-- Timewaiting
     */
    public ERCase(Patient pat, int number, int tW){
        patient = pat;
        priority = number;
        timeWaiting = tW;
    }

    public void setPatient(Patient pt){
        patient = pt;
    }
    
    public void setPriority(int p){
        priority = p;
    }
    public void setTimeWaiting(int tW){
        timeWaiting = tW;
    }

    public Patient getPatient(){
        return patient;
    }

    public int getPriority(){
        return priority;
    }

    public int getTimeWaiting(){
        return timeWaiting;
    }

    public String toString(){
        return patient.toString()+" |Priority: "+priority+" "+"|Time waiting: "+timeWaiting;
    }
}
