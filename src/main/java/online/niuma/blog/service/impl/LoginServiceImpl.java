package online.niuma.blog.service.impl;

import online.niuma.blog.service.LoginService;
import online.niuma.blog.vo.params.LoginParam;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
public class LoginServiceImpl implements LoginService {
    /**
     * 验证登陆用户的真实性
     * todo 加密密码,调用持久层查询用户
     * @param loginParam 用户登陆所携带的参数
     */
    @Override
    public boolean login(LoginParam loginParam) {
        return false;
    }
}
