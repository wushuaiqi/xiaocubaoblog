package com.niuma.blog.mapper;

import com.niuma.blog.pojo.Users;
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

    List<Users> queryUsersAll();
}
