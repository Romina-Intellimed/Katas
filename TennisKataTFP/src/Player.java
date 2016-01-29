/**
 * Created by romina on 28.01.2016.
 */
public class Player {
    String name;
    Integer score;
    Boolean winsTheBall;
    Boolean hasAdvantage;


    Player(String name){
        this.name=name;
        this.score=0;
        winsTheBall=false;
        hasAdvantage=false;
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


    public Boolean getWinsTheBall() {
        return winsTheBall;
    }

    public void setWinsTheBall(Boolean winsTheBall) {
        this.winsTheBall = winsTheBall;
    }


    public Boolean getHasAdvantage() {
        return hasAdvantage;
    }

    public void setHasAdvantage(Boolean hasAdvantage) {
        this.hasAdvantage = hasAdvantage;
    }
}
