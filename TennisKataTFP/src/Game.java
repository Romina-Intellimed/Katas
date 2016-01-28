import java.util.ArrayList;

/**
 * Created by romina on 28.01.2016.
 */
public class Game {

    ArrayList<Player> players;
    String state;


    Game() {
        players = new ArrayList<>();
        Player player1=new Player("player1");
        Player player2=new Player("player2");

        players.add(player1);
        players.add(player2);
        state = "START";

    }


    String chooseWhoPassTheBall(String player){


        return player;

    }

    String setBallWinner(String player){

        return player;

    }




}
