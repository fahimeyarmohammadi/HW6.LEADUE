package view;

import entity.Club;
import entity.Play;
import entity.VolleyballClub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TakeFromUser {

        Scanner scanner = new Scanner(System.in);
        public Club takeClubFromUser () {
            System.out.println("enter your club information name");
            String name = scanner.nextLine();
            System.out.println("number of play");
            int numberOfPlay = parseInt(scanner.nextLine());
            List<Play> playList = new ArrayList<>();
            for (int i = 0; i < numberOfPlay; i++) {
                System.out.println("enter  " + i + 1 + " playes information second club name");
                String secondClubName = scanner.nextLine();
                System.out.println("number Of Goal Team1");
                int numberOfGoal1 = parseInt(scanner.nextLine());
                System.out.println("number of goal team 2");
                int numberOfGoal2 = parseInt(scanner.nextLine());
                Play play = new Play(name, secondClubName, numberOfGoal1, numberOfGoal2);
                playList.add(play);
            }
            Club club = new Club(name, playList);
            return club;
        }
        public String clubNameForDelete(){
            System.out.println("enter club name for delete");
            String name = scanner.nextLine();
            return name;
        }
         public Play takePlayFromUser(){
             System.out.println("enter play information first club name");
             String firstClub = scanner.nextLine();
             System.out.println("second club name");
             String secondClub = scanner.nextLine();
             System.out.println("number of goal first club");
             int numberOfGoalClub1 = parseInt(scanner.nextLine());
             System.out.println("number of goal first club");
             int numberOfGoalClub2 = parseInt(scanner.nextLine());
             Play play = new Play(firstClub, secondClub, numberOfGoalClub1, numberOfGoalClub2);
             return play;
         }
         public String takeNameForViewInformation(){
             System.out.println("enter club name for show");
             String name = scanner.nextLine();
             return name;
         }
         public VolleyballClub takeVolleyballClub(){
             System.out.println("enter your club information name");
             String name = scanner.nextLine();
             System.out.println("number of play");
             int numberOfPlay = parseInt(scanner.nextLine());
             List<Play> playList = new ArrayList<>();
             for (int i = 0; i < numberOfPlay; i++) {
                 System.out.println("enter " + i + "playes information second club name");
                 String secondClubName = scanner.nextLine();
                 System.out.println("numberOfGoalTeam1");
                 int numberOfGoal1 = parseInt(scanner.nextLine());
                 System.out.println("number of goal team 2");
                 int numberOfGoal2 = parseInt(scanner.nextLine());
                 Play play = new Play(name, secondClubName, numberOfGoal1, numberOfGoal2);
                 playList.add(play);
             }
             VolleyballClub club = new VolleyballClub(name, playList);
             return club;
         }
         public void notExist(){
             System.out.println("this is not exist");
         }

}
