import java.io.Serializable;
public class Player implements Serializable{
    private String lastName;
    private String firstName;
    private String position;
    private String team;
    private int gamesPlayed;
    private double minutes;
    private double points;
    private double rebounds;
    private double assists;
    private double steals;
    private double blocks;

    public Player() {
    }

    public Player(String f, String l, String t, String p, int gp, double mins, double pts, double rebs, double a, double s, double b) {
        lastName = l;
        firstName = f;
        team = t;
        position = p;
        gamesPlayed = gp;
        minutes = mins;
        points = pts;
        rebounds = rebs;
        assists = a;
        steals = s;
        blocks = b;
    }

    public Player(Player player) {
        lastName = player.lastName;
        firstName = player.firstName;
        position = player.getPosition();
        team = player.getTeam();
        gamesPlayed = player.getGamesPlayed();
        minutes = player.getMinutes();
        points = player.getPoints();
        rebounds = player.getRebounds();
        assists = player.getAssists();
        steals = player.getSteals();
        blocks = player.getBlocks();
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String l) {
        lastName = l;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String f) {
        firstName = f;
    }
    public String getPosition() {
        return position;
    }
    public String getTeam() {
        return team;
    }
    public int getGamesPlayed() {
        return gamesPlayed;
    }
    public double getMinutes() {
        return minutes; 
    }
    public double getPoints() {
        return points;
    }
    public double getRebounds() {
        return rebounds;
    }
    public double getAssists() {
        return assists;
    }
    public double getSteals() {
        return steals;
    }
    public double getBlocks() {
        return blocks;
    }
    public boolean equals(Player player) {
        if (lastName.equals(player.getLastName()) &&firstName.equals(player.getFirstName()) && team.equals(player.getTeam()) && 
        position.equals(player.getPosition()) && gamesPlayed == player.getGamesPlayed() && minutes == player.getMinutes() && 
        points == player.getPoints() && rebounds == player.getRebounds() && assists == player.getAssists() && 
        steals ==  player.getSteals() && blocks == player.getBlocks())
            return true;
        else
            return false;
        }  
    public String toString() {
        return (firstName + " " + lastName + " Team: " + team + ", Position: " + position + ", Games Played: " + gamesPlayed + ", MinsPG: " + minutes + "\nPtsPG: " + points + ", RebsPG: " + rebounds + ", AsstsPG: " + assists + ", StsPG: " + steals + ", BlksPG: " + blocks);
    }
}