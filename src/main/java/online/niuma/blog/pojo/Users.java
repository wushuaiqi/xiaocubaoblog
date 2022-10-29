package online.niuma.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public class Users {

    /**
     * 用户 id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户头像链接
     */
    private String userAvatar;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 关联的邮箱
     */
    private String toEmail;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
