package com.light.buss.plug.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "plug")
public class PlugPO {
    /*
    *
    */
    @TableId
    private Integer plugId;
    /*
    *同一个组件同一个ctype,用于区分版本，更新的时候以这个为依据，version + 1
    */
    private Integer plugSameId;
    /*
    *组件缺省type如：cinput
    */
    private String plugTname;
    /*
    *
    */
    private Integer userId;
    /*
    *组件对应的资源id
    */
    private String plugUid;
    /*
    *
    */
    private String plugNpmLibs;
    /*
    *
    */
    private String plugName;
    /*
    *
    */
    private String plugTooltip;
    /*
    *
    */
    private String plugTags;
    /*
    *
    */
    private String plugDes;
    /*
    *
    */
    private Integer plugVersion;
    /*
    *
    */
    private String plugBaseProps;
    /*
    *
    */
    private String plugCustomProps;
    /*
    *star数
    */
    private Integer plugStarCount;
    /*
    *评论数
    */
    private Integer plugCommentCount;
    /*
    *组件使用文档
    */
    private String plugDoc;
    /*
    *收藏数
    */
    private Integer plugFavCount;
    /*
    *组件状态
    *1: private
    *2: public
    */
    private Integer plugStatus;
    /*
    *组件类型，容器，组件？
    *1: 组件 
    *2: 容器
    */
    private Integer plugType;
    /*
    *
    */
    private Integer isDeleted;
    /*
    *
    */
    private String plugLog;
    /*
    *
    */
    private Date createdAt;
}