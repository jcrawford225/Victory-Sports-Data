package org.james.controller;

import java.util.List;

import org.james.entity.Player;
import org.james.entity.Team;
import org.james.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;




@Controller

public class PlayerController {
    private PlayerService playerService;


    public PlayerController(PlayerService thePlayerService) {
        playerService = thePlayerService;
    }

    @GetMapping("/list")
    public String listPlayers(Model theModel) {
        //get players from db

        List<Player> thePlayers = playerService.findAll();
        //add to the spring model
         theModel.addAttribute("players", thePlayers);

        return "list-players";
    }

    @GetMapping("/players/showFormForAdd")

    public String showFormForAdd(Model themodel) {

        //create the model attribute to bind the data

        Player thePlayer = new Player();

        themodel.addAttribute("player", thePlayer);

        return "player-form";

    }


    @GetMapping("/players/showFormForUpdate")

    public String showFormforUpdate(@RequestParam("playerId") Integer playerId, Model theModel) {

        Player thePlayer = playerService.findById(playerId);

        //set player in the model to preppoulate the form
        theModel.addAttribute("player", thePlayer);

        //send over to our form


        return "player-form";

    }


    @PostMapping("/players/save")
    public String savePlayer(@ModelAttribute("player") Player thePlayer) {
        //save the player
        playerService.save(thePlayer);
        //use a redirect to prevent duplicate submissions
        return "redirect:/list";

    }

    @GetMapping("/players/delete")

    public String delete(@RequestParam("playerNumber") Integer playerNumber) {

        //delete the players
        playerService.delete(playerNumber);

        //redirect to players list
        return "redirect:/list";

    }
}
