package org.james.repository;

import org.james.entity.Team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

public	Team findTeamByTeamname(String name);
public Team  deleteTeamByTeamname(String name);
}
