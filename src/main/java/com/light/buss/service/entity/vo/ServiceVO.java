package com.light.buss.service.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class ServiceVO extends PageParam {
    /*
    *
    */
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