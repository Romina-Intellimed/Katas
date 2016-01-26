/**
 * Created by Romina DRUTA on 19.01.2016.
 */
public final class TennisKataGameRules {


    static final int  LOVE=0, FIFTEEN=1, THIRTY=2, FORTY=3;
    static Integer MAX_SERVES_DEUCE =5;



    static String displayResult(int score) {
        String resultScore="";
        switch (score) {
            case LOVE:
                resultScore= "0";
                return resultScore;
            case FIFTEEN:
                resultScore="15";
                return resultScore;
            case THIRTY:
                resultScore="30";
                return resultScore;
            case FORTY:
                resultScore= "40";
                return resultScore;
            default:
                return resultScore;
        }
    }




}
