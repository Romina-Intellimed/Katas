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

    String setBallWinner(Player player){
        if(players.contains(player)) {
            player.hasScored();
        }

        return player.getName();

    }



    void updateGameState(){
        if(getGameWinner()!=null)
            state="END";
        else
        if(players.get(0).score==4 && players.get(1).score==4)
            state="DEUCE";
    }


    Player getGameWinner(){

        if(players.get(0).getScore()==4 && players.get(0).getScore()>=players.get(1).getScore()+2)
            return players.get(0);
        if(players.get(1).getScore()==4 && players.get(1).getScore()>=players.get(0).getScore()+2)
            return players.get(1);

        return null;
    }





}
