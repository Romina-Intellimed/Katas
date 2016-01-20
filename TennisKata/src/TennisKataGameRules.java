/**
 * Created by Romina DRUTA on 19.01.2016.
 */
public final class TennisKataGameRules {


    static final int  LOVE=0, FIFTEEN=1, THIRTY=2, FORTY=3;
    static final int START=0, PLAY=1, IS_GAME_DEUCE=2, IS_GAME_WIN=3;
    static Integer MAX_SERVES_DEUCE =5;


    public enum scoreEnum {
        LOVE,FIFTEEN,THIRTY,FORTY
    }

    public enum gameStateEnum {
        START, PLAY, IS_GAME_DEUCE, IS_GAME_WIN
        }



    static String displayResult(int score) {
        String resultScore="";
        switch (score) {
            case LOVE:
                resultScore= "0";
                break;
            case FIFTEEN:
                resultScore="15";
                break;
            case THIRTY:
                resultScore="30";
                break;
            case FORTY:
                resultScore= "40";
                break;
        }
        return resultScore;

    }

    static String displayGameState(int gameState){
        String state="";

        switch(gameState){
            case START:
                state="start";
            case PLAY:
                state="play";
            case IS_GAME_DEUCE:
                state="deuce";
            case IS_GAME_WIN:
                state="isGameWon";

        }
        return state;

    }



}
