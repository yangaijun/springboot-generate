package com.light.buss.plugsame.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class PlugSameVO extends PageParam {
    /*
    *
    */
    private Integer plugSameId;
    /*
    *最后的组件id
    */
    private Integer lastPlugId;
    /*
    *
    */
    private Integer isDeleted;
    /*
    *
    */
    private Date createdAt;
}