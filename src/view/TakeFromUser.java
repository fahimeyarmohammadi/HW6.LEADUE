package view;

import entity.Club;
import entity.Play;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Menu {

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
}
