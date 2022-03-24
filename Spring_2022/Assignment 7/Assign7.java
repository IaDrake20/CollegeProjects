import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Assign7 {
    private static Player[][] playerMatrix = new Player[30][10]; 
    public static void main(String[] args) {
    System.out.println("Adding the players...");
    fillMatrix();
    System.out.println("Item at row 10, column 7 is\n" + playerMatrix[10][7]);
    // Prints the following
    // Reggie Bullock Team: DAL, Position: SF, Games Played: 57, MinsPG: 26.8
    // PtsPG: 8.2, RebsPG: 3.4, AsstsPG: 1.1, StsPG: 0.6, BlksPG: 0.2
    System.out.println("John Collins averages " + getMins("John Collins" ) + " minutes.");
    highestPPGInfo();
    System.out.println("Total number of games played by players in row 19 is " + totalGamesRow(19));
    System.out.println("Total number of games played by players in row 24 is " + totalGamesRow(24));
    System.out.println("List of players who have played more than 64 games is\n");
    System.out.println(moreThan(64).toString());
    lowestRebsPer36();
    }
    // Method to read the Player objects fom the file NBAData.dat and store
    // them in the playerMatrix 2D array
    // The data is stored as objects 
    // Use an ObjectInputStream to read in the objects one by one
    // and add them to the playerMatrix
    // Each object that is read must be cast to a Player object
    // You must handle FileNotFoundException (if NBAData.dat is not present)
    // and ClassNotFoundException (if Player class was not present)
    // and EOFException (which occurs when there are no more objects to be read
    // and IOException (for any other Input/Outout Exception)
    // You can just print something out if the exception occurs
    public static void fillMatrix() {
        //length of player matrix is 30
        ObjectInputStream oistream;
        Player nextPlayer = new Player();

        try {
            oistream = new ObjectInputStream(new FileInputStream("NBAData.dat"));
            for(int i = 0; i < 30; i++){
                for(int j = 0; j < 10; j++){
                    nextPlayer = (Player)oistream.readObject();
                    playerMatrix[i][j] = nextPlayer;
                    //System.out.println(playerMatrix[i][j]+" ");
                }
                //System.out.println("\n");
            }
            oistream.close();
        } catch (Exception e ){ //I use exception instead of specifying because it is simpler
            //e.printStackTrace();
        }
    }
    
    // Print the full name of the player who averages the highest PPG
    // and the row and column in which that player located 
    public static void highestPPGInfo() {
        int row, column;
        row = 0;
        column = 0;
        double pastPPG = 0.0;
        boolean breakout = false;

        for(int i = 0; i < 30; i++){
            if(breakout){
                break;
            }
            row = i;
            for(int j = 0; j < 10; j++){

                if(playerMatrix[i+1][j] == null){
                    column = j;
                    System.out.println("Row: "+row+" Column: "+column+" Name: "+playerMatrix[i][j].getFirstName()+" "+playerMatrix[i][j].getLastName());
                    breakout = true;
                    break;
                }

                double ppg = playerMatrix[i][j].getPoints();// / playerMatrix[i][j].getGamesPlayed();
                
                if(ppg < pastPPG){
                    ppg = pastPPG;
                }
                else {
                    pastPPG = ppg;
                }
            }
        }
    }
    // Method to calculate the total number of games played by all players in row r
    public static int totalGamesRow(int r) {
        int numGames = 0;
            for(int j = 0; j < 10; j++){//column
                try{
                    numGames =+ playerMatrix[r][j].getGamesPlayed();
                } catch(Exception e){
                }
            }
        return numGames;
    }
    // Method to return minutes for a player
    public static double getMins(String name) {
        double minutes = 0;
        for(int i = 0; i < playerMatrix.length; i++){
            for(int j = 0; j < playerMatrix[i].length; j++){
                String playerName = playerMatrix[i][j].getFirstName()+" "+playerMatrix[i][j].getLastName();
                if(name.equals(playerName)){
                    minutes = playerMatrix[i][j].getMinutes();
                    return minutes;
                }                
            }
        }
        return minutes;
    }
    // Return players who have played more than a certain number of games
    // Return player names in an ArrayList<String>
    public static ArrayList<String> moreThan(int limit) {
        ArrayList<String> arrayListOfPLayers = new ArrayList<>();
        for(int i = 0; i < 30; i++){
            try {
                for(int j = 0; j < 10; j++){
                    if(playerMatrix[i][j].getGamesPlayed() > limit){
                        arrayListOfPLayers.add(playerMatrix[i][j].getFirstName()+" "+playerMatrix[i][j].getLastName().toString());
                    }
                }
            } catch(Exception e){
            }
        }
        return arrayListOfPLayers;
    }
    // Print full name of player who has the lowest number of rebounds per 36 minutes
    // and the number of rebounds per 36 minutes
    //(rebounds * 36) / timePlayed
    public static void lowestRebsPer36() {
        
        double secondLowestRebsPlayer = 0.0;
        boolean breakOut = false;
        Player player = new Player();
        double calculation = 0.0;

        for(int i = 0; i < 30; i++){
            if(breakOut){
                break;
            }
            for(int j = 0; j < 10; j++){

                //Been having an issue with the array trying to reach indexes outside of its alotted amount
                //so this will keep it honest. After testing it seems to work.
                if(playerMatrix[i+1][j] == null){
                    breakOut = true;
                    break;
                }

                calculation = (playerMatrix[i][j].getRebounds() * 36) / playerMatrix[i][j].getMinutes();
                double lowestRebsPlayer = calculation;

                if(lowestRebsPlayer < secondLowestRebsPlayer){
                    lowestRebsPlayer = secondLowestRebsPlayer;
                    player = playerMatrix[i][j];
                }
                else {
                    secondLowestRebsPlayer = lowestRebsPlayer;
                }
            }

        }

        System.out.println(player.getFirstName()+" "+player.getLastName()+" has "+calculation+" for the lowest number of rebounds per 36 minutes.");
    }
}