package service;

import entity.Club;
import entity.League;
import entity.Play;
import repository.FootballClubRepository;
import repository.FootballPlayRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FootballLeague implements League {
    FootballPlayRepository footballPlayRepository=new FootballPlayRepository();
    FootballClubRepository footballClubRepository=new FootballClubRepository();
    Scanner scanner = new Scanner(System.in);

    public FootballLeague() throws SQLException {
    }

    public void creatTable() throws SQLException {
        footballClubRepository.creatFootballClubTable();
        footballPlayRepository.creatFootballPlayTable();
    }
    @Override
    public void addClubToLeague() throws SQLException {
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
        System.out.println("coach name");
        String coach = scanner.nextLine();
        Club club = new Club(name, playList, coach);
        footballClubRepository.addClub(club);
    }

    @Override
    public void deleteClubFromLeague() throws SQLException {
        System.out.println("enter club name for delete");
        String name = scanner.nextLine();
    }

    @Override
    public void addPlayToLeague() throws SQLException {
        System.out.println("enter play information first club name");
        String firstClub = scanner.nextLine();
        System.out.println("second club name");
        String secondClub = scanner.nextLine();
        System.out.println("number of goal first club");
        int numberOfGoalClub1 = parseInt(scanner.nextLine());
        System.out.println("number of goal first club");
        int numberOfGoalClub2 = parseInt(scanner.nextLine());
        Play play = new Play(firstClub, secondClub, numberOfGoalClub1, numberOfGoalClub2);
        footballPlayRepository.insertPlay(play);
    }

    @Override
    public void showClubInformation() throws SQLException {
        System.out.println("enter club name for show");
        String name = scanner.nextLine();
        if(footballClubRepository.viewClubInformation(name)==null)
            System.out.println("this club is not exist");
       else System.out.println(footballClubRepository.viewClubInformation(name));
    }

    @Override
    public void ShowClubSorted() throws SQLException {
        List<Club>clubList=new ArrayList<>();
         clubList=footballClubRepository.showFootballClubSorted();
        for (int i = 0; i <clubList.size(); i++) {
            System.out.println(clubList.get(i));

        }
    }
}

