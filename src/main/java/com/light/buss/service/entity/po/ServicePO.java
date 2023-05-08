package com.light.buss.service.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "service")
public class ServicePO {
    /*
    *
    */
    @TableId
    private Integer serviceId;
    /*
    *
    */
    private Integer pageId;
    /*
    *方法
    *POST
    *GET
    *PUT
    *DELETE
    */
    private String serviceMethod;
    /*
    *
    */
    private String serviceUrl;
    /*
    *
    */
    private String serviceName;
    /*
    *注释
    */
    private String serviceComment;
    /*
    *
    */
    private String serviceResponseType;
    /*
    *
    */
    private Date createdAt;
    /*
    *
    */
    private Integer isDeleted;
}