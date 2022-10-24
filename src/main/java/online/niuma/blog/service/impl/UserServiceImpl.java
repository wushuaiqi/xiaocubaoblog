package online.niuma.blog.service.impl;

import online.niuma.blog.mapper.UsersMapper;
import online.niuma.blog.pojo.Users;
import online.niuma.blog.service.UserService;
import online.niuma.blog.vo.UserVo;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<UserVo> queryUserAll() {
        List<Users> users = this.usersMapper.queryUsersAll();
        return copyList(users);
    }

    private UserVo copy(Users users) {
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(users, userVo);
        userVo.setCreateTime(new DateTime(users.getCreateTime()).toString("yyyy-MM-dd HH:mm"));
        userVo.setUpdateTime(new DateTime(users.getUpdateTime()).toString("yyyy-MM-dd HH:mm"));
        return userVo;
    }

    private List<UserVo> copyList(List<Users> users) {
        ArrayList<UserVo> userVoList = new ArrayList<>();
        for (Users user : users) {
            userVoList.add(copy(user));
        }
        return userVoList;
    }
}
