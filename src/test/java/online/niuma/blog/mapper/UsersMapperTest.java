package online.niuma.blog.mapper;

import online.niuma.blog.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    public void queryUserOne() {
        String username = "root";
        String password = "passwd";
        Users user = this.usersMapper.queryUserOne(username, password);
        System.out.println("user = " + user);
    }

}