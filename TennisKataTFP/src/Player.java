/**
 * Created by romina on 28.01.2016.
 */
public class Player {
    String name;
    Integer score;

    Player(String name){
        this.name=name;
        this.score=0;


    }

    Integer hasScored(){
        score++;
        return score;
    }

    public Integer getScore() {
        return score;
    }

    public String getName() {
        return name;
    }




}
