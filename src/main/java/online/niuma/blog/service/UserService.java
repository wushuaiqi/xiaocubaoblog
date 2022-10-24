package online.niuma.blog.service;

import online.niuma.blog.pojo.Users;

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
    List<Users> queryUserAll();
}
