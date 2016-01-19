/**
 * Created by Romina DRUTA on 19.01.2016.
 */
public class TennisKataMain {

    public static void main(String[] args) {
       Player player1=new Player("Federer");
       Player player2=new Player("Nadal");

       PlayGame playGame=new PlayGame(player1,player2);


        System.out.println("Result - the winner is: "+playGame.startGame());
        System.out.println("Player1: "+player1.getName()+" "+GameRules.displayResult(player1.getScore())+" "+player1.winTheBall.toString());
        System.out.println("Player2: "+player2.getName()+" "+GameRules.displayResult(player2.getScore())+" "+player2.winTheBall.toString());

    }


}
