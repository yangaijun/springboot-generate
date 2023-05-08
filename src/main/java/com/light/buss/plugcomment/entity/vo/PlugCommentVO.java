package com.light.buss.plugcomment.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class PlugCommentVO extends PageParam {
    /*
    *
    */
    private Integer plugCommentId;
    /*
    *
    */
    private Integer plugId;
    /*
    *
    */
    private Integer parentId;
    /*
    *
    */
    private Integer userId;
    /*
    *
    */
    private String plugCommentContent;
    /*
    *
    */
    private Integer isDeleted;
    /*
    *
    */
    private Date createdAt;
}