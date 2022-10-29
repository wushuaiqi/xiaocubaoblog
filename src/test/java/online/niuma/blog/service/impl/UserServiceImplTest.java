package online.niuma.blog.service.impl;

import online.niuma.blog.service.UserService;
import online.niuma.blog.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        List<UserVo> users = this.userService.queryUserAll();
        for (UserVo user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    void queryUserOne() {
        String username = "root";
        String password = "becfeaedd72b9f3aeefed8a69b8b3d5a";
        UserVo userVo = this.userService.queryUserOne(username, password);
        System.out.println("userVo = " + userVo);
    }
}