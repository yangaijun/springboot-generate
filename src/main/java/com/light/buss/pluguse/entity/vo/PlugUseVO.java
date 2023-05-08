package com.light.buss.pluguse.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class PlugUseVO extends PageParam {
    /*
    *
    */
    private Integer plugUseId;
    /*
    *
    */
    private Integer projectId;
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
    private String plugUseName;
    /*
    *
    */
    private String plugUseType;
    /*
    *
    */
    private Integer plugUseVersion;
    /*
    *
    */
    private Date createdAt;
    /*
    *
    */
    private Integer isDeleted;
}