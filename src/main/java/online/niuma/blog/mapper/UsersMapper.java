package online.niuma.blog.mapper;

import online.niuma.blog.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Mapper
@Repository
public interface UsersMapper {

    /**
     * 查询所有的用户信息
     * @return 所有的用户信息
     */
    List<Users> queryUsersAll();

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 用户密码
     * @return 所查询到的用户信息
     */
    Users queryUserOne(@Param("username") String username, @Param("password") String password);
}
