package online.niuma.blog.service;

import online.niuma.blog.pojo.Users;
import online.niuma.blog.vo.UserVo;

import java.util.List;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
public interface UserService {
    /**
     * 调用持久层对应的方法查询所有用户的信息
     * @return 所有用户的信息
     */
    List<UserVo> queryUserAll();

    /**
     * 根据用户名和密码调用持久成相应的方法获取用户的信息
     * @param username 用户名
     * @param password 用户密码
     * @return 获取到的结果
     */
    UserVo queryUserOne(String username, String password);
}
