package com.balticfinance.simpletask.service;

import com.balticfinance.simpletask.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static List< User > users = new ArrayList<> ();


    /**
     * Hardcoded user list because simple task and fix data
     * If we have large number of data then I create a table and also create a datbase class for queries
     */

    static {
        //Initialize Data
        User user1 = new User("Anna", "Hansen", "Danish", 28);
        User user2 = new User("Mark", "Eriksen", "Norwegian", 30);
        User user3 = new User("Fritz", "Petersen", "German", 48);

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }


    /**
     * Service for Get Users List
     */
    public List<User> retrieveAllUsersDetails() {
        return users;
    }

}
