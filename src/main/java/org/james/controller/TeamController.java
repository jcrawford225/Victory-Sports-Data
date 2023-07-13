package org.james.controller;




import org.james.entity.Team;
import org.james.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;


    public TeamController(TeamService theTeamService){teamService=theTeamService;;}



    @GetMapping("/listTeams")
    public String listTeams(Model theModel) {
        //get players from db

        List<Team> theTeams = TeamService.findALL();
        //add to the spring model
        theModel.addAttribute("teams", theTeams);

        return "list-teams";
    }

    @GetMapping("/showTeamFormForAdd")
    public String showTeamFormForAdd(Model themodel) {

        //create the model attribute to bind the data

        Team theTeam = new Team();

        themodel.addAttribute("Team", theTeam);

        return "team-form";

    }


    @GetMapping("/showTeamFormForUpdate")

    public String showTeamFormforUpdate(@RequestParam("Division") String Name, Model theModel) {
        //get players from service
        Team theTeam = (Team) TeamService.findALL();

        //set player in the model to preppoulate the form
        theModel.addAttribute("Team", theTeam);

        //send over to our form


        return "team-form";


    }


    @PostMapping("/Save")

    public String savePlayer(@ModelAttribute("Team") Team theTeam) {
        //save the player
        TeamService.save(theTeam);
        //use a redirect to prevent duplicate submissions
        return "redirect:/teams/list";

    }



    }











     //This might not be needed
    /*@GetMapping("/delete")

 public String delete(@RequestParam("userNumber") String userNumber) {

     //delete the users
     UserService.deleteByuserNumber(userNumber);

     //redirect to players list
     return "redirect:/users/list";

 }@GetMapping (value = "team/sports.data")
    public Team getDefaultTeam(){

        return new Team();
    }

      // localhost:8080/teams/sports.data/2
    /*@GetMapping( "team/sports.data/{index}")
     public Team getTeamAtIndex(@PathVariable String teamName){
      return service.getTeam(teamName);
     }*/


    // localhost:8080/teams/sports.data/

   /* @PostMapping("team/sports.data")
     public void addTeam(@RequestBody Team team){

      service.addTeam(team);
     }

    /* // localhost:8082/teams/sports.data/2
     @RequestMapping(method = RequestMethod.PUT, value = "team/sports.data/{index}")
    public void  updateTeam(@RequestBody  Team team, @PathVariable  int index){

      service.updateTeam(team, index);
    }


    // localhost:8080/teams/sports.data/2
   /* @RequestMapping(method = RequestMethod.DELETE, value = "team/sports.data/{index}")
    public  void  deleteCar(@PathVariable  int index){

      service.deleteTeam(index);

    }*/


