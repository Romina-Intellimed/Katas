import java.util.List;
import java.util.Random;

/**
 * Created by Romina DRUTA on 20.01.2016.
 */
public class TennisKataTools {


    static Random randomlyPlayerSelector=new Random();
    static Player noWinner=new Player("No winner");

    static Player randomPlayer(List<Player> playersList){
        Player randomPlayer=playersList.get(randomlyPlayerSelector.nextInt(playersList.size()));
        return randomPlayer;
    }


    static String isWinTheBall(Boolean ballState){
        if(ballState){
            return "Wins the ball";
        }
        else
            return "Lost the ball";
    }


}
