package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VolleyballClub {
    private String name;
    private int numberOfPlay;
    private int numberOfWin;
    private int numberOfLost;
    private int numberOfSetWin;

    private int numberOfSetLost;
    private int score;
    private List<Play> playList = new ArrayList<>();

    public VolleyballClub(String name, List<Play> playList) {
        this.name = name;
        this.playList = playList;
    }

    public VolleyballClub(String name, int numberOfPlay, int numberOfWin, int numberOfLost
            , int score,int numberOfSetWin,int numberOfSetLost) {
        this.name = name;
        this.numberOfPlay = numberOfPlay;
        this.numberOfWin = numberOfWin;
        this.numberOfLost = numberOfLost;
        this.numberOfSetWin=numberOfSetWin;
        this.numberOfSetLost=numberOfSetLost;
        this.score = score;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getScore() {

        for (int i = 0; i < playList.size(); i++) {
            if (playList.get(i).getNumberOfGoalClub1()-playList.get(i).getNumberOfGoalClub2()>1)
                score += 3;
            else if ((playList.get(i).getNumberOfGoalClub1()-playList.get(i).getNumberOfGoalClub2()==1))
                    score+=2;
            else if((playList.get(i).getNumberOfGoalClub1()-playList.get(i).getNumberOfGoalClub2()== -1))
                score+=1;
        }

        return score;
    }

    public void setScore(int score) {
        score = score;
    }

    public int getNumberOfPlay() {
        numberOfPlay = playList.size();
        return numberOfPlay;
    }

    public void setNumberOfPlay(int numberOfPlay) {
        this.numberOfPlay = numberOfPlay;
    }

    public int getNumberOfWin() {
        for (int j = 0; j < playList.size(); j++) {
            if (playList.get(j).getStatuse().toString().equals("WIN")) {
                numberOfWin += 1;
            }
        }
        return numberOfWin;
    }

    public void setNumberOfWin(int numberOfWin) {
        this.numberOfWin = numberOfWin;
    }

    public int getNumberOfLost() {
        for (int j = 0; j < playList.size(); j++) {
            if (playList.get(j).getStatuse().toString().equals("LOST")) {
                numberOfLost += 1;
            }
        }
        return numberOfLost;
    }

    public void setNumberOfLost(int numberOfLost) {
        this.numberOfLost = numberOfLost;
    }

    public int getNumberOfSetWin() {
        for (int i = 0; i < playList.size(); i++)
            numberOfSetWin += playList.get(i).getNumberOfGoalClub1();
        return numberOfSetWin;
    }

    public void setNumberOfSetWin(int numberOfSetWin) {
        this.numberOfSetWin = numberOfSetWin;
    }

    public int getNumberOfSetLost() {
        for (int i = 0; i < playList.size(); i++)
            numberOfSetLost=playList.get(i).getNumberOfGoalClub2();
        return numberOfSetLost;
    }

    public void setNumberOfSetLost(int numberOfSetLost) {
        this.numberOfSetLost = numberOfSetLost;
    }

    @Override
    public String toString() {
        return "VolleyballClub{" +
                "name='" + name + '\'' +
                ", numberOfPlay=" + numberOfPlay +
                ", numberOfWin=" + numberOfWin +
                ", numberOfLost=" + numberOfLost +
                ", numberOfSetWin=" + numberOfSetWin +
                ", numberOfSetLost=" + numberOfSetLost +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VolleyballClub that = (VolleyballClub) o;
        return numberOfPlay == that.numberOfPlay && numberOfWin == that.numberOfWin
                && numberOfLost == that.numberOfLost && numberOfSetWin == that.numberOfSetWin
                && numberOfSetLost == that.numberOfSetLost && score == that.score && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfPlay, numberOfWin, numberOfLost,
                numberOfSetWin, numberOfSetLost, score);
    }
}
