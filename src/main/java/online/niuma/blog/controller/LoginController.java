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

    /**
     * 登陆请求
     * todo 调用 Service 层对应的登陆方法获取用户的信息
     * 如果查询到了用户的信息则表示登陆成功
     * @param loginParam 用户登陆请求的封装对象
     * @param session HttpSession
     * @return 如果登陆成功则返回成功和用户的信息反之返回错误信息
     */
    @PostMapping("/login.do")
    public Result<UserVo> loginDo(LoginParam loginParam, HttpSession session) {
        log.info("request utl: /login.do");
        Result<UserVo> loginInfo = this.loginService.login(loginParam);
        Integer code = 200;
        if (code.equals(loginInfo.getCode())) {
            // 如果验证成功则将用户的信息存入 session 中
            session.setAttribute(Constants.USER_INFO, loginInfo.getData());
        }
        return loginInfo;
    }
}
