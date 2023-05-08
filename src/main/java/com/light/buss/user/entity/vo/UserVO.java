package com.light.buss.user.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class UserVO extends PageParam {
    /*
    *
    */
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