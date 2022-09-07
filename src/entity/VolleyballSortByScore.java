package entity;

import java.util.Comparator;

public class VolleyballSortByScore implements Comparator<VolleyballClub> {
    public int compare(VolleyballClub a,  VolleyballClub b){
        return b.getScore()-a.getScore();
    }

}
