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
     * 在 tb_users 表中查询所有的用户信息
     * user_id 用户的 id
     * user_name 用户名
     * user_nickname 用户的昵称
     * user_password 用户加密后的密码
     * user_avatar 用户的头像地址
     * user_email 用户的邮箱
     * to_email 用户关联的邮箱
     * create_time 创建的时间
     * update_time 修改的时间
     * @return 所有的用户信息
     */
    List<Users> queryUsersAll();

    /**
     * 在 tb_users 表中根据用户名和密码查询用户
     * user_id 用户的 id
     * user_name 用户名
     * user_nickname 用户名昵称
     * user_password 用户的密码
     * user_avatar 用户的头像地址
     * user_email 用户的的邮箱
     * to_email 关联的邮箱
     * create_time 创建的时间
     * update_time 修改的时间
     * @param username 用户名
     * @param password 用户密码
     * @return 所查询到的用户信息
     */
    Users queryUserOne(@Param("username") String username, @Param("password") String password);
}
