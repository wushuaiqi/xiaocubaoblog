package online.niuma.blog.service.impl;

import online.niuma.blog.pojo.Users;
import online.niuma.blog.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    void queryUserAll() {
        List<Users> users = this.userService.queryUserAll();
        for (Users user : users) {
            System.out.println("user = " + user);
        }
    }
}