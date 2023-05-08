package com.light.buss.page.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "page")
public class PagePO {
    /*
    *
    */
    @TableId
    private Integer pageId;
    /*
    *母版ID，可以为空
    */
    private Integer masterplatePageId;
    /*
    *
    */
    private Integer parentId;
    /*
    *
    */
    private Integer projectId;
    /*
    *页面名称
    */
    private String pageName;
    /*
    *文件名称
    */
    private String pageFileName;
    /*
    *可访问的角色
    */
    private String pageRoles;
    /*
    *隱藏顯示
    *1: 顯示
    *2:隱藏
    */
    private Integer pageHidden;
    /*
    *路由
    */
    private String pageRouter;
    /*
    *
    */
    private String pageDataList;
    /*
    *
    */
    private Integer pageSort;
    /*
    *页面类型
    *
    *-1:系统登录模版
    *0:普通页面
    *1:登录页面
    */
    private Integer pageType;
    /*
    *
    */
    private String pageStyle;
    /*
    *
    */
    private String pageClass;
    /*
    *
    */
    private String pageLess;
    /*
    *
    */
    private Integer isDeleted;
    /*
    *
    */
    private Date createdAt;
}