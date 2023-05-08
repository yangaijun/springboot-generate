package com.light.buss.plugstar.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class PlugStarVO extends PageParam {
    /*
    *
    */
    private Integer plugStarId;
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
    private Integer plugStarIam;
    /*
    *
    */
    private Date createdAt;
    /*
    *
    */
    private Integer isDeleted;
}