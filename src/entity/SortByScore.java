package entity;

import java.util.Comparator;

 public class SortByScore implements Comparator<Club> {

     public int compare(Club a,  Club b){
         return b.getScore()-a.getScore();
     }
}
