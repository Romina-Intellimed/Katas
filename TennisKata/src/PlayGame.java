import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Romina DRUTA on 18.01.2016.
 */
public class PlayGame {

    static Integer gameState=TennisKataGameRules.START;
    static Boolean start=false;
    static Integer MAX_SERVES_DEUCE=5;

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



    String startGame(){
        Player winner=null;
        Player serverPlayer=TennisKataTools.randomPlayer(playersList);
        start=true;


        while ( getGameState() != TennisKataGameRules.IS_GAME_WIN ) {

            setWinnerOfTheBall();

            // set false advantage for the other player - updatePlayersAdvantageState - > other method - update player advantage
            setPlayerAdvantage(player1);
            setPlayerAdvantage(player2);
            // player1.winTheBall.toString() - explain it
                    System.out.println("Player1: " + player1.getName() + " " + player1.getScore() + " " + TennisKataTools.isWinTheBall(player1.winTheBall));
                    System.out.println("Player2: " + player2.getName() + " " + player2.getScore() + " " + TennisKataTools.isWinTheBall(player2.winTheBall));

            updateGameState();
        }
        return winner.getName().toString();
    }


    Player getWinnerOfTheBall(){
        Player winnerOfTheBall=null;
        if(player1.winTheBall==true)
            winnerOfTheBall=player1;
        else if(player2.winTheBall==true)
            winnerOfTheBall=player2;
        return winnerOfTheBall;
    }

    void setWinnerOfTheBall(){
        Player ballWinner;
        ballWinner = TennisKataTools.randomPlayer(playersList);
        ballWinner.winTheBall = true;
        ballWinner.addPoints(1);
    }



 /*   Player getLooser(){
        Player looser=null;
            for(int i=0;i<playersList.size();i++){
                if(i!=ballWinnerId){
                    ballLooserId=i;
                    looser=playersList.get(i);
                    looser.winTheBall=false;
                }
            }
        return  looser;
    } */

    void setBallWinner(Player player){

    }


    void setPlayerAdvantage(Player player){

        if(player.winTheBall=true && isDeuce()){
                player.hasAdvantage=true;
                player.hasGameBall=true;
            System.out.println(player.getName()+" has advantage and has the ball");
            //    int indexCurrentPlayer=playersList.indexOf(player);
        }
        else if(player.winTheBall=false && !isDeuce()){

            player.hasAdvantage=false;
            player.hasGameBall=false;
            System.out.println(player.getName()+" has no advantage and has not the ball");

        }

    }

// put a flag not to pass more than 5 times if game is in deuce


    Integer getGameState(){

        return gameState;
    }

    void updateGameState() {

        if (getGameWinner() != null) {
            gameState = TennisKataGameRules.IS_GAME_WIN;
            System.out.println("The game is WON state");
        }
        else if (isDeuce()) {
            gameState = TennisKataGameRules.IS_GAME_DEUCE;
            System.out.println("The game is in DEUCE state");
        }
        else if (start) {
            gameState = TennisKataGameRules.PLAY;
            System.out.println("The game is in PLAY state");
        }

    }



    Player getGameWinner() {
        Player winner = null;

        if (player1.score== TennisKataGameRules.FORTY && player1.score > player2.score && player1.winTheBall == true) {
            winner = player1;
        }
        else if ( player2.score== TennisKataGameRules.FORTY && player2.score > player1.score && player2.winTheBall == true) {
            winner = player2;

        }
        else if (player1.hasAdvantage == true && player1.winTheBall == true) {
            winner = player1;
        }
        else if (player2.hasAdvantage == true && player2.winTheBall == true) {
            winner = player2;
        }
        return winner;
    }





    Boolean isDeuce() {
        Boolean isDeuce=false;
        if (player1.score == TennisKataGameRules.FORTY && player2.score == TennisKataGameRules.FORTY) {

                isDeuce=true;
            System.out.println("The game is in DEUCE");
            }
      /*   else
           if(whoWinTheBall()!=null && whoWinTheBall().hasAdvantage==false && whoWinTheBall().getScore()==TennisKataGameRules.FORTY) {
                 isDeuce=true;
            System.out.println("The game is in DEUCE");
            } */
        else{
                isDeuce=false;
            }
        return isDeuce;
    }






}
