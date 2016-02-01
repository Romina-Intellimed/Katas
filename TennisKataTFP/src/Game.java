import java.util.ArrayList;

/**
 * Created by romina on 28.01.2016.
 */
public class Game {

    ArrayList<Player> players;
    String state;
    Player player1;
    Player player2;
    Player winner;
    Player looser;

    Game() {
        players = new ArrayList<>();
        player1 = new Player("player1");
        player2 = new Player("player2");

        players.add(player1);
        players.add(player2);
        state = "START";

    }

    void run() {
        state = "PLAYING";
        playerOneWinsTheBall();
        playerOneWinsTheBall();
        playerOneWinsTheBall();
        playerOneWinsTheBall();
        playerTwoWinsTheBall();
        System.out.println("Winner is : "+this.winner.name + " has the score of: "+ this.winner.score);
        System.out.println("Looser is : "+this.looser.name + " has the score of: "+ this.looser.score);

    }



    void runDeuce() {
        state = "PLAYING";
        playerOneWinsTheBall();
        playerTwoWinsTheBall();
        playerOneWinsTheBall();
        playerTwoWinsTheBall();
        playerOneWinsTheBall();
        playerTwoWinsTheBall();
        playerOneWinsTheBall();
        playerTwoWinsTheBall();
        System.out.println("Player1 has the score of: "+ player1.score);
        System.out.println("Player2 has the score of: "+ player2.score);

    }


    void runPlayerWithAdvantageWinsTheBall() {
        state = "PLAYING";
        playerOneWinsTheBall();
        playerTwoWinsTheBall();
        playerOneWinsTheBall();
        playerTwoWinsTheBall();
        playerOneWinsTheBall();
        playerTwoWinsTheBall();
        playerOneWinsTheBall();
        playerTwoWinsTheBall();
        playerOneWinsTheBall();
        playerOneWinsTheBall();

        System.out.println("Player1 has the score of: "+ player1.score);
        System.out.println("Player2 has the score of: "+ player2.score);

    }






    private void playerTwoWinsTheBall() {
        playerScores(player2);
        player2.winsTheBall=true;
        player1.winsTheBall=false;

        if(state.equals("DEUCE")) {
            player2.hasAdvantage = true;
            player1.hasAdvantage = false;
        }
        updateGameState();
    }

    private void playerOneWinsTheBall() {
        playerScores(player1);

        player2.winsTheBall=false;
        player1.winsTheBall=true;

        if(state.equals("DEUCE")) {
            player1.hasAdvantage = true;
            player2.hasAdvantage = false;
        }
        updateGameState();
    }

    void playerScores(Player player) {

        if (players.contains(player)) {
            player.hasScored();
        }
    }


    void updateGameState() {
        winner=getGameWinner();
        if (winner != null) {
            state = "END";
        } else if (players.get(0).score == 4 && players.get(1).score == 4 && !player1.hasAdvantage && !player2.hasAdvantage) {
            state = "DEUCE";
        } else if (isAdvantage()) {
            state = "ADVANTAGE";
        } else {
            state = "PLAYING";
        }

    }

    private boolean isAdvantage() {
        return players.get(0).score == 4 && players.get(1).score == 4 && (player1.hasAdvantage || player2.hasAdvantage);
    }

    void updatePlayersAdvantageState(Player player) {
        for (Player p : players) {
            if (p != player) {
                p.hasAdvantage = false;
            }
        }
    }



    Player getGameWinner() {
        updatePlayersFinalState();

        return winner;
    }

    Player getGameLooser(){
        updatePlayersFinalState();
        return looser;
    }




    void updatePlayersFinalState() {

        if (players.get(0).getScore() == 4 && players.get(0).getScore() >= players.get(1).getScore() + 2) {
            winner = players.get(0);
            looser=players.get(1);
        }
        else if (players.get(1).getScore() == 4 && players.get(1).getScore() >= players.get(0).getScore() + 2) {
            winner = players.get(1);
            looser=players.get(0);
        }
        else if(player1.hasAdvantage == true && updateBallWinner()==player1 && state.equals("ADVANTAGE")) {
            winner = players.get(0);
            looser=players.get(1);
        }
        else if (player2.hasAdvantage == true && updateBallWinner()==player2 && state.equals("ADVANTAGE")){
            winner = players.get(1);
            looser=players.get(0);
        }


    }


    Player updateBallWinner(){
        if (player1.winsTheBall==true)
            return player1;
      else
            return player2;
    }



}
