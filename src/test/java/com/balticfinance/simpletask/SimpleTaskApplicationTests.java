package com.balticfinance.simpletask;

import com.balticfinance.simpletask.model.User;
import com.balticfinance.simpletask.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;



@SpringBootTest ()
@AutoConfigureMockMvc
class SimpleTaskApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;


    @Test
    public void shouldReturnAllUsers () throws Exception{


        when (userService.retrieveAllUsersDetails ())
                .thenReturn (List.of (new User ("Anna" , "Hansen" , "Danish" , 28) ,
                        new User ("Mark" , "Eriksen" , "Norwegian" , 30) ,
                        new User ("Fritz" , "Petersen" , "German" , 48)));

        this.mockMvc
                .perform (MockMvcRequestBuilders.get ("/api/users")
                        .with (user ("admin").password ("admin").roles ("USER")))
                .andExpect (MockMvcResultMatchers.status ().isOk ())
                .andExpect (MockMvcResultMatchers.jsonPath ("$.size()").value (3))
                .andExpect (MockMvcResultMatchers.jsonPath ("$[0].Firstname").value ("Anna"))
                .andExpect (MockMvcResultMatchers.jsonPath ("$[0].Lastname").value ("Hansen"))
                .andExpect (MockMvcResultMatchers.jsonPath ("$[0].Citizenship").value ("Danish"))
                .andExpect (MockMvcResultMatchers.jsonPath ("$[0].Age").value (28))
                .andExpect (MockMvcResultMatchers.jsonPath ("$[1].Firstname").value ("Mark"))
                .andExpect (MockMvcResultMatchers.jsonPath ("$[1].Lastname").value ("Eriksen"))
                .andExpect (MockMvcResultMatchers.jsonPath ("$[1].Citizenship").value ("Norwegian"))
                .andExpect (MockMvcResultMatchers.jsonPath ("$[1].Age").value (30))
                .andExpect (MockMvcResultMatchers.jsonPath ("$[2].Firstname").value ("Fritz"))
                .andExpect (MockMvcResultMatchers.jsonPath ("$[2].Lastname").value ("Petersen"))
                .andExpect (MockMvcResultMatchers.jsonPath ("$[2].Citizenship").value ("German"))
                .andExpect (MockMvcResultMatchers.jsonPath ("$[2].Age").value (48)
                );
    }


}
