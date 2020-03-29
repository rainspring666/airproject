package com.example.demo.service;

import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void sel() {
        User user = userService.Sel(1);
        System.out.println(user.getUser_id());
    }
    @Test
    public void testLogin_user()
    {
        User user = userService.login_user("17786029999","123");
        System.out.println(user.getUser_name());
    }

}