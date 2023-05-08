package com.light.buss.issue.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "issue")
public class IssuePO {
    /*
    *
    */
    @TableId
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