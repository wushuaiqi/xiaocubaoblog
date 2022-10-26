package online.niuma.blog.service;

import online.niuma.blog.common.Result;
import online.niuma.blog.vo.UserVo;
import online.niuma.blog.vo.params.LoginParam;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
public interface LoginService {
    /**
     * 验证登陆用户的真实性
     * @param loginParam 用户登陆所携带的参数
     * @return 验证是否成功
     */
    Result<UserVo> login(LoginParam loginParam);
}
