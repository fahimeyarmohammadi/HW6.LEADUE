package service;

import entity.Club;
import entity.Play;
import entity.SortByScore;
import repository.FootballClubRepository;
import repository.FootballPlayRepository;
import view.TakeFromUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
        else
            takeFromUser.notExist();
    }

    @Override
    public void addPlayToLeague() throws SQLException {
        Play play;
        play = takeFromUser.takePlayFromUser();
        Play playe = new Play(play.getSecondClub(), play.getFirstClub()
                , play.getNumberOfGoalClub2(), play.getNumberOfGoalClub1());
        footballPlayRepository.insertPlay(play);
        footballPlayRepository.insertPlay(playe);
        List<Play> plays = new ArrayList<>();
        if (footballClubRepository.isExist(play.getFirstClub())) {
            plays = footballPlayRepository.selectByName(play.getFirstClub());
            Club club = new Club(play.getFirstClub(), plays);
            footballClubRepository.updateClub(club);
        } else {
            plays.add(play);
            Club club = new Club(play.getFirstClub(), plays);
            footballClubRepository.addClub(club);
        }
        List<Play> playList = new ArrayList<>();
        if (footballClubRepository.isExist(playe.getFirstClub())) {
            playList = footballPlayRepository.selectByName(playe.getFirstClub());
            Club club = new Club(playe.getFirstClub(), playList);
            footballClubRepository.updateClub(club);
        } else {
            playList.add(playe);
            Club club = new Club(playe.getFirstClub(), playList);
            footballClubRepository.addClub(club);
        }
    }

    @Override
    public String showClubInformation() throws SQLException {
        String name = takeFromUser.takeNameForViewInformation();
        if (footballClubRepository.isExist(name))
            return (footballClubRepository.viewClubInformation(name).toString());
        else
            return ("not exist");
    }

    @Override
    public String ShowClubSorted() throws SQLException {
        List<Club> clubList = new ArrayList<>();
        clubList = footballClubRepository.showFootballClubSorted();
        Collections.sort(clubList, new SortByScore());
        return (clubList.toString());
    }
}