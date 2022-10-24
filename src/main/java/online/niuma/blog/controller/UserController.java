package online.niuma.blog.controller;

import online.niuma.blog.common.Result;
import online.niuma.blog.pojo.Users;
import online.niuma.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取所有用户信息
     */
    @GetMapping("/findUserAll")
    public Result<List<Users>> findUserAll() {
        List<Users> users = this.userService.queryUserAll();
        return Result.success(users);
    }
}
