/**
 * Created by Romina DRUTA on 21.01.2016.
 */
public enum GameState {

    START(0), PLAY(1), IS_GAME_DEUCE(2), IS_GAME_ADVANTAGE(3), IS_GAME_WIN(4);

    private int intValue;

    GameState(int value) {
        this.intValue = value;
    }

    public int getIntValue() {
        return intValue;
    }
}
