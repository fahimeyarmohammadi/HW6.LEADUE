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
        else
            takeFromUser.notExist();
    }


    @Override
    public void addPlayToLeague() throws SQLException {
        Play play;
        play = takeFromUser.takePlayFromUser();
        Play playe=new Play(play.getSecondClub(), play.getFirstClub()
                ,play.getNumberOfGoalClub2(), play.getNumberOfGoalClub1());
        footballPlayRepository.insertPlay(play);
        footballPlayRepository.insertPlay(playe);
        List<Play> plays = new ArrayList<>();
        if (footballClubRepository.isExist(play.getFirstClub())) {
            plays=footballPlayRepository.selectByName(play.getFirstClub());
            Club club = new Club(play.getFirstClub(), plays);
            System.out.println(club);
            footballClubRepository.updateClub(club);
        } else {
            plays.add(play);
            Club club = new Club(play.getFirstClub(), plays);
            footballClubRepository.addClub(club);
        }
        List<Play> playList=new ArrayList<>();
        if(footballClubRepository.isExist(playe.getFirstClub())){
            playList=footballPlayRepository.selectByName(playe.getFirstClub());
            Club club=new Club(playe.getFirstClub(), playList);
            footballClubRepository.updateClub(club);
        }else{
            playList.add(playe);
            Club club=new Club(playe.getFirstClub(), playList);
            footballClubRepository.addClub(club);
        }
    }

    @Override
    public void showClubInformation() throws SQLException {
        String name = takeFromUser.takeNameForViewInformation();
        if (footballClubRepository.isExist(name))
            System.out.println(footballClubRepository.viewClubInformation(name));
        else
            takeFromUser.notExist();
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

