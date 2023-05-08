package com.light.buss.issuecommentstar.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class IssueCommentStarVO extends PageParam {
    /*
    *
    */
    private Integer issueCommentStarId;
    /*
    *
    */
    private Integer issueCommentId;
    /*
    *
    */
    private Integer issueCommentStarIam;
    /*
    *
    */
    private Integer userId;
    /*
    *
    */
    private Date createdAt;
}