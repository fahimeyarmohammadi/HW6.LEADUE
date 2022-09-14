package entity;

import java.util.Objects;

public class Play {
    private String firstClub;
    private String secondClub;
    private int numberOfGoalClub1;
    private int numberOfGoalClub2;
    Statuse statuse;


    public Play(String firstClub, String secondClub, int numberOfGoalClub1, int numberOfGoalClub2) {
        this.firstClub = firstClub;
        this.secondClub = secondClub;
        this.numberOfGoalClub1 = numberOfGoalClub1;
        this.numberOfGoalClub2 = numberOfGoalClub2;
    }

    public Play(String firstClub, String secondClub, int numberOfGoalClub1,
                int numberOfGoalClub2, String stat) {
        this.firstClub = firstClub;
        this.secondClub = secondClub;
        this.numberOfGoalClub1 = numberOfGoalClub1;
        this.numberOfGoalClub2 = numberOfGoalClub2;
        this.statuse = Statuse.valueOf(stat);
    }

    public String getFirstClub() {
        return firstClub;
    }

    public void setFirstClub(String firstClub) {
        this.firstClub = firstClub;
    }

    public String getSecondClub() {
        return secondClub;
    }

    public void setSecondClub(String secondClub) {
        this.secondClub = secondClub;
    }

    public int getNumberOfGoalClub1() {
        return numberOfGoalClub1;
    }

    public void setNumberOfGoalClub1(int numberOfGoalClub1) {
        this.numberOfGoalClub1 = numberOfGoalClub1;
    }

    public int getNumberOfGoalClub2() {
        return numberOfGoalClub2;
    }

    public void setNumberOfGoalClub2(int numberOfGoalClub2) {
        this.numberOfGoalClub2 = numberOfGoalClub2;
    }

    public Statuse getStatuse() {
        if (numberOfGoalClub1 > numberOfGoalClub2)
            statuse = Statuse.WIN;
        if (numberOfGoalClub1 < numberOfGoalClub2)
            statuse = Statuse.LOST;
        if (numberOfGoalClub1 == numberOfGoalClub2)
            statuse = Statuse.EQUAL;
        return statuse;
    }

    public void setStatuse(Statuse statuse) {
        this.statuse = statuse;
    }

    @Override
    public String toString() {
        return "Play" +
                "firstClub='" + firstClub + '\'' +
                ", secondClub='" + secondClub + '\'' +
                ", numberOfGoalClub1=" + numberOfGoalClub1 +
                ", numberOfGoalClub2=" + numberOfGoalClub2 +
                ", statuse=" + statuse ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Play play = (Play) o;
        return numberOfGoalClub1 == play.numberOfGoalClub1 &&
                numberOfGoalClub2 == play.numberOfGoalClub2 &&
                Objects.equals(firstClub, play.firstClub) &&
                Objects.equals(secondClub, play.secondClub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstClub, secondClub,
                numberOfGoalClub1, numberOfGoalClub2);
    }
}


