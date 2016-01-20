import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romina DRUTA on 18.01.2016.
 */
public class PlayGame {

    Integer gameState = TennisKataGameRules.START;
    Boolean startGame = false;

    Integer countDeuce = 0;

    Player player1;
    Player player2;
    List<Player> playersList;

    PlayGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        playersList = new ArrayList<Player>();
        playersList.add(player1);
        playersList.add(player2);
    }


    String startGame() {
        Player winner = TennisKataTools.noPlayer;
        startGame = true;


        while (gameIsInPlaying()) {

            updatePlayersState();
            updatePlayersAdvantageState(winner);
            // set false advantage for the other player - updatePlayersAdvantageState - > other method - update player advantage
            System.out.println("Player1: " + player1.getName() + " score: " + player1.getScore() + " " + TennisKataTools.isWinTheBall(player1.winTheBall));
            System.out.println("Player2: " + player2.getName() + " score: " + player2.getScore() + " " + TennisKataTools.isWinTheBall(player2.winTheBall));

            updateGameState();
        }

        return "END";
    }

    private boolean gameIsInPlaying() {
        return getGameState() != TennisKataGameRules.IS_GAME_WIN && countDeuce <= TennisKataGameRules.MAX_SERVES_DEUCE;
    }


    void updatePlayersState() {
        Player ballWinner = getBallWinner();
        Player ballLooser = getBallLooser(ballWinner);

        ballWinner.winTheBall = true;
        ballWinner.addPoints(1);
        ballLooser.winTheBall = false;

    }

    Player getBallWinner() {
        return TennisKataTools.randomPlayer(playersList);
    }

    Player getBallLooser(Player ballWinner) {
        Player ballLooser = TennisKataTools.noPlayer;
        for (int i = 0; i < playersList.size(); i++) {
            if (i != playersList.indexOf(ballWinner)) {

                ballLooser = playersList.get(i);

            }
        }
        return ballLooser;
    }


    Player updatePlayersAdvantageState(Player winner) {
        if (isDeuce()) {
            winner.hasAdvantage = true;
            winner.hasGameBall = true;
            getBallLooser(winner).hasAdvantage = false;
            getBallLooser(winner).hasGameBall = false;

            System.out.println(winner.getName() + " has advantage and has the ball");
        } else if (!isDeuce()) {

            //winner.hasAdvantage=false;
            //winner.hasGameBall=false;
            //System.out.println(winner.getName()+" has no advantage and has not the ball");

        }

        return null;
    }

    Integer getGameState() {

        return gameState;
    }

    void updateGameState() {

        if (getGameWinner() != null) {
            gameState = TennisKataGameRules.IS_GAME_WIN;
            System.out.println("The game is WON state");
        } else if (isDeuce()) {
            countDeuce++;
            gameState = TennisKataGameRules.IS_GAME_DEUCE;
            System.out.println("The game is in DEUCE state");
        } else if (startGame) {
            gameState = TennisKataGameRules.PLAY;
            System.out.println("The game is in PLAY state");
        }

    }


    Player getGameWinner() {
        Player winner = null;

        if (player1.score == TennisKataGameRules.FORTY && player1.score > player2.score && player1.winTheBall == true) {
            winner = player1;
        } else if (player2.score == TennisKataGameRules.FORTY && player2.score > player1.score && player2.winTheBall == true) {
            winner = player2;

        } else if (player1.hasAdvantage == true && player1.winTheBall == true) {
            winner = player1;
        } else if (player2.hasAdvantage == true && player2.winTheBall == true) {
            winner = player2;
        }
        return winner;
    }


    Boolean isDeuce() {
        Boolean isDeuce = false;
        if (player1.score == TennisKataGameRules.FORTY && player2.score == TennisKataGameRules.FORTY) {

            isDeuce = true;
            System.out.println("The game is in DEUCE");
        }
        else {
            isDeuce = false;
        }
        return isDeuce;
    }


}
