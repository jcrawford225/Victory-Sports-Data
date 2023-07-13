package org.james.service;


import org.james.entity.Player;
import org.james.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;


    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    //data inside of it


    private ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        playerRepository.save(player);
    }





    public void updatePlayer(Player player, int index) {

        if (index >= 0 && index < players.size()) {
            this.players.set(index, player);

        }
    }

    @Override
    public void save (Player thePlayer) {
        playerRepository.save(thePlayer);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findByDivision(String theDivision) {
        return null;
    }

    @Override
    public void deleteByDivision(String division) {

    }


    public void delete(int playerNumber) {
        playerRepository.deleteById(playerNumber);
    }

    public Player findById(int playerNumber) {
        return playerRepository.findById(playerNumber).orElse(new Player());
    }
}






	
		
	

