package com.light.buss.issue.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class IssueVO extends PageParam {
    /*
    *
    */
    private Integer issueId;
    /*
    *
    */
    private Integer userId;
    /*
    *
    */
    private String issueTitle;
    /*
    *
    */
    private String issueContent;
    /*
    *问题类型
    */
    private Integer issueType;
    /*
    *问题评论数量
    */
    private Integer issueCommentCount;
    /*
    *
    */
    private Date createdAt;
    /*
    *
    */
    private Integer isDeleted;
}