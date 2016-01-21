/**
 * Created by Romina DRUTA on 21.01.2016.
 */
public enum Score {
    LOVE(0,"0"), FIFTEEN(1,"15"), THIRTY(2,"30"), FORTY(4,"40");

    int value;
    String displayValue;

    Score(int value, String displayValue){
        this.value=value;
        this.displayValue=displayValue;
    }

    public int getValue() {
        return value;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
