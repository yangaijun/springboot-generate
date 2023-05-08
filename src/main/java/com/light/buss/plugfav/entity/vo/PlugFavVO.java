package com.light.buss.plugfav.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class PlugFavVO extends PageParam {
    /*
    *
    */
    private Integer plugFavId;
    /*
    *
    */
    private Integer userId;
    /*
    *
    */
    private Integer plugId;
    /*
    *
    */
    private Date createdAt;
    /*
    *
    */
    private Integer isDeleted;
}