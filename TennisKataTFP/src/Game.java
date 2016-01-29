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
        //todo
        state = "PLAYING";
        playerOneWinsTheBall();
        playerOneWinsTheBall();
        playerOneWinsTheBall();
        playerOneWinsTheBall();
        playerTwoWinsTheBall();
        System.out.println("Winner is : "+this.winner.name + " has the score of: "+ this.winner.score);
        System.out.println("Looser is : "+this.looser.name + " has the score of: "+ this.looser.score);

    }

    private void playerTwoWinsTheBall() {
        playerScores(player2);
        updateGameState();
    }

    private void playerOneWinsTheBall() {
        playerScores(player1);
        updateGameState();
    }

    void playerScores(Player player) {
        if (players.contains(player)) {
            player.winsTheBall = true;
            player.hasScored();
        }
    }


    void updateGameState() {
        if (getGameWinner() != null) {
            winner=getGameWinner();

            state = "END";
        } else if (players.get(0).score == 4 && players.get(1).score == 4 && !isAdvantage()) {
            state = "DEUCE";
        } else if (isAdvantage()) {
            state = "ADVANTAGE";
        } else {
            state = "PLAYING";
            //playerScores(player1);

        }

    }

    private boolean isAdvantage() {
        return players.get(0).score == 4 && players.get(1).score == 4 && (players.get(0).winsTheBall == true || players.get(1).winsTheBall == true);
    }

    void updatePlayersAdvantageState(Player player) {
        player.hasAdvantage = true;
        // player.winsTheBall=false;
        for (Player p : players) {
            if (p != player) {
                p.hasAdvantage = false;
                p.winsTheBall = false;
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
        if (players.get(1).getScore() == 4 && players.get(1).getScore() >= players.get(0).getScore() + 2) {
            winner = players.get(1);
            looser=players.get(2);
        }

    }



}
