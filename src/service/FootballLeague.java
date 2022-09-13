package service;

import entity.Club;
import entity.Play;
import repository.FootballClubRepository;
import repository.FootballPlayRepository;
import view.TakeFromUser;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FootballLeague implements League {
    FootballPlayRepository footballPlayRepository = new FootballPlayRepository();
    FootballClubRepository footballClubRepository = new FootballClubRepository();
    TakeFromUser takeFromUser = new TakeFromUser();
    Scanner scanner = new Scanner(System.in);

    public FootballLeague() throws SQLException {
    }

    public void creatTable() throws SQLException {
        footballClubRepository.creatFootballClubTable();
        footballPlayRepository.creatFootballPlayTable();
    }

    @Override
    public void addClubToLeague() throws SQLException {
        Club club;
        club = takeFromUser.takeClubFromUser();
        footballClubRepository.addClub(club);
    }

    @Override
    public void deleteClubFromLeague() throws SQLException {
        String name = takeFromUser.clubNameForDelete();
        if (footballClubRepository.isExist(name))
            footballClubRepository.deleteClub(name);
        takeFromUser.notExist();
    }

    @Override
    public void addPlayToLeague() throws SQLException {
        Play play;
        play = takeFromUser.takePlayFromUser();
        footballPlayRepository.insertPlay(play);
        List<Play> plays = new ArrayList<>();
        if (footballClubRepository.isExist(play.getFirstClub())) {
            plays = footballPlayRepository.selectByName(play.getFirstClub());
            plays.add(play);
            Club club = new Club(play.getFirstClub(), plays);
            footballClubRepository.updateClub(club);
        } else {
            plays.add(play);
            Club club1 = new Club(play.getFirstClub(), plays);
            footballClubRepository.addClub(club1);
        }
    }

    @Override
    public void showClubInformation() throws SQLException {
        String name = takeFromUser.takeNameForViewInformation();
        if (footballClubRepository.viewClubInformation(name).getName().equals(null))
            System.out.println("this club is not exist");
        else System.out.println(footballClubRepository.viewClubInformation(name));
    }

    @Override
    public void ShowClubSorted() throws SQLException {
        List<Club> clubList = new ArrayList<>();
        clubList = footballClubRepository.showFootballClubSorted();
        for (int i = 0; i < clubList.size(); i++) {
            System.out.println(clubList.get(i));
        }
    }
}

