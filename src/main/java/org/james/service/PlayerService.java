package org.james.service;

import java.util.List;

import org.james.entity.Player;

public interface PlayerService {
    void save(Player thePlayer);

    List<Player> findAll();

    Player findByDivision (String theDivision);

    void deleteByDivision(String division);

     void delete(int playerNumber);

     Player findById(int playerNumber);

}