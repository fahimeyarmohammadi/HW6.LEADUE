package view;

import service.FootballLeague;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String answer;

        System.out.println("enter 1 for add club,2 for delete club," +
                "3 for add play,4 for show the club information,5 for show clubs table sorted by score ");
        answer = scanner.nextLine();
        FootballLeague footballLeague = new FootballLeague();
//        footballLeague.creatTable();
        switch (answer) {
            case "1":
                footballLeague.addClubToLeague();
                break;
            case "2":
                footballLeague.deleteClubFromLeague();
                break;
            case "3":
                footballLeague.addPlayToLeague();
                break;
            case "4":
                footballLeague.showClubInformation();
                break;
            case "5":
                footballLeague.ShowClubSorted();
                break;
        }
    }
}

