package online.niuma.blog.controller;

import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.common.Result;
import online.niuma.blog.vo.params.LoginParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public Result<String> login(@RequestBody LoginParam loginParam) {
        log.info("访问了请求:login");
        log.info("loginParam.userName = {}", loginParam.getUserName());
        log.info("loginParam.userPassword = {}", loginParam.getUserPassword());
        return Result.success("验证成功");
    }
}
