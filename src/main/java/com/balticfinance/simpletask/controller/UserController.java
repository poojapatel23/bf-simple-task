package com.balticfinance.simpletask.controller;

import com.balticfinance.simpletask.model.User;
import com.balticfinance.simpletask.service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger (UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * GET  request
     *
     * @return the Blank home page
     *
     */
    @GetMapping("/home")
    public String home() {
        return "Home page";
    }

    /**
     * GET  request
     *
     * @return the users list
     *
     */
    @GetMapping (value = "api/users")
    public List<User> getAllUsersDetails() throws IOException{
        List<User> users = userService.retrieveAllUsersDetails ();

        //POJO and print them in console
        for(User user : users){
            LOG.info ("Firstname: " + user.getFirstName ());
            LOG.info("Lastname: " + user.getLastName ());
            LOG.info("Citizenship: " +user.getCitizenship ());
            LOG.info("Age: " +user.getAge ());

        }

        // Extra Log message for json response
        ObjectMapper mapper = new ObjectMapper ();
        String userList = mapper.writeValueAsString(users);
        LOG.info ("Print Extra Json Response of User Details : "+userList);

        //Return json response as API Output
        return users;
    }
}
