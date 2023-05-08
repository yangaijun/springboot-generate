package com.light.buss.issuecommentstar.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "issue_comment_star")
public class IssueCommentStarPO {
    /*
    *
    */
    @TableId
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