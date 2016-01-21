/**
 * Created by Romina DRUTA on 18.01.2016.
 */
public class Player {

    String name;
    Integer score=0;
    Boolean winTheBall = false;
    Boolean hasAdvantage = false;
    Boolean hasGameBall=false;

    Player(String name){
        this.name=name;
    }


    // take into the sets
    public Integer addPoints(){

        score = score+1;

        return score;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }



    public Boolean getWinTheBall() {
        return winTheBall;
    }

    public void setWinTheBall(Boolean winTheBall) {
        this.winTheBall = winTheBall;
    }



    public Boolean getHasAdvantage() {
        return hasAdvantage;
    }

    public void setHasAdvantage(Boolean hasAdvantage) {
        this.hasAdvantage = hasAdvantage;
    }




}
