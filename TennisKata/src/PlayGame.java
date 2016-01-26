import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romina DRUTA on 18.01.2016.
 */
public class PlayGame {

    GameState gameState = GameState.START;
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

        startGame = true;


        while (gameIsInPlaying()) {

            playOneServe();
            updateGameState();
        }

        return "END";
    }





    protected boolean gameIsInPlaying() {
        return getGameState() != GameState.IS_GAME_WIN && countDeuce <= TennisKataGameRules.MAX_SERVES_DEUCE;
    }


    void playOneServe() {
        Player ballWinner = getBallWinner();

        updatePlayersAdvantageState(ballWinner);

        System.out.println("Player1: " + player1.getName() + " score: " + TennisKataGameRules.displayResult(player1.getScore()) + " " + TennisKataTools.isWinTheBall(player1.winTheBall));
        System.out.println("Player2: " + player2.getName() + " score: " + TennisKataGameRules.displayResult(player2.getScore()) + " " + TennisKataTools.isWinTheBall(player2.winTheBall));


    }

    Player getBallWinner() {
        Player player = TennisKataTools.randomPlayer(playersList);
        player.winTheBall=true;
        player.addPoints();
        return player;
    }




    Player getBallLooser(Player ballWinner) {
        Player ballLooser = TennisKataTools.noPlayer;
        for (int i = 0; i < playersList.size(); i++) {
            if (i != playersList.indexOf(ballWinner)) {

                ballLooser = playersList.get(i);
                ballLooser.winTheBall=false;
                break;
            }
        }
        return ballLooser;
    }



    void updatePlayersAdvantageState(Player winner) {
        if (isDeuce()) {
            winner.hasAdvantage = true;
            winner.hasGameBall = true;
            getBallLooser(winner).hasAdvantage = false;
            getBallLooser(winner).hasGameBall = false;

            System.out.println(winner.getName() + " has advantage and has the ball");
        } else if(isAdvantage() && winner.hasAdvantage==false){

            getBallLooser(winner).hasAdvantage = false;
            getBallLooser(winner).hasGameBall = false;
            winner.hasGameBall=false;
        }


    }

    GameState getGameState() {

        return gameState;
    }

    void updateGameState() {

        if (getGameWinner() != null) {
            gameState = GameState.IS_GAME_WIN;
            System.out.println("The game is WON state");
        } else if (isDeuce()) {
            countDeuce++;
            gameState = GameState.IS_GAME_DEUCE;
            System.out.println("The game is in DEUCE state");
        } else if (startGame) {
            gameState = GameState.PLAY;
            System.out.println("The game is in PLAY state");
        }
        else if(isAdvantage()){
            gameState=GameState.IS_GAME_ADVANTAGE;
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
        return (player1.score == TennisKataGameRules.FORTY && player2.score == TennisKataGameRules.FORTY && !isAdvantage());

    }

    Boolean isAdvantage(){
        return (player1.hasAdvantage == true || player2.hasAdvantage == true);
    }

}
