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
       // playerScores(player1);
      //  playerScores(player2);

            updateGameState();

        }



    }

    void playerScores(Player player){
        if(players.contains(player)) {
            player.winsTheBall=true;
            player.hasScored();
        }
    }



    void updateGameState(){
        if(getGameWinner()!=null) {
            state = "END";
        }
        else
        if(players.get(0).score==4 && players.get(1).score==4 && !isAdvantage()) {
            state = "DEUCE";
        }
        else
            if(isAdvantage()){
                state = "ADVANTAGE";
            }
        else {
            state = "PLAYING";
            //playerScores(player1);

        }

    }

    private boolean isAdvantage() {
        return players.get(0).score==4 && players.get(1).score==4 && (players.get(0).winsTheBall==true || players.get(1).winsTheBall==true);
    }

    void updatePlayersAdvantageState(Player player){
        player.hasAdvantage=true;
       // player.winsTheBall=false;
        for(Player p: players){
            if(p!=player){
                p.hasAdvantage=false;
                p.winsTheBall=false;
            }
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
