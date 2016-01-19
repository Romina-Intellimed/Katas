import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Romina DRUTA on 18.01.2016.
 */
public class PlayGame {

    static Integer gameState;
    static Integer ballWinnerId;
    static Integer ballLooserId;
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
        Random randomlyPlayerSelector=new Random();
        Player serverPlayer=playersList.get(randomlyPlayerSelector.nextInt(playersList.size()));
        gameState=GameRules.START;

        while ( getGameState() != 3 ) {
            ballWinnerId=randomlyPlayerSelector.nextInt(playersList.size());
            winner = playersList.get(ballWinnerId);
            winner.winTheBall = true;
            winner.addPoints(1);
            setPlayerAdvantage(player1);
            setPlayerAdvantage(player2);
                    System.out.println("Player1: " + player1.getName() + " " + player1.getScore() + " " + player1.winTheBall.toString());
                    System.out.println("Player2: " + player2.getName() + " " + player2.getScore() + " " + player2.winTheBall.toString());


                    System.out.println("Wins the ball: " + winner.getName());
                    System.out.println("Looses the ball: " + getLooser().getName());

        }



        return winner.getName().toString();
    }


    Player getLooser(){
        Player looser=null;
            for(int i=0;i<playersList.size();i++){
                if(i!=ballWinnerId){
                    ballLooserId=i;
                    looser=playersList.get(i);
                    looser.winTheBall=false;
                }
            }
        return  looser;
    }

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


    Integer getGameState() {
        if (getGameWinner() != null) {
            gameState = GameRules.IS_GAME_WIN;
            System.out.println("The game is WON state");
        }
        else if (isDeuce()) {
            gameState = GameRules.IS_GAME_DEUCE;
            System.out.println("The game is in DEUCE state");
        }
        else {
            gameState = GameRules.PLAY;
            System.out.println("The game is in PLAY state");
        }
        return gameState;
    }


    Player getGameWinner() {
        Player winner = null;
        // define constants 3-forty, 2-thirty...
        if (player1.score==GameRules.FORTY && player1.score > player2.score && player1.winTheBall == true) {
            winner = player1;
        }
        else if ( player2.score==GameRules.FORTY && player2.score > player1.score && player2.winTheBall == true) {
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
        if (player1.score == GameRules.FORTY && player2.score == GameRules.FORTY) {
            gameState = GameRules.IS_GAME_DEUCE;
            isDeuce=true;
            System.out.println("The game is in DEUCE");
            }
        else
            if(whoWinTheBall()!=null && whoWinTheBall().hasAdvantage==false && whoWinTheBall().getScore()==3) {
                gameState = GameRules.IS_GAME_DEUCE;
                isDeuce=true;
                System.out.println("The game is in DEUCE");
            }
        return isDeuce;
    }


    Player whoWinTheBall(){
        Player winnerOfTheBall=null;
        if(player1.winTheBall==true)
            winnerOfTheBall=player1;
        else if(player2.winTheBall==true)
            winnerOfTheBall=player2;
        return winnerOfTheBall;
    }






}
