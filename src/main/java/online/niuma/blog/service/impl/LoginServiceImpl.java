package online.niuma.blog.service.impl;

import online.niuma.blog.common.ErrorCode;
import online.niuma.blog.common.Result;
import online.niuma.blog.service.LoginService;
import online.niuma.blog.service.UserService;
import online.niuma.blog.vo.UserVo;
import online.niuma.blog.vo.params.LoginParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Value("${login.slat}")
    private String slat;

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 验证登陆用户的真实性
     * todo 加密密码,调用持久层查询用户
     * @param loginParam 用户登陆所携带的参数
     */
    @Override
    public Result<UserVo> login(LoginParam loginParam) {
        String username = loginParam.getUserName();
        String password = loginParam.getUserPassword();
        // 如果用户名或密码为空，则返回参数错误信息
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        password = DigestUtils.md5Hex(password + slat);
        UserVo user = this.userService.queryUserOne(username, password);
        // 如果查询出来的结果为空，则表示账号和密码不正确
        // 返回账号和密码错误的信息
        if (user == null) {
            return Result.fail(ErrorCode.USERNAME_PWD_NOT_EXIST.getCode(), ErrorCode.USERNAME_PWD_NOT_EXIST.getMsg());
        }
        return Result.success(user);
    }
}
