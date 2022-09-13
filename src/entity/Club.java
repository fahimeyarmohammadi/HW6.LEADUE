package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Club {
    private String name;
    private int numberOfPlay;
    private int numberOfWin;
    private int numberOfLost;
    private int numberOfEqual;
    private int drawGoal;
    private int forGoal;
    private int score;
    private List<Play> playList = new ArrayList<>();


    public Club(String name, List<Play> playList) {
        this.name = name;
        this.playList = playList;

    }

    public Club(String name, int numberOfPlay, int numberOfWin, int numberOfLost, int numberOfEqual, int drawGoal, int forGoal, int score) {
        this.name = name;
        this.numberOfPlay = numberOfPlay;
        this.numberOfWin = numberOfWin;
        this.numberOfLost = numberOfLost;
        this.numberOfEqual = numberOfEqual;
        this.drawGoal = drawGoal;
        this.forGoal = forGoal;
        this.score = score;
    }

    public int getScore() {
        for (int i = 0; i < playList.size(); i++) {
            if (playList.get(i).getStatuse().toString().equals("WIN"))
                score += 3;
            if (playList.get(i).getStatuse().toString().equals("EQUAL"))
                score += 1;
        }
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumberOfWin() {

        for (int j = 0; j < playList.size(); j++) {
            if (playList.get(j).getStatuse().toString().equals("WIN")) {
                numberOfWin += 1;
            }
        }
        return numberOfWin;
    }

    public void setNumberOfWin() {

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

    public int getNumberOfEqual() {
        for (int j = 0; j < playList.size(); j++) {
            if (playList.get(j).getStatuse().toString().equals("EQUAL")) {
                numberOfEqual += 1;
            }
        }
        return numberOfEqual;
    }

    public void setNumberOfEqual(int numberOfEqual) {
        this.numberOfEqual = numberOfEqual;
    }

    public int getDrawGoal() {
        for (int i = 0; i < playList.size(); i++)
            drawGoal += playList.get(i).getNumberOfGoalClub1();
        return drawGoal;
    }

    public void setDrawGoal(int drawGoal) {
        this.drawGoal = drawGoal;
    }

    public int getForGoal() {
        for (int i = 0; i < playList.size(); i++)
            forGoal += playList.get(i).getNumberOfGoalClub2();
        return forGoal;
    }

    public void setForGoal(int forGoal) {
        this.forGoal = forGoal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPlay() {
        numberOfPlay = playList.size();
        return numberOfPlay;
    }

    public void setNumberOfPlay(int numberOfPlay) {
        this.numberOfPlay = numberOfPlay;
    }

    @Override
    public String toString() {
        return "Club{" +
                "name='" + name + '\'' +
                ", numberOfPlay=" + numberOfPlay +
                ", numberOfWin=" + numberOfWin +
                ", numberOfLost=" + numberOfLost +
                ", numberOfEqual=" + numberOfEqual +
                ", drawGoal=" + drawGoal +
                ", forGoal=" + forGoal +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return numberOfPlay == club.numberOfPlay && numberOfWin == club.numberOfWin && numberOfLost == club.numberOfLost && numberOfEqual == club.numberOfEqual && drawGoal == club.drawGoal && forGoal == club.forGoal && score == club.score && Objects.equals(name, club.name) && Objects.equals(playList, club.playList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfPlay, numberOfWin, numberOfLost, numberOfEqual, drawGoal, forGoal, score, playList);
    }
}
