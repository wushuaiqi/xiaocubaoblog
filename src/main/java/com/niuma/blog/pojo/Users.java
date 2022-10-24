package com.niuma.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    private Long userId;

    private String userName;

    private String userNickname;

    private String userPassword;

    private String userAvatar;

    private String userEmail;

    private Date createTime;

    private Date updateTime;
}
