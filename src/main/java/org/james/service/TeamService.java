package org.james.service;

import org.james.entity.Team;

import java.util.List;

public interface TeamService {
    static void save(Team theTeam) {
    }

    static List<Team> findALL() {
        return null;
    }


    public void addTeam(Team team);
    public Team getTeam(String team);
    public void updateTeam(Team team, int index);
    public void deleteTeam(int index);

    List<Team>findAll();

}
