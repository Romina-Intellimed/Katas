/**
 * Created by Romina DRUTA on 19.01.2016.
 */
public class TennisKataMain {

    public static void main(String[] args) {
       Player player1=new Player("Federer");
       Player player2=new Player("Nadal");

       PlayGame tennisKataPlayGame =new PlayGame(player1,player2);


        System.out.println("Result - the winner is: "+ tennisKataPlayGame.startGame());
        System.out.println("Player1: "+player1.getName()+" "+ TennisKataGameRules.displayResult(player1.getScore())+" "+player1.winTheBall.toString());
        System.out.println("Player2: "+player2.getName()+" "+ TennisKataGameRules.displayResult(player2.getScore())+" "+player2.winTheBall.toString());

    }


}
