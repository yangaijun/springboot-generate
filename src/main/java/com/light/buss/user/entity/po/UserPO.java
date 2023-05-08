package com.light.buss.user.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "user")
public class UserPO {
    /*
    *
    */
    @TableId
    private Integer userId;
    /*
    *头像KEY
    */
    private String userAvatar;
    /*
    *帐号
    */
    private String userAccount;
    /*
    *用户名
    */
    private String userName;
    /*
    *
    */
    private String userPassword;
    /*
    *邮箱
    */
    private String userEmail;
    /*
    *手机号
    */
    private String userPhone;
    /*
    *职业
    */
    private String userMajor;
    /*
    *用户城市
    */
    private String userCity;
    /*
    *
    */
    private Integer userMaxPage;
    /*
    *
    */
    private Integer userMaxProject;
    /*
    *下载次数
    */
    private Integer downloadCount;
    /*
    *
    */
    private Date createdAt;
    /*
    *
    */
    private Integer isDeleted;
}