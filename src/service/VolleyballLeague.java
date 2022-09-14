package service;

import entity.Club;
import entity.Play;
import entity.VolleyballClub;
import repository.VolleyballClubRepository;
import repository.VolleyballPlayRepository;
import view.TakeFromUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

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
        List<Play> plays = new ArrayList<>();
        if (volleyballClubRepository.isExist(play.getFirstClub())) {
            plays = volleyballPlayRepository.selectByNameVolleyball(play.getFirstClub());
            plays.add(play);
            VolleyballClub club = new VolleyballClub(play.getFirstClub(), plays);
            volleyballClubRepository.updateVolleyballClub(club);
        } else {
            plays.add(play);
            VolleyballClub club1 = new VolleyballClub(play.getFirstClub(), plays);
            volleyballClubRepository.addVolleyballClub(club1);
        }

    }

    @Override
    public void showClubInformation() throws SQLException {
        String name = takeFromUser.takeNameForViewInformation();
        if (volleyballClubRepository.isExist(name))
            volleyballClubRepository.viewVolleyballClubInformation(name);
        else
            takeFromUser.notExist();
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