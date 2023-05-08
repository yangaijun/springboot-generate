package com.light.buss.issuecomment.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class IssueCommentVO extends PageParam {
    /*
    *
    */
    private Integer issueCommentId;
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
    private Integer issueId;
    /*
    *
    */
    private String issueCommentContent;
    /*
    *
    */
    private Integer issueCommentStar;
    /*
    *
    */
    private Integer isDeleted;
    /*
    *
    */
    private Date createdAt;
}