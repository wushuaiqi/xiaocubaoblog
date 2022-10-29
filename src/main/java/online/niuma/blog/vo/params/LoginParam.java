package online.niuma.blog.vo.params;

import lombok.Data;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 *
 * 前端发送登陆请求时的参数封装
 */
@Data
public class LoginParam {
    /**用户名*/
    private String userName;
    /**密码*/
    private String userPassword;
}
