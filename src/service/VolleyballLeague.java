package service;

import entity.Club;
import entity.League;
import entity.Play;
import entity.VolleyballClub;
import repository.VolleyballClubRepository;
import repository.VolleyballPlayRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class VolleyballLeague implements League {

    VolleyballPlayRepository volleyballPlayRepository = new VolleyballPlayRepository();
    VolleyballClubRepository volleyballClubRepository = new VolleyballClubRepository();
    Scanner scanner = new Scanner(System.in);

    public VolleyballLeague() throws SQLException {
    }

    public void creatVolleyballTable() throws SQLException {
        volleyballClubRepository.creatVolleyballClubTable();
        volleyballPlayRepository.volleyballPlayTable();
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
        VolleyballClub club = new VolleyballClub(name, playList);
        volleyballClubRepository.addVolleyballClub(club);
    }

    @Override
    public void deleteClubFromLeague() throws SQLException {
        System.out.println("enter club name for delete");
        String name = scanner.nextLine();
        volleyballClubRepository.deleteVolleyballClub(name);
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
        volleyballPlayRepository.insertPlay(play);
        List<Play> plays = volleyballPlayRepository.selectByNameVolleyball(firstClub);
        if (plays.equals(null)) {
            VolleyballClub club = new VolleyballClub(firstClub, plays);
            volleyballClubRepository.addVolleyballClub(club);
        } else {
            VolleyballClub club = new VolleyballClub(firstClub, plays);
            volleyballClubRepository.updateVolleyballClub(club);
        }

    }

    @Override
    public void showClubInformation() throws SQLException {
        System.out.println("enter club name for show");
        String name = scanner.nextLine();
        if (volleyballClubRepository.viewVolleyballClubInformation(name) == null)
            System.out.println("this club is not exist");
        else System.out.println(volleyballClubRepository.viewVolleyballClubInformation(name));
    }

    @Override
    public void ShowClubSorted() throws SQLException {
        List<VolleyballClub> clubList = new ArrayList<>();
        clubList = volleyballClubRepository.showVolleyballClubSorted();
        for (int i = 0; i < clubList.size(); i++) {
            System.out.println(clubList.get(i));
        }
    }
}