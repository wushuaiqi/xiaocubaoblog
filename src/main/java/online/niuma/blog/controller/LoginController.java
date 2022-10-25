package online.niuma.blog.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.common.Result;
import online.niuma.blog.service.LoginService;
import online.niuma.blog.utils.Constants;
import online.niuma.blog.vo.UserVo;
import online.niuma.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
@RestController
public class LoginController {

    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login.do")
    public Result<UserVo> loginDo(LoginParam loginParam, HttpServletRequest request) {
        log.info("request utl: /login.do");
        log.info("login param : {}", loginParam);
        Result<UserVo> loginInfo = this.loginService.login(loginParam);
        System.out.println("loginInfo.getData() = " + loginInfo.getData());
        Integer code = 200;
        if (code.equals(loginInfo.getCode())) {
            request.getSession().setAttribute(Constants.USER_INFO, loginInfo.getData());
        }
        return loginInfo;
    }
}
