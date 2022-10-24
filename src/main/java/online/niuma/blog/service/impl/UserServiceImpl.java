package online.niuma.blog.service.impl;

import online.niuma.blog.mapper.UsersMapper;
import online.niuma.blog.pojo.Users;
import online.niuma.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Service
public class UserServiceImpl implements UserService {

    UsersMapper usersMapper;

    @Autowired
    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    /**
     * 获取所有用户的信息
     */
    @Override
    public List<Users> queryUserAll() {
        return this.usersMapper.queryUsersAll();
    }
}
