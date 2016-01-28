import java.util.ArrayList;

/**
 * Created by romina on 28.01.2016.
 */
public class Game {

    ArrayList players;
    String state;


    Game() {
        players = new ArrayList<>();
        String player1 = "player1";
        String player2 = "player2";

        players.add(player1);
        players.add(player2);
        state = "START";

    }


    Boolean onePassTheBall(String player){


        return true;

    }



}
