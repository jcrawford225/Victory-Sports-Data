package org.james.service;
import org.james.repository.*;
import org.james.entity.Team;
import org.james.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {


    private TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    //data inside of it
    private ArrayList<Team> teams = new ArrayList<>();



    public static void save(Team theTeam) {
    }


    public void addTeam(Team team) {
        teamRepository.save(team);
    }

    public Team getTeam(String teamName) {

        /*if (index >= 0 && index < teams.size()) {
            return teams.get(index);
        }*/
       Team team= teamRepository.findTeamByTeamname(teamName);

        return team;
    }

    public void updateTeam(Team team, int index){
        if (index>=0 && index< teams.size()){
            this.teams.set(index, team);

        }
    }

    public void deleteTeam(int index){

        if (index>=0 && index < teams.size()){
            this.teams.remove(index);
        }
    }

    @Override
    public List<Team> findAll() {
        return null;
    }
}
    



