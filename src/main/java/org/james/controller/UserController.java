package org.james.controller;

import java.util.List;

import org.james.entity.User;
import org.james.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;


@Controller
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private static final String Email="crawfordjames245@gmail.com";
    private static final String Password="james";

@GetMapping (value="/")
public String indexPage() {
	
	return "dashboard";
}


@GetMapping(value="/login")
public String loginRequest() {
	//Correct Email and Password
    return "login";
}


@GetMapping("/signup")
public String signUp(Model model)

{
	model.addAttribute("user", new User());
	return "sign-up";
	
	
	
}
@PostMapping("/sign-process")

public String processSignUp(@ModelAttribute User user,BindingResult bindingResult)
{
	return "redirect:/login";
}




@GetMapping("/list/users")
public String listUsers(Model theModel) {
    //get users from db

    List<User> theUsers = userService.findAllUsers();
    //add to the spring model
     theModel.addAttribute("users", theUsers);

    return "users/list-users";
}

@GetMapping("/sign-up")
public String showFormForAdd(Model themodel) {
 //create the model attribute to bind the data
 User theUser = new User();

    themodel.addAttribute("user", theUser);

   return "users/users-form";

}

@GetMapping("/user-update")
public String showFormforUpdate(@RequestParam("email") String email, Model theModel) {
    //get players from service
    User theUser = userService.findUserByEmail(email);

    //set user in the model to preppoulate the form
   theModel.addAttribute("user", theUser);

    //send over to our form

   return "users/users-form";


}


//@PostMapping("/Save")

public String saveUser(@ModelAttribute("User") User theUser) {
    //save the player
    userService.creat(theUser);
    //use a redirect to prevent duplicate submissions
    return "redirect:/users/list";

}

/*@GetMapping("/delete")

public String delete(@RequestParam("userNumber") String userNumber) {

    //delete the users
    UserService.deleteByuserNumber(userNumber);

    //redirect to players list
    return "redirect:/users/list";

}*/

}
