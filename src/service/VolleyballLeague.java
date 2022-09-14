package service;

import entity.Play;
import entity.VolleyballClub;
import entity.VolleyballSortByScore;
import repository.VolleyballClubRepository;
import repository.VolleyballPlayRepository;
import view.TakeFromUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VolleyballLeague implements League {

    VolleyballPlayRepository volleyballPlayRepository = new VolleyballPlayRepository();
    VolleyballClubRepository volleyballClubRepository = new VolleyballClubRepository();
    TakeFromUser takeFromUser = new TakeFromUser();

    public VolleyballLeague() throws SQLException {
    }

    public void creatVolleyballTable() throws SQLException {
        volleyballClubRepository.creatVolleyballClubTable();
        volleyballPlayRepository.volleyballPlayTable();
    }

    @Override
    public void addClubToLeague() throws SQLException {
        VolleyballClub club;
        club = takeFromUser.takeVolleyballClub();
        volleyballClubRepository.addVolleyballClub(club);
    }

    @Override
    public void deleteClubFromLeague() throws SQLException {
        String name = takeFromUser.clubNameForDelete();
        if (volleyballClubRepository.isExist(name))
            volleyballClubRepository.deleteVolleyballClub(name);
        else
            takeFromUser.notExist();
    }

    @Override
    public void addPlayToLeague() throws SQLException {
        Play play;
        play = takeFromUser.takePlayFromUser();
        volleyballPlayRepository.insertPlay(play);
        Play playe = new Play(play.getSecondClub(), play.getFirstClub(),
                play.getNumberOfGoalClub2(), play.getNumberOfGoalClub1());
        volleyballPlayRepository.insertPlay(playe);
        List<Play> plays = new ArrayList<>();
        if (volleyballClubRepository.isExist(play.getFirstClub())) {
            plays = volleyballPlayRepository.selectByNameVolleyball(play.getFirstClub());
            VolleyballClub club = new VolleyballClub(play.getFirstClub(), plays);
            volleyballClubRepository.updateVolleyballClub(club);
        } else {
            plays.add(play);
            VolleyballClub club1 = new VolleyballClub(play.getFirstClub(), plays);
            volleyballClubRepository.addVolleyballClub(club1);
        }
        List<Play> playList = new ArrayList<>();
        if (volleyballClubRepository.isExist(playe.getFirstClub())) {
            playList = volleyballPlayRepository.selectByNameVolleyball(playe.getFirstClub());
            VolleyballClub club = new VolleyballClub(playe.getFirstClub(), playList);
            volleyballClubRepository.updateVolleyballClub(club);
        } else {
            playList.add(playe);
            VolleyballClub club = new VolleyballClub(playe.getFirstClub(), playList);
            volleyballClubRepository.addVolleyballClub(club);
        }
    }

    @Override
    public String showClubInformation() throws SQLException {
        String name = takeFromUser.takeNameForViewInformation();
        if (volleyballClubRepository.isExist(name))
            return (volleyballClubRepository.viewVolleyballClubInformation(name).toString());
        else
            return ("no exist");
    }

    @Override
    public String ShowClubSorted() throws SQLException {
        List<VolleyballClub> clubList = new ArrayList<>();
        clubList = volleyballClubRepository.showVolleyballClubSorted();
        Collections.sort(clubList, new VolleyballSortByScore());
        return (clubList.toString());
    }
}