package online.niuma.blog.controller;

import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.common.Result;
import online.niuma.blog.service.LoginService;
import online.niuma.blog.utils.Constants;
import online.niuma.blog.vo.UserVo;
import online.niuma.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
@Controller
public class LoginController {

    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login() {
        log.info("request utl: /login");
        return "login";
    }

    @PostMapping("/login.do")
    public String loginDo(@RequestBody LoginParam loginParam, HttpSession session) {
        log.info("request utl: /login.do");
        Result<UserVo> loginInfo = this.loginService.login(loginParam);
        Integer code = 200;
        if (code.equals(loginInfo.getCode())) {
            session.setAttribute(Constants.USER_INFO, loginInfo.getData());
            return "index";
        }
        return "redirect:/login";
    }
}
