package com.niuma.blog.mapper;

import com.niuma.blog.pojo.Users;
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
class UsersMapperTest {

    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void queryUsersAllTest() {
        List<Users> users = this.usersMapper.queryUsersAll();
        for (Users user : users) {
            System.out.println(user);
        }
    }

}