package online.niuma.blog.service.impl;

import online.niuma.blog.common.Result;
import online.niuma.blog.service.LoginService;
import online.niuma.blog.service.UserService;
import online.niuma.blog.vo.UserVo;
import online.niuma.blog.vo.params.LoginParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@SpringBootTest
class LoginServiceImplTest {

    @Value("${login.slat}")
    String slat;

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @Test
    void login() {
        String username = "root";
        String password = "passwd2";
        LoginParam loginParam = new LoginParam();
        loginParam.setUserName(username);
        loginParam.setUserPassword(password);
        password = DigestUtils.md5Hex(password + slat);
        Result<UserVo> loginInfo = this.loginService.login(loginParam);
        System.out.println("loginInfo = " + loginInfo);
    }
}