public class NBAPlayer {
    private String playerName = "";
    private String playerCollege = "";
    private String playerCountry = "";
    private int playerDraftYear = 0;
    private int playerDraftRound = 0;
    private int playerDraftTable;

    public NBAPlayer(){
    }

    public NBAPlayer(String fullName, String college, String country, int draftYear, int draftRnd, int draftTbl){

        playerName = fullName;
        playerCollege = college;
        playerCountry = country;
        playerDraftYear = draftYear;
        playerDraftRound = draftRnd;
        playerDraftTable = draftTbl;
    }

    public void setName(String nm){
        playerName = nm;
    }

    public void setCollege(String col){
        playerCollege = col;
    }

    public void setCountry(String country){
        playerCountry = country;
    }

    public void setDraftYear(int draftY){
        playerDraftYear = draftY;
    }

    public void setDraftround(int draftR){
        playerDraftRound = draftR;
    }

    public void setDraftTable(int draftT){
        playerDraftTable = draftT;
    }

    public String getName(){
        return playerName;
    }
    public String getCollege(){
        return playerCollege;
    }
    public String getCountry(){
        return playerCountry;
    }
    public int getDraftYear(){
        return playerDraftYear;
    }
    public int getDraftRound(){
        return playerDraftRound;
    }
    public int getDraftTable(){
        return playerDraftTable;
    }
}