package online.niuma.blog.mapper;

import online.niuma.blog.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
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
}
