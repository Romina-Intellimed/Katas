import java.util.ArrayList;

/**
 * Created by romina on 28.01.2016.
 */
public class Game {

    ArrayList<Player> players;
    String state;
    Player player1;
    Player player2;


    Game() {
        players = new ArrayList<>();
        player1=new Player("player1");
        player2=new Player("player2");

        players.add(player1);
        players.add(player2);
        state = "START";

    }

    void run() {
        //todo
        state = "PLAYING";
       while(state!="END" ){

            updateGameState();

        }



    }

    void playerScores(Player player){
        if(players.contains(player)) {
            player.hasScored();
        }
    }



    void updateGameState(){
        if(getGameWinner()!=null)
            state="END";
        else
        if(players.get(0).score==4 && players.get(1).score==4)
            state="DEUCE";
        else {
            state = "PLAYING";
            playerScores(player1);

        }

    }


    Player getGameWinner(){

        if(players.get(0).getScore()==4 && players.get(0).getScore()>=players.get(1).getScore()+2)
            return players.get(0);
        if(players.get(1).getScore()==4 && players.get(1).getScore()>=players.get(0).getScore()+2)
            return players.get(1);

        return null;
    }





}
