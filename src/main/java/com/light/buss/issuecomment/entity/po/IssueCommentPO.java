package com.light.buss.issuecomment.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "issue_comment")
public class IssueCommentPO {
    /*
    *
    */
    @TableId
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